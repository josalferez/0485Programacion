$NAS_IP = "192.168.0.15"
$SHARE_NAME = "app"
$USER = "app"
$PASS = 'Rg?Q5W{I'
$DEST = "\\$NAS_IP\$SHARE_NAME"

Write-Host "Connecting to $DEST..."

# Disconnect if already connected (to avoid conflicts or use fresh creds)
net use $DEST /delete /y 2>$null

# Connect
net use $DEST $PASS /user:$USER
if ($LASTEXITCODE -ne 0) {
    Write-Error "Failed to connect to NAS. Check network and credentials."
    exit 1
}

Write-Host "Connected! Copying files..."

$files = @("server.js", "package.json", "database.json", "index.html", "mobile.html", "style.css", "script.js")

foreach ($file in $files) {
    Copy-Item -Path $file -Destination $DEST -Force
    Write-Host "Copied: $file"
}

# Also copy node_modules if you want to avoid 'npm install' on NAS (optional, but slower)
# Write-Host "Copying node_modules (this may take a while)..."
# Copy-Item -Path "node_modules" -Destination $DEST -Recurse -Force

Write-Host "Files transferred successfully!"
Write-Host "Now SSH into your NAS and run: cd /volume1/app && node server.js"

# Optional: Disconnect
# net use $DEST /delete /y
