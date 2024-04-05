createButton = document.getElementById("criar_funcionario")

createButton.addEventListener('click', createEmployee);

function createEmployee(){
    const nameField = document.getElementById("employee_name").value
    const RG = document.getElementById("RG").value
    const CPF = document.getElementById("CPF").value
    const DATA = document.getElementById("data_nascimento").value
    const Telefone = document.getElementById("telefone").value
    const Email = document.getElementById("email").value
    const endereco = document.getElementById("endereco").value

    let listOfInputs = [nameField,RG,CPF,DATA,Telefone,Email,endereco]

    let table = document.getElementsByClassName("table__class")

    let row = document.createElement("tr");

    for (let index = 0; index < listOfInputs.length; index++){
        let cell = document.createElement("td");

        cell.value = listOfInputs[index];

        row.appendChild(cell);
    }
    console.log(table)
    table.appendChild(row)
}