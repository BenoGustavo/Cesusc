class Pessoa {
    constructor(nome, cpf, dataNascimento) {
        this.nome = nome
        this.cpf = cpf
        this.dataNascimento = dataNascimento
    }
}

class Cliente extends Pessoa {
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

class Funcionario extends Pessoa {
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

export class FuncionarioControladora {
    constructor() {
        this.funcionarios = []
    }

    create(data) {
        const funcionario = new Funcionario(data[0], data[1], data[2], data[3])
        this.add(funcionario)
    }

    add(funcionario) {
        this.funcionarios.push(funcionario)
    }

    delete(cpf) {
        this.funcionarios = this.funcionarios.filter(funcionario => funcionario.cpf !== cpf)
    }

    update(cpf, novoNome, novoCpf, novaDataNascimento, novoSalario) {
        const funcionario = this.funcionarios.find(funcionario => funcionario.cpf === cpf)
        funcionario.updateFuncionario(novoNome, novoCpf, novaDataNascimento, novoSalario)
    }

    get(cpf) {
        return this.funcionarios.find(funcionario => funcionario.cpf === cpf)
    }

    getAll() {
        return this.funcionarios
    }
}

export class ClienteControladora {
    constructor() {
        this.clientes = []
    }

    create(data) {
        const cliente = new Cliente(data[0], data[1], data[2], data[3], data[4])
        this.add(cliente)
    }

    add(cliente) {
        this.clientes.push(cliente)
    }

    delete(cpf) {
        this.clientes = this.clientes.filter(cliente => cliente.cpf !== cpf)
    }

    update(cpf, novoNome, novoCpf, novaDataNascimento, novoEmail, novoTelefone) {
        const cliente = this.clientes.find(cliente => cliente.cpf === cpf)
        cliente.updateCliente(novoNome, novoCpf, novaDataNascimento, novoEmail, novoTelefone)
    }

    get(cpf) {
        return this.clientes.find(cliente => cliente.cpf === cpf)
    }

    getAll() {
        return this.clientes
    }
}