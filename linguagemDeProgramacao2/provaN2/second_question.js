class Book{
    #title
    #author
    #editor
    #lauchYear
    constructor(title,author,editor,lauchYear){
        this.#title = title
        this.#author = author
        this.#editor = editor
        this.#lauchYear = lauchYear
    }

    getTitle(){
        return this.#title
    }
    setTitle(newTitle){
        this.#title = newTitle
    }
    
    getAuthor(){
        return this.#author
    }
    
    setAuthor(newAuthor){
        this.#author = newAuthor
    }

    getEditor(){
        return this.#editor
    }

    setEditor(newEditor){
        this.#editor = newEditor
    }

    getLauchYear(){
        return this.#lauchYear
    }

    setLauchYear(newLauchYear){
        this.#lauchYear = newLauchYear
    }

    toString(){
        return `This is the book ${this.#title} wrote by ${this.#author} in ${this.#lauchYear}`
    }
}

bookOne = new Book("The pragmatic programmer","Someone","Someone else",1900)
bookTwo = new Book("Other book","Someone's brother","Someone else's sister",2047)

console.log(bookOne.toString())
console.log(bookTwo.toString())