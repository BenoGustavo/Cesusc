import { IBook } from "../types/Book";
import fs from 'fs/promises';

const PATH_TO_DATABASE = "../database/database.json";

export const CreateBookService = async (book: IBook) => {
    try {
        // Read the existing JSON data from the file
        let data;
        try {
            data = await fs.readFile(PATH_TO_DATABASE, 'utf-8');
        } catch (readError) {
            // If the file doesn't exist or is empty, initialize it with an empty array
            if ((readError as NodeJS.ErrnoException).code === 'ENOENT') {
                data = '[]';
            } else {
                throw readError;
            }
        }

        // Parse the JSON data
        let books;
        try {
            console.log(data)
            books = JSON.parse(data);
        } catch (parseError) {
            // If the JSON is invalid, initialize it with an empty array
            books = [];
        }

        // Append the new book to the list
        books.push(book);

        // Write the updated list back to the file
        await fs.writeFile(PATH_TO_DATABASE, JSON.stringify(books, null, 2));

        return book;
    } catch (error) {
        console.error('Error processing the book data:', error);
        throw error;
    }
};