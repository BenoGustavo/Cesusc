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
        attButton.setAttribute("data-bs-toggle", "modal");
        attButton.setAttribute("data-bs-target", "#attLivro")

        attButton.addEventListener('click', () => {
            event.preventDefault()
            document.getElementById("attLivro").style.display = "flex"

            let attLivroButton = document.getElementById("attLivroBtn");

            let newTitulo = document.getElementById("fieldAttTitulo").value = livroUnidade.titulo
            let newAutor = document.getElementById("fieldAttAutor").value = livroUnidade.autor
            let newEditora = document.getElementById("fieldAttEditora").value = livroUnidade.editora
            let newAno = document.getElementById("fieldAttAno").value = livroUnidade.ano
            let newPaginas = document.getElementById("fieldAttPaginas").value = livroUnidade.paginas


            attLivroButton.addEventListener("click", () => {
                event.preventDefault()

                newTitulo = document.getElementById("fieldAttTitulo").value
                newAutor = document.getElementById("fieldAttAutor").value
                newEditora = document.getElementById("fieldAttEditora").value
                newAno = document.getElementById("fieldAttAno").value
                newPaginas = document.getElementById("fieldAttPaginas").value

                console.log(livroUnidade.titulo, newTitulo, newAutor, newEditora, newAno, newPaginas)
                if (newTitulo == "" || newAutor == "" || newEditora == "" || newAno == "" || newPaginas == "") {
                    alert("Preencha todos os campos!")
                    return
                }

                livroController.atualizarLivro(livroUnidade.titulo, newTitulo, newAutor, newEditora, newAno, newPaginas)
                alert('Registro atualizado com sucesso!')
                updateTable()
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