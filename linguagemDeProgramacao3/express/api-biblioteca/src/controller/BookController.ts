import { Book } from "../models/BookModel";
import { Request, Response } from "express";
import { CreateBookService } from "../services/BookService";

export const CreateBookController = async (req: Request<Book>, res: Response) => {
    try{
        console.log("Book");
        const book = new Book(req.body);

        
        return res.status(201).send(CreateBookService(book));
    }catch(error){
        console.log("Deu pau", error);
    }
};