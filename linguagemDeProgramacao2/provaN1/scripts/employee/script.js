window.onload = function () {
    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('editar_funcionario')) {
            editEmployee();
        } else if (event.target.classList.contains('excluir_funcionario')) {
            deleteEmployee();
        }
    });
}

function editEmployee() {
    alert("Funcionário editado com sucesso!");
    return;
}

function deleteEmployee() {
    alert("Funcionário deletado com sucesso!");
    return;
}