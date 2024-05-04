class Veiculo {
    #nome
    #marca
    constructor(nome, marca) {
        this.#nome = nome
        this.marca = marca
    }

    getMarca() {
        return this.#marca
    }

    setMarca(novaMarca) {
        this.#marca = novaMarca
    }

    getNome() {
        return this.#nome
    }

    setNome(novoNome) {
        this.#nome = novoNome
    }

    toString() {
        return `Esse carro tem como nome ${this.#nome} e pertence a marca ${this.#marca}`
    }
}

export class Carro extends Veiculo {
    #portas
    constructor(nome, marca, nPortas) {
        super(nome, marca)
        this.#portas = nPortas
    }

    getPortas() {
        return this.#portas
    }

    setPortas(novoNdePortas) {
        if (typeof (novoNdePortas) != typeof (1)) {
            alert("Insira apenas números de base 10 como um valor para portas.")
            return
        }
        this.#portas = novoNdePortas
    }

    toString() {
        return `${super.toString} tendo ${this.#portas} quantidade de portas`
    }
}

export class Caminhao extends Veiculo {
    #eixos
    constructor(nome, marca, eixos) {
        super(nome, marca)
        this.#eixos = eixos
    }

    getEixos() {
        return this.#eixos
    }

    setEixos(eixos) {
        if (typeof (eixos) != typeof (1)) {
            alert("Insira apenas números de base 10 como um valor para eixos.")
            return
        }
        this.#eixos = eixos
    }

    toString() {
        return `${super.toString} tendo ${this.#eixos} quantidade de eixos`
    }
}