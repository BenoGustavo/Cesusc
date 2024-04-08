createButton = document.getElementById("criar_funcionario")

createButton.addEventListener('click', createEmployee);

function createEmployee() {
    if (isFieldEmpty()) {
        alert("Preencha todos os campos!")
        return
    }

    cleanFields()

    alert("Funcionário criado com sucesso!")
    return

}

function cleanFields() {
    document.getElementById("employee_name").value = ""
    document.getElementById("RG").value = ""
    document.getElementById("CPF").value = ""
    document.getElementById("data_nascimento").value = ""
    document.getElementById("telefone").value = ""
    document.getElementById("email").value = ""
    document.getElementById("endereco").value = ""
}

function isFieldEmpty() {
    if (document.getElementById("employee_name").value == "" || document.getElementById("RG").value == "" || document.getElementById("CPF").value == "" || document.getElementById("data_nascimento").value == "" || document.getElementById("telefone").value == "" || document.getElementById("email").value == "" || document.getElementById("endereco").value == "") {
        return true
    }
    return false
}