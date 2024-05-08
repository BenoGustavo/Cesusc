class Livro {
    constructor(titulo, autor, editora, ano, paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.paginas = paginas;
    }

    getAutor() {
        return this.autor;
    }

    getTitulo() {
        return this.titulo;
    }

    getEditora() {
        return this.editora;
    }

    getAno() {
        return this.ano;
    }

    getPaginas() {
        return this.paginas;
    }

    setAutor(autor) {
        this.autor = autor;
    }

    setTitulo(titulo) {
        this.titulo = titulo;
    }

    setEditora(editora) {
        this.editora = editora;
    }

    setAno(ano) {
        this.ano = ano;
    }

    setPaginas(paginas) {
        this.paginas = paginas;
    }

    toString() {
        return `Título: ${this.titulo}, Autor: ${this.autor}, Editora: ${this.editora}, Ano: ${this.ano}, Páginas: ${this.paginas}`;
    }
}

export class LivroController {
    #livros = []
    constructor() {
        this.#livros = []
    }

    criarLivro(titulo, autor, editora, ano, paginas) {
        this.#livros.push(new Livro(titulo, autor, editora, ano, paginas))
        this.salvarLivros()
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
        this.salvarLivros()
    }

    adicionarLivro(livro) {
        this.#livros.push(livro)
        this.salvarLivros()
    }

    listarLivros() {
        return this.#livros
    }

    buscarLivro(titulo) {
        return this.#livros.find(livro => livro.getTitulo() === titulo)
    }

    removerLivro(titulo) {
        this.#livros = this.#livros.filter(livro => livro.getTitulo() !== titulo)
        this.salvarLivros()
    }

    toString() {
        return this.#livros.map(livro => livro.toString()).join('\n')
    }

    salvarLivros() {
        localStorage.setItem('livros', JSON.stringify(this.#livros))
    }

    carregarLivros() {
        const livros = JSON.parse(localStorage.getItem('livros'))
        if (livros) {
            livros.forEach(livro => {
                this.adicionarLivro(new Livro(livro.titulo, livro.autor, livro.editora, livro.ano, livro.paginas))
            });
        }
    }
}