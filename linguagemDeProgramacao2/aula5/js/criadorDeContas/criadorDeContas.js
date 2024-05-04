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
let contasEspeciaisCriadas = []
let contasPoupancaCriadas = []

buttonCriarEspecialConta.addEventListener("click", function () {
    let titular = document.getElementById("fieldNomeTitular").value
    let numeroBanco = document.getElementById("fieldNumeroBanco").value
    let nomeBanco = document.getElementById("fieldBanco").value
    let limite = document.getElementById("fieldLimite").value

    let conta = new Especial(titular, numeroBanco, nomeBanco, limite)
    alert(`Conta especial em nome de ${titular} criada com sucesso!`)
    contasEspeciaisCriadas.push(conta)

    popularTabelaEspecial()
})

buttonCriarPoupancaConta.addEventListener("click", function () {
    let titular = document.getElementById("fieldNomePoupancaTitular").value
    let numeroBanco = document.getElementById("fieldNumeroBancoPoupanca").value
    let nomeBanco = document.getElementById("fieldPoupancaBanco").value
    let aniversarioData = document.getElementById("fieldAniversario").value

    let conta = new Poupanca(titular, numeroBanco, nomeBanco, aniversarioData)
    alert(`Conta poupança em nome de ${titular} criada com sucesso!`)
    contasPoupancaCriadas.push(conta)
    console.log(contasPoupancaCriadas)
    popularTabelaPoupanca()
})

// Popular  tabela

function popularTabelaPoupanca() {
    let corpoTabela = document.getElementById("table-body-poupanca")
    corpoTabela.innerHTML = ""
    contasPoupancaCriadas.forEach(conta => {
        let linha = document.createElement("tr")
        linha.innerHTML = `
        <td>${conta.getTitular()}</td>
        <td>${conta.getNumero()}</td>
        <td>${conta.banco}</td>
        <td>${conta.getaniversaro()}</td>
        `
        corpoTabela.appendChild(linha)
    })
}

function popularTabelaEspecial() {
    let corpoTabela = document.getElementById("table-body-especial")
    corpoTabela.innerHTML = ""
    contasEspeciaisCriadas.forEach(conta => {
        let linha = document.createElement("tr")
        linha.innerHTML = `
        <td>${conta.getTitular()}</td>
        <td>${conta.getNumero()}</td>
        <td>${conta.banco}</td>
        <td>${conta.getLimite()}</td>
        `
        corpoTabela.appendChild(linha)
    })
}

//Modal Buttons

let abrirModalContaEspecial = document.getElementById("buttonEspecialVer")
let abrirModalContaPoupanca = document.getElementById("buttonPoupancaVer")

let fecharModalContaEspecial = document.getElementById("fecharModalContaEspecial")
let fecharModalContaPoupanca = document.getElementById("fecharModalContaPoupanca")

fecharModalContaEspecial.addEventListener("click", function () {
    let modalContaEspecial = document.getElementById("modalContaEspecial").style.display = "none"
})

fecharModalContaPoupanca.addEventListener("click", function () {
    let modalContaPoupanca = document.getElementById("modalContaPoupanca").style.display = "none"
})

abrirModalContaEspecial.addEventListener("click", function () {
    let modalContaEspecial = document.getElementById("modalContaEspecial").style.display = "block"
})

abrirModalContaPoupanca.addEventListener("click", function () {
    let modalContaPoupanca = document.getElementById("modalContaPoupanca").style.display = "block"
})