import { IBook } from "../types/Book";

export class Book implements IBook {
    id: number;
    author: string;
    description: string;
    excerpt: string;
    relaseDate: string;
    age: number;
    createdAt: string;
    title: string;
    
    constructor(book: IBook) {
        this.id = book.id;
        this.author = book.author;
        this.description = book.description;
        this.excerpt = book.excerpt;
        this.relaseDate = book.relaseDate;
        this.age = book.age;
        this.createdAt = book.createdAt;
        this.title = book.title;
    }
}