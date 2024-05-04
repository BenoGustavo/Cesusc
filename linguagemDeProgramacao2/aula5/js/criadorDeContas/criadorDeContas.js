// RADIO BUTTONS
let contaEspecialRadio = document.getElementById("contaEspecial")
let contaPoupancaRadio = document.getElementById("contaPoupança")

contaEspecialRadio.addEventListener("click", function () {
    document.getElementById("contaPoupancaContainerId").style.display = "none"
    document.getElementById("contaEspecialContainerId").style.display = "flex"
})
contaPoupancaRadio.addEventListener("click", function () {
    document.getElementById("contaPoupancaContainerId").style.display = "flex"
    document.getElementById("contaEspecialContainerId").style.display = "none"
})

