import { Carro, Caminhao } from "./registradorDeVeiculosClass.js"

// RADIO BUTTONS
let veiculoCarroRadio = document.getElementById("carroRadio")
let veiculoCaminhaoRadio = document.getElementById("caminhaoRadio")

veiculoCarroRadio.addEventListener("click", function () {
    document.getElementById("veiculosCaminhaoContainerId").style.display = "none"
    document.getElementById("veiculosCarroContainerId").style.display = "flex"
})
veiculoCaminhaoRadio.addEventListener("click", function () {
    document.getElementById("veiculosCaminhaoContainerId").style.display = "flex"
    document.getElementById("veiculosCarroContainerId").style.display = "none"
})

//CREATING ACCOUNT
let caminhoesCriados = []
let carrosCriados = []
let buttonCriarVeiculoCaminhao = document.getElementById("buttonCaminhaoCriar")
let buttonCriarVeiculoCarro = document.getElementById("buttonCarroCriar")


buttonCriarVeiculoCaminhao.addEventListener("click", function () {
    let nome = document.getElementById("fieldNome").value
    let marca = document.getElementById("fieldMarca").value
    let eixos = document.getElementById("fieldEixos").value

    let caminhao = new Caminhao(nome, marca, eixos)
    alert(`Caminhao ${nome} criado com sucesso!`)
    caminhoesCriados.push(caminhao)

    popularTabelaCaminhao()
})

buttonCriarVeiculoCarro.addEventListener("click", function () {
    let nome = document.getElementById("fieldNomeCarro").value
    let marca = document.getElementById("fieldMarcaCarro").value
    let numeroPortas = document.getElementById("fieldPortas").value

    let carro = new Carro(nome, marca, numeroPortas)
    alert(`Carro ${nome} criado com sucesso!`)

    carrosCriados.push(carro)

    popularTabelaCarros()
})


//parei aqui


// Popular  tabela

function popularTabelaCaminhao() {
    let corpoTabela = document.getElementById("table-body-caminhao")
    corpoTabela.innerHTML = ""
    caminhoesCriados.forEach(caminhao => {
        let linha = document.createElement("tr")
        linha.innerHTML = `
        <td>${caminhao.getNome()}</td>
        <td>${caminhao.getMarca()}</td>
        <td>${caminhao.getEixos()}</td>
        `
        corpoTabela.appendChild(linha)
    })
}

function popularTabelaCarros() {
    let corpoTabela = document.getElementById("table-body-carro")
    corpoTabela.innerHTML = ""
    carrosCriados.forEach(carro => {
        let linha = document.createElement("tr")
        linha.innerHTML = `
        <td>${carro.getNome()}</td>
        <td>${carro.getMarca()}</td>
        <td>${carro.getPortas()}</td>
        `
        corpoTabela.appendChild(linha)
    })
}

//Modal Buttons

let abrirModalCaminhao = document.getElementById("buttonCaminhaoVer")
let abrirModalContaPoupanca = document.getElementById("buttonCarroVer")

let fecharModalCarros = document.getElementById("fecharModalCarros")
let fecharModalCaminhao = document.getElementById("modalCaminhao")

fecharModalCarros.addEventListener("click", function () {
    document.getElementById("modalCarros").style.display = "none"
})

fecharModalCaminhao.addEventListener("click", function () {
    document.getElementById("modalCaminhao").style.display = "none"
})

abrirModalCaminhao.addEventListener("click", function () {
    document.getElementById("modalCaminhao").style.display = "block"
})

abrirModalContaPoupanca.addEventListener("click", function () {
    document.getElementById("modalCarros").style.display = "block"
})