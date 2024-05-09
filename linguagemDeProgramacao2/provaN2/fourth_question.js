class Pessoa{
    #name
    constructor(personName){
        this.#name = personName
    }

    getName(){
        return this.#name
    }
    setName(newName){
        this.#name = newName
    }
    toString(){
        return `This person has the name ${this.#name}`
    }
}

class PessoaFisica extends Pessoa{
    #cpf
    #rg

    constructor(name,cpf,rg){
        super(name)
        this.#cpf = cpf
        this.#rg = rg
    }

    getCpf(){
        return this.#cpf
    }
    setCpf(newCpf){
        this.#cpf = newCpf
    }
    getRg(){
        return this.#rg
    }
    setRg(newRg){
        this.#rg = newRg
    }

    toString(){
        return `A pessoa fisica ${super.getName()} tem o rg ${this.#rg}`
    }
}


class PessoaJuridica extends Pessoa{
    #cnpj
    #ie

    constructor(name,cnpj,ie){
        super(name)
        this.#cnpj = cnpj
        this.#ie = ie
    }

    getCnpj(){
        return this.#cnpj
    }
    setCnpj(newcnpj){
        this.#cnpj = newcnpj
    }
    getIe(){
        return this.#ie
    }
    setIe(newie){
        this.#ie = newie
    }

    toString(){
        return `A pessoa fisica ${super.getName()} tem o ie ${this.#ie}`
    }
}

pessoaFisicaInstance = new PessoaFisica("nome legal","123.123.123-32","1231231")
pessoaJuridicaInstance = new PessoaJuridica("nome legal 2","123.123.123-32","34543535")

console.log(pessoaFisicaInstance.toString(),pessoaJuridicaInstance.toString())
