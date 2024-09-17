import express from "express";

const app = express();

app.get("/", (req, res) => {
    res.send("Hello World!");
});

const port = process.env.APP_PORT || 3000;

app.listen(port, () => {
    console.log(`🚀 Server is running at http://localhost:${port} 🚀`);
});