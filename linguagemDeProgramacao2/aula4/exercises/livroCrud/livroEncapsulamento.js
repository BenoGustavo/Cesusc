export class livro{
    #titulo
    #autor
    #editora
    #ano
    constructor(titulo, autor, editora, ano){
        this.#titulo = titulo
        this.#autor = autor
        this.#editora = editora
        this.#ano = ano
    }

    set titulo(titulo){
        if(typeof titulo !== 'string') throw new Error('O título do livro deve ser uma string')

        this.#titulo = titulo
    }

    get titulo(){
        return this.#titulo
    }

    set autor(autor){
        if(typeof autor !== 'string') throw new Error('O autor do livro deve ser uma string')

        this.#autor = autor
    }

    get autor(){
        return this.#autor
    }

    set editora(editora){
        if(typeof editora !== 'string') throw new Error('A editora do livro deve ser uma string')

        this.#editora = editora
    }

    get editora(){
        return this.#editora
    }

    set ano(ano){
        if(typeof ano !== 'number') throw new Error('O ano do livro deve ser um número')

        this.#ano = ano
    }

    get ano(){
        return this.#ano
    }


    toString(){
        return `O livro ${this.#titulo} foi escrito por ${this.#autor} em ${this.#ano}.`
    }
}