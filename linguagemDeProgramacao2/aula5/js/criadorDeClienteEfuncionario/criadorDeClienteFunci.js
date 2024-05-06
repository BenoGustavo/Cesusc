import { ClienteControladora, FuncionarioControladora } from './criadorDeClienteFunciClass.js'

let funcionarioControladora = new FuncionarioControladora()
let clienteControladora = new ClienteControladora()

let buttonVizualizarTabelaCliente = document.getElementById('vizualizarCliente')
let buttonCadastrarCliente = document.getElementById('cadastrarCliente')
let buttonAtualizarCliente = document.getElementById('atualizarCliente')
let buttonApagarCliente = document.getElementById('apagarCliente')

let buttonVizualizarTabelaFuncionario = document.getElementById('vizualizarFuncionario')
let buttonCadastrarFuncionario = document.getElementById('cadastrarFuncionario')
let buttonAtualizarFuncionario = document.getElementById('atualizarFuncionario')
let buttonApagarFuncionario = document.getElementById('apagarFuncionario')

let modalClientesCloseButton = document.getElementById('modalClientesCloseButton')
let modalFuncionarioCloseButton = document.getElementById('modalFuncionarioCloseButton')

let modalIDS = ['modal-body-clientes', 'modal-body-funcionarios']

let camposCliente = [
    { id: 'nome', label: 'Nome', placeholder: 'Digite o nome' },
    { id: 'cpf', label: 'CPF', placeholder: 'Digite o CPF' },
    { id: 'dataNascimento', label: 'Data de Nascimento', placeholder: 'Digite a data de nascimento' },
    { id: 'email', label: 'Email', placeholder: 'Digite o email' },
    { id: 'telefone', label: 'Telefone', placeholder: 'Digite o telefone' }
]

let camposFuncionario = [
    { id: 'nome', label: 'Nome', placeholder: 'Digite o nome' },
    { id: 'cpf', label: 'CPF', placeholder: 'Digite o CPF' },
    { id: 'dataNascimento', label: 'Data de Nascimento', placeholder: 'Digite a data de nascimento' },
    { id: 'salario', label: 'Salário', placeholder: 'Digite o salário' }
]

//CLIENTES
//MODAL
buttonVizualizarTabelaCliente.addEventListener('click', () => {
    document.getElementById("modalClientesVizualizar").style.display = "flex"
    vizualizarEmTabela(clienteControladora, modalIDS[0])
})

modalClientesCloseButton.addEventListener('click', () => {
    document.getElementById("modalClientesVizualizar").style.display = "none"
})
//CADASTRAR
buttonCadastrarCliente.addEventListener('click', () => {
    document.getElementById("modalClientesVizualizar").style.display = "flex"
    cadastrarUsuario(clienteControladora, camposCliente, modalIDS[0], 'Cliente')
})

//FUNCTIONARIOS
//MODAL
buttonVizualizarTabelaFuncionario.addEventListener('click', () => {
    document.getElementById("modalFuncionariosVizualizar").style.display = "flex"
    vizualizarEmTabela(funcionarioControladora, modalIDS[1])
})

modalFuncionarioCloseButton.addEventListener('click', () => {
    document.getElementById("modalFuncionariosVizualizar").style.display = "none"
})

//CADASTRAR
buttonCadastrarFuncionario.addEventListener('click', () => {
    document.getElementById("modalFuncionariosVizualizar").style.display = "flex"
    cadastrarUsuario(funcionarioControladora, camposFuncionario, modalIDS[1], 'Funcionário')
})

function cadastrarUsuario(objectController, campos, modalID, objectName) {
    let modalBody = document.getElementById(modalID)
    modalBody.innerHTML = ""
    let fieldset = document.createElement('fieldset')
    fieldset.className = 'bg-dark'
    fieldset.id = 'fieldset-cadastro'
    let legend = document.createElement('legend')
    legend.className = 'text-white'
    legend.innerHTML = `<strong>${objectName}</strong></br>Preencha aqui as suas informações`
    fieldset.appendChild(legend)

    campos.forEach(campo => {
        let div = document.createElement('div')
        div.className = 'form-floating mb-3'
        let input = document.createElement('input')
        input.className = 'form-control'
        input.id = campo.id
        input.placeholder = campo.placeholder
        input.autocomplete = 'off'
        input.required = true
        let label = document.createElement('label')
        label.htmlFor = campo.id
        label.innerHTML = campo.label
        div.appendChild(input)
        div.appendChild(label)
        fieldset.appendChild(div)
    })

    let button = document.createElement('button')
    button.type = 'button'
    button.className = 'btn btn-success'
    button.innerHTML = 'Cadastrar'

    button.addEventListener('click', () => {
        let fieldSet = document.getElementById('fieldset-cadastro')
        let camposValue = []
        let camposFieldset = fieldSet.getElementsByTagName('input')
        for (let i = 0; i < camposFieldset.length; i++) {
            camposValue.push(camposFieldset[i].value)
        }
        objectController.create(camposValue)
        alert(`${objectName} cadastrado com sucesso!`)
    })

    fieldset.appendChild(button)
    modalBody.appendChild(fieldset)
}

function vizualizarEmTabela(objectController, modalID) {
    let objects = objectController.getAll()
    let modalBody = document.getElementById(modalID)
    modalBody.innerHTML = ''

    // se não tiver nada cadastrado retorna e mostra msg na tela
    if (objects.length === 0) {
        let h1 = document.createElement('h1')
        h1.innerHTML = 'NENHUM REGISTRO ENCONTRADO'
        h1.style.textAlign = 'center'
        h1.className = 'text-white'
        modalBody.appendChild(h1)
        return
    }

    let table = document.createElement('table')
    table.className = 'table';
    let thead = document.createElement('thead');
    let tbody = document.createElement('tbody');

    // Create table headers
    let headerRow = document.createElement('tr');
    Object.keys(objects[0]).forEach(key => {
        let th = document.createElement('th');
        th.innerHTML = key.charAt(0).toUpperCase() + key.slice(1);
        headerRow.appendChild(th);
    });
    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Create table body
    objects.forEach(object => {
        let tr = document.createElement('tr');
        Object.keys(object).forEach(key => {
            let td = document.createElement('td');
            td.innerHTML = object[key];
            tr.appendChild(td);
        });
        tbody.appendChild(tr);
    });
    table.appendChild(tbody);

    modalBody.appendChild(table);
}