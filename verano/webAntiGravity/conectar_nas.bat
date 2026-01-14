@echo off
color 0A
echo =========================================
echo   CONECTANDO AL NAS (Synology DS223)
echo =========================================
echo.
echo Usuario: app
echo IP: 192.168.0.15
echo.
echo 1. Cuando te pida "password", escribe: Rg?Q5W{I
echo    (Nota: Al escribir la contrasena NO se veran los caracteres en pantalla, es normal)
echo.
echo 2. Una vez dentro, copia y pega esto para reiniciar el servidor:
echo    cd /volume1/app
echo    node server.js
echo.
echo =========================================
echo Presiona ENTER para conectar...
pause >nul

ssh app@192.168.0.15

echo.
echo Conexion cerrada.
pause
