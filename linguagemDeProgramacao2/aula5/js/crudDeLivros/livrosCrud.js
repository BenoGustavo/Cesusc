import { LivroController } from "./livrosClass.js";

const livroController = new LivroController();
livroController.carregarLivros();

let adicionarLivroButton = document.getElementById("adicionarLivro");
let createLivro = document.getElementById("criarLivroBtn")

adicionarLivroButton.addEventListener("click", () => {
    document.getElementById("criarLivro").style.display = "flex";
});


createLivro.addEventListener("click", () => {
    event.preventDefault()

    let tituloField = document.getElementById("fieldTitulo").value;
    let autorField = document.getElementById("fieldAutor").value;
    let editoraField = document.getElementById("fieldEditora").value;
    let anoField = document.getElementById("fieldAno").value;
    let paginasField = document.getElementById("fieldPaginas").value;

    livroController.criarLivro(tituloField, autorField, editoraField, anoField, paginasField);
    updateTable()
});

function updateTable() {
    let tableBodyId = document.getElementById("table-body-id")
    tableBodyId.innerHTML = ""

    let livros = livroController.listarLivros()
    livros.forEach(livroUnidade => {
        let tr = document.createElement("tr")

        Object.keys(livroUnidade).forEach(key => {
            let td = document.createElement('td');
            td.innerHTML = livroUnidade[key];
            tr.appendChild(td);
        });

        let td = document.createElement("td")
        let attButton = document.createElement('button');
        attButton.className = 'btn btn-success';
        attButton.innerHTML = 'Atualizar';
        attButton.addEventListener('click', () => {
            document.getElementById("attLivro").style.opacity = 1
            document.getElementById("attLivro").style.display = "flex"

            let attLivroButton = document.getElementById("attLivroBtn");

            attLivroButton.addEventListener("click", () => {
                let newTitulo = document.getElementById("fieldAttTitulo")
                let newAutor = document.getElementById("fieldAttAutor")
                let newEditora = document.getElementById("fieldAttEditora")
                let newAno = document.getElementById("fieldAttAno")
                let newPaginas = document.getElementById("fieldAttPaginas")

                livroController.atualizarLivro(livroUnidade.titulo, newTitulo, newAutor, newEditora, newAno, newPaginas)
                alert('Registro apagado com sucesso!')
                document.getElementById("attLivro").style.display = "none"
            })
        });
        td.appendChild(attButton);
        tr.appendChild(td);

        let td2 = document.createElement("td")
        let delButton = document.createElement('button');
        delButton.className = 'btn btn-danger';
        delButton.innerHTML = 'Deletar';
        delButton.addEventListener('click', () => {
            livroController.removerLivro(livroUnidade.titulo)
            alert('Registro apagado com sucesso!')
            updateTable()
        });
        td2.appendChild(delButton);
        tr.appendChild(td2);

        tableBodyId.appendChild(tr)
    })
}

updateTable()