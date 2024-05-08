import { LivroController } from "./livrosClass.js";

const livroController = new LivroController();
livroController.carregarLivros();

populateLocalStorage()

let adicionarLivroButton = document.getElementById("adicionarLivro");
let createLivro = document.getElementById("criarLivroBtn")

adicionarLivroButton.addEventListener("click", () => {
    document.getElementById("criarLivro").style.display = "flex";
});

createLivro.addEventListener("click", () => {
    event.preventDefault()

    let livroFields = getLivroFields("fieldTitulo", "fieldAutor", "fieldEditora", "fieldAno", "fieldPaginas");

    if (livroFields.some(field => field === "")) {
        alert("Preencha todos os campos!")
        return
    }

    if (isBookAlreadyRegistered(livroFields[0])) {
        alert("Livro já cadastrado!")
        return
    }

    livroController.criarLivro(...livroFields);
    updateTable()
    alert("Livro cadastrado com sucesso!")
});

function getLivroFields(tituloId, autorId, editoraId, anoId, paginasId) {
    return [
        document.getElementById(tituloId).value,
        document.getElementById(autorId).value,
        document.getElementById(editoraId).value,
        document.getElementById(anoId).value,
        document.getElementById(paginasId).value
    ];
}

function setLivroFields(tituloId, autorId, editoraId, anoId, paginasId, livro) {
    document.getElementById(tituloId).value = livro.titulo
    document.getElementById(autorId).value = livro.autor
    document.getElementById(editoraId).value = livro.editora
    document.getElementById(anoId).value = livro.ano
    document.getElementById(paginasId).value = livro.paginas
}

function isBookAlreadyRegistered(titulo) {
    let livros = livroController.listarLivros()
    return livros.some(livro => livro.titulo === titulo)
}

function createButton(className, innerHTML, clickHandler) {
    let button = document.createElement('button');
    button.className = className;
    button.innerHTML = innerHTML;
    button.addEventListener('click', clickHandler);
    return button;
}

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

        let attButton = createButton('btn btn-success', 'Atualizar', () => {
            event.preventDefault()
            document.getElementById("attLivro").style.display = "flex"

            setLivroFields("fieldAttTitulo", "fieldAttAutor", "fieldAttEditora", "fieldAttAno", "fieldAttPaginas", livroUnidade)

            let attLivroButton = document.getElementById("attLivroBtn");

            let livroFields = getLivroFields("fieldAttTitulo", "fieldAttAutor", "fieldAttEditora", "fieldAttAno", "fieldAttPaginas");

            attLivroButton.addEventListener("click", () => {
                event.preventDefault()

                livroFields = getLivroFields("fieldAttTitulo", "fieldAttAutor", "fieldAttEditora", "fieldAttAno", "fieldAttPaginas");

                if (livroFields.some(field => field === "")) {
                    alert("Preencha todos os campos!")
                    return
                }

                livroController.atualizarLivro(livroUnidade.titulo, ...livroFields)
                alert('Registro atualizado com sucesso!')
                updateTable()
            })
        })

        attButton.setAttribute('data-bs-toggle', 'modal');
        attButton.setAttribute('data-bs-target', '#attLivro');

        let td = document.createElement("td")
        td.appendChild(attButton);
        tr.appendChild(td);

        let delButton = createButton('btn btn-danger', 'Deletar', () => {
            livroController.removerLivro(livroUnidade.titulo)
            alert('Registro apagado com sucesso!')
            updateTable()
        });

        let td2 = document.createElement("td")
        td2.appendChild(delButton);
        tr.appendChild(td2);

        tableBodyId.appendChild(tr)
    })
}

function isBookEmpty() {
    let localStorageLivros = JSON.parse(localStorage.getItem('livros'))

    if (localStorageLivros === null || localStorageLivros.length === 0) {
        return true
    }

    return false
}

function populateLocalStorage() {
    if (isBookEmpty()) {
        livroController.criarLivro("O Senhor dos Anéis", "J. R. R. Tolkien", "HarperCollins", "1954", "1170")
        livroController.criarLivro("O Hobbit", "J. R. R. Tolkien", "HarperCollins", "1937", "310")
        livroController.criarLivro("Dom Quixote", "Miguel de Cervantes", "Editora 34", "1605", "863")
        livroController.criarLivro("Cem Anos de Solidão", "Gabriel García Márquez", "Record", "1967", "458")
        livroController.criarLivro("A Montanha Mágica", "Thomas Mann", "Companhia das Letras", "1924", "1048")
        livroController.criarLivro("O Apanhador no Campo de Centeio", "J. D. Salinger", "Editora do Autor", "1951", "288")
        livroController.criarLivro("O Processo", "Franz Kafka", "Companhia das Letras", "1925", "254")
        livroController.criarLivro("O Estrangeiro", "Albert Camus", "Record", "1942", "158")
        livroController.criarLivro("O Velho e o Mar", "Ernest Hemingway", "Bertrand Brasil", "1952", "128")
        livroController.criarLivro("A Divina Comédia", "Dante Alighieri", "Martin Claret", "1320", "592")
        livroController.criarLivro("Odisseia", "Homero", "Martin Claret", "800 a.C.", "560")
        livroController.criarLivro("Ilíada", "Homero", "Martin Claret", "800 a.C.", "560")
        livroController.criarLivro("A Metamorfose", "Franz Kafka", "Companhia das Letras", "1915", "232")
        livroController.criarLivro("O Primo Basílio", "Eça de Queirós", "Martin Claret", "1878", "320")
        livroController.criarLivro("O Cortiço", "Aluísio Azevedo", "Martin Claret", "1890", "320")
    }
}

updateTable()