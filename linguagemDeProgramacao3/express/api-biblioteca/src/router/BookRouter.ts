import express ,{ Request, Response } from "express";
import { CreateBookController } from "../controller/BookController";
import { Book } from "../models/BookModel";

const router = express.Router();

router.post("/create", (req: Request<Book>, res: Response<Book>) => {
    CreateBookController(req,res);
});

export default {router};