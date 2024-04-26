import {livro} from './livroEncapsulamento.js'

let titulo = document.getElementById('titulo')
let autor = document.getElementById('autor')
let editora = document.getElementById('editora')
let ano = document.getElementById('ano')

let criarLivroButton = document.getElementById('criarLivro')

criarLivroButton.addEventListener('click', () => {
    let novoLivro = new livro(titulo.value, autor.value, editora.value, ano.value)

    injectOnTable(novoLivro)
})

function injectOnTable(livro) {
    let table = document.getElementById('tabelaLivros')
    let row = table.insertRow(-1)
    let cell1 = row.insertCell(0)
    let cell2 = row.insertCell(1)
    let cell3 = row.insertCell(2)
    let cell4 = row.insertCell(3)
    cell1.innerHTML = livro.titulo
    cell2.innerHTML = livro.autor
    cell3.innerHTML = livro.editora
    cell4.innerHTML = livro.ano
}