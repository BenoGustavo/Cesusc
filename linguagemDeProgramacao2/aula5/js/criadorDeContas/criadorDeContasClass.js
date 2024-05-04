class Conta {
    #titular
    #numero
    constructor(titular, numero, banco) {
        this.#titular = titular
        this.#numero = numero
        this.banco = banco
    }

    getTitular() {
        return this.#titular
    }
    setTitular(novoTitular) {
        this.#titular = novoTitular
    }
    getNumero() {
        return this.#numero
    }
    setNumero(novoNumero) {
        this.#numero = novoNumero
    }

    toString() {
        return `Essa conta pertence ao ${this.#titular} que está vinculado ao banco ${this.banco}`
    }
}

export class Especial extends Conta {
    #limite
    constructor(titular, numero, banco, limite) {
        super(titular, numero, banco)
        this.#limite = limite
    }

    getLimite() {
        return this.limite
    }
    setLimite(novoLimite) {
        this.#limite = novoLimite
    }

    toString() {
        return super.toString() + "e é do tipo especial."
    }

}

export class Poupanca extends Conta {
    #aniversaro
    constructor(titular, numero, banco, aniversaro) {
        super(titular, numero, banco)
        this.#aniversaro = aniversaro
    }

    getaniversaro() {
        return this.aniversaro
    }
    setaniversaro(novoaniversaro) {
        this.#aniversaro = novoaniversaro
    }

    toString() {
        return super.toString() + `e é do tipo poupanca fazendo aniversario no dia ${this.aniversaro}.`
    }
}

// conta = new Especial("gustavo", "123", "banco do br", "1200")