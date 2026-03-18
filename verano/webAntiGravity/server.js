const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;
const DB_FILE = path.join(__dirname, 'database.json');

app.use(cors());
app.use(bodyParser.json());
app.use(express.static(__dirname)); // Serve static files (index.html, etc)

// Helper: Read DB
try {
    if (!fs.existsSync(DB_FILE)) {
        throw new Error("File not found");
    }
    const data = fs.readFileSync(DB_FILE, 'utf8');
    return JSON.parse(data);
} catch (err) {
    console.log("Database missing or invalid. creating default...");
    const defaultDB = {
        user: { balance: 100.00 },
        inventory: [
            { id: 1, "title": "Libro 1", "price": 10, "stock": 5 },
            { id: 2, "title": "Libro 2", "price": 30, "stock": 15 },
            { id: 3, "title": "Libro 3", "price": 40, "stock": 20 },
            { id: 4, "title": "Libro 4", "price": 50, "stock": 10 }
        ],
        history: []
    };
    writeDB(defaultDB);
    return defaultDB;
}

// Helper: Write DB
function writeDB(data) {
    try {
        fs.writeFileSync(DB_FILE, JSON.stringify(data, null, 2));
    } catch (err) {
        console.error("Error writing DB:", err);
    }
}

// API Routes

// Get all data (Inventory, Balance, History)
app.get('/api/data', (req, res) => {
    const db = readDB();
    res.json(db);
});

// Recharge Balance
app.post('/api/balance/add', (req, res) => {
    const { amount } = req.body;
    if (!amount || amount <= 0) {
        return res.status(400).json({ error: "Invalid amount" });
    }

    const db = readDB();
    db.user.balance += parseFloat(amount);
    writeDB(db);

    res.json({ success: true, newBalance: db.user.balance });
});

// Place Order
app.post('/api/order', (req, res) => {
    const { total, items } = req.body;
    const db = readDB();

    if (db.user.balance < total) {
        return res.status(400).json({ error: "Insufficient funds" });
    }

    // Deduct Balance
    db.user.balance -= total;

    // Reduce Stock
    items.forEach(item => {
        const book = db.inventory.find(b => b.id === item.id);
        if (book && book.stock > 0) {
            book.stock--;
        }
    });

    // Save History
    const order = {
        id: Date.now(),
        date: new Date().toLocaleString(),
        total: total,
        items: items
    };
    db.history.push(order);

    writeDB(db);

    res.json({ success: true, newBalance: db.user.balance, history: db.history });
});

// Start Server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
    console.log(`Open http://localhost:${PORT} in your browser.`);
});
