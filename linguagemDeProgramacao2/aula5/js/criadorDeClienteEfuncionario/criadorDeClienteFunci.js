import { Cliente, Funcionario } from './criadorDeClienteFunciClass.js'

class FuncionarioControladora {
    constructor() {
        this.funcionarios = []
    }

    createFuncionario(nome, cpf, dataNascimento, salario) {
        const funcionario = new Funcionario(nome, cpf, dataNascimento, salario)
        this.addFuncionario(funcionario)
    }

    addFuncionario(funcionario) {
        this.funcionarios.push(funcionario)
    }

    deleteFuncionario(cpf) {
        this.funcionarios = this.funcionarios.filter(funcionario => funcionario.cpf !== cpf)
    }

    updateFuncionario(cpf, novoNome, novoCpf, novaDataNascimento, novoSalario) {
        const funcionario = this.funcionarios.find(funcionario => funcionario.cpf === cpf)
        funcionario.updateFuncionario(novoNome, novoCpf, novaDataNascimento, novoSalario)
    }

    getFuncionario(cpf) {
        return this.funcionarios.find(funcionario => funcionario.cpf === cpf)
    }
}

class ClienteControladora {
    constructor() {
        this.clientes = []
    }

    createCliente(nome, cpf, dataNascimento, email, telefone) {
        const cliente = new Cliente(nome, cpf, dataNascimento, email, telefone)
        this.addCliente(cliente)
    }

    addCliente(cliente) {
        this.clientes.push(cliente)
    }

    deleteCliente(cpf) {
        this.clientes = this.clientes.filter(cliente => cliente.cpf !== cpf)
    }

    updateCliente(cpf, novoNome, novoCpf, novaDataNascimento, novoEmail, novoTelefone) {
        const cliente = this.clientes.find(cliente => cliente.cpf === cpf)
        cliente.updateCliente(novoNome, novoCpf, novaDataNascimento, novoEmail, novoTelefone)
    }

    getCliente(cpf) {
        return this.clientes.find(cliente => cliente.cpf === cpf)
    }
}