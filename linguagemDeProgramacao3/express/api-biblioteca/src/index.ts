import express from "express";
import cors from "cors";
import bodyParser from "body-parser";
import BookRouter from "./router/BookRouter";

const app = express();
const port = process.env.APP_PORT || 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cors());

app.use("/api/v1", BookRouter.router);

app.get("/", (req, res) => {
    res.send("Hello World!");
});


app.listen(port, () => {
    console.log(`🚀 Server is running at http://localhost:${port} 🚀`);
});