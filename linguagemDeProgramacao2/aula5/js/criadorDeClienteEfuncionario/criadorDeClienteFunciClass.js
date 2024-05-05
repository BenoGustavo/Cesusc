class Pessoa {
    constructor(nome, cpf, dataNascimento) {
        this.nome = nome
        this.cpf = cpf
        this.dataNascimento = dataNascimento
    }
}

export class Cliente extends Pessoa {
    constructor(nome, cpf, dataNascimento, email, telefone) {
        super(nome, cpf, dataNascimento)
        this.email = email
        this.telefone = telefone
    }

    updateCliente(novoNome = this.novoNome, novoCpf = this.cpf, novaDataNascimento = this.dataNascimento, novoEmail = this.email, novoTelefone = this.telefone) {
        this.nome = novoNome
        this.cpf = novoCpf
        this.dataNascimento = novaDataNascimento
        this.email = novoEmail
        this.telefone = novoTelefone
    }
}

export class Funcionario extends Pessoa {
    constructor(nome, cpf, dataNascimento, salario) {
        super(nome, cpf, dataNascimento)
        this.salario = salario
    }

    updateFuncionario(novoNome = this.novoNome, novoCpf = this.cpf, novaDataNascimento = this.dataNascimento, novoSalario = this.salario) {
        this.nome = novoNome
        this.cpf = novoCpf
        this.dataNascimento = novaDataNascimento
        this.salario = novoSalario
    }
}