const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const fs = require("fs");

const app = express();
const port = 8001;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cors());

const DATA_PATH = "./src/database/materiais.json";

const readData = () => {
  const data = fs.readFileSync(DATA_PATH);
  return JSON.parse(data);
};

const writeData = (data) => {
  fs.writeFileSync(DATA_PATH, JSON.stringify(data, null, 2));
};

// List all materials
app.get("/materiais", (req, res) => {
  const materiais = readData();
  res.status(200).json(materiais);
});

// Create a new material
app.post("/materiais", (req, res) => {
  const materiais = readData();
  const newMaterial = req.body;
  materiais.push(newMaterial);
  writeData(materiais);
  res.status(201).json(newMaterial);
});

// Get material by ID
app.get("/materiais/:id", (req, res) => {
  const materiais = readData();
  const material = materiais.find(m => m.id == req.params.id);
  if (material) {
    res.status(200).json(material);
  } else {
    res.status(404).send("Material not found");
  }
});

// Update material by ID
app.put("/materiais/:id", (req, res) => {
  const materiais = readData();
  const index = materiais.findIndex(m => m.id == req.params.id);
  if (index !== -1) {
    materiais[index] = { ...materiais[index], ...req.body };
    writeData(materiais);
    res.status(200).json(materiais[index]);
  } else {
    res.status(404).send("Material not found");
  }
});

// Delete material by ID
app.delete("/materiais/:id", (req, res) => {
  let materiais = readData();
  const index = materiais.findIndex(m => m.id == req.params.id);
  if (index !== -1) {
    materiais = materiais.filter(m => m.id != req.params.id);
    writeData(materiais);
    res.status(204).send();
  } else {
    res.status(404).send("Material not found");
  }
});

app.get("/", (req, res) => {
  res.send("Hello World!");
});

app.listen(port, () => {
  console.log(`🚀 Server is running at http://localhost:${port} 🚀`);
});