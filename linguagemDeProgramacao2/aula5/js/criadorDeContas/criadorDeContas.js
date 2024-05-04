import { Especial, Poupanca } from "./criadorDeContasClass.js"

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

//CREATING ACCOUNT
let buttonCriarEspecialConta = document.getElementById("buttonEspecialCreate")
let buttonCriarPoupancaConta = document.getElementById("buttonPoupancaCreate")

buttonCriarEspecialConta.addEventListener("click", function () {
    let titular = document.getElementById("fieldNomeTitular").value
    let numeroBanco = document.getElementById("fieldNumeroBanco").value
    let nomeBanco = document.getElementById("fieldBanco").value
    let limite = document.getElementById("fieldLimite").value

    console.log(titular, numeroBanco, nomeBanco, limite)

})

buttonCriarPoupancaConta.addEventListener("click", function () {
    let titular = document.getElementById("fieldNomePoupancaTitular").value
    let numeroBanco = document.getElementById("fieldNumeroBancoPoupanca").value
    let nomeBanco = document.getElementById("fieldPoupancaBanco").value
    let aniversarioData = document.getElementById("fieldAniversario").value

    console.log(titular, numeroBanco, nomeBanco, aniversarioData)
})