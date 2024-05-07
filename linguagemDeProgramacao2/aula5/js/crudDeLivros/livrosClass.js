class Livro {
    #autor
    #titulo
    #editora
    #ano
    #paginas
    constructor(titulo, autor, editora, ano, paginas) {
        this.#titulo = titulo;
        this.#autor = autor;
        this.#editora = editora;
        this.#ano = ano;
        this.#paginas = paginas;
    }

    getAutor() {
        return this.#autor;
    }

    getTitulo() {
        return this.#titulo;
    }

    getEditora() {
        return this.#editora;
    }

    getAno() {
        return this.#ano;
    }

    getPaginas() {
        return this.#paginas;
    }

    setAutor(autor) {
        this.#autor = autor;
    }

    setTitulo(titulo) {
        this.#titulo = titulo;
    }

    setEditora(editora) {
        this.#editora = editora;
    }

    setAno(ano) {
        this.#ano = ano;
    }

    setPaginas(paginas) {
        this.#paginas = paginas;
    }

    toString() {
        return `Título: ${this.#titulo}, Autor: ${this.#autor}, Editora: ${this.#editora}, Ano: ${this.#ano}, Páginas: ${this.#paginas}`;
    }
}

export class LivroController {
    #livros = []
    constructor() {
        this.#livros = []
    }

    criarLivro(titulo, autor, editora, ano, paginas) {
        this.#livros.push(new Livro(titulo, autor, editora, ano, paginas))
        return this.#livros[this.#livros.length - 1]
    }

    atualizarLivro(titulo, autor, editora, ano, paginas) {
        if (!titulo) {
            return alert('Título é obrigatório')
        }

        const livro = this.buscarLivro(titulo)
        if (livro) {
            livro.setAutor(autor)
            livro.setEditora(editora)
            livro.setAno(ano)
            livro.setPaginas(paginas)
        }
    }

    adicionarLivro(livro) {
        this.#livros.push(livro)
    }

    listarLivros() {
        return this.#livros
    }

    buscarLivro(titulo) {
        return this.#livros.find(livro => livro.getTitulo() === titulo)
    }

    removerLivro(titulo) {
        this.#livros = this.#livros.filter(livro => livro.getTitulo() !== titulo)
    }
}