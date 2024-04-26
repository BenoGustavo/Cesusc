class banco{
    #contas

    constructor(nomeAgencia, numeroDaAgencia){
        this.nomeAgencia = nomeAgencia
        this.numeroDaAgencia = numeroDaAgencia
        this.#contas = []
    }

    set setNewConta(conta){
        this.#contas.push(conta)
    }

    toString(){
        return `Agência: ${this.nomeAgencia}, Número: ${this.numeroDaAgencia}`
    }
}

class contaBancaria {
    #numeroDaConta
    #saldo

    constructor(dono, banco, conta, saldo) {
        this.dono = dono
        this.banco = banco
        this.#numeroDaConta = conta
        this.#saldo = saldo

        banco.setNewConta = this
    }

    get saldo() {
        return this.#saldo
    }

    get numeroDaConta() {
        return this.#numeroDaConta
    }

    deposito(valor) {
        if (valor <= 0) {
            console.log('Valor inválido para depósito')
            return
        }

        this.#saldo += valor
    }

    saque(valor) {
        if (valor <= 0 || valor > this.#saldo) {
            console.log('Valor inválido para saque')
            return
        }

        this.#saldo -= valor
    }

    toString() {
        return `Dono: ${contaBancaria.dono} Agência: ${this.banco.nomeAgencia}`
    }
}

let bank_of_brazil = new banco('Banco do Brasil', 1234)

let conta = new contaBancaria('João', bank_of_brazil, 12345, 1000)

console.log(conta)