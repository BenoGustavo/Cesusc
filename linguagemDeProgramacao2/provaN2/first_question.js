class Person{
    #name
    #cpf
    constructor(personName,cpf){
        this.#name = personName
        this.#cpf = cpf
    }

    getName(){
        return this.#name
    }
    setName(newName){
        this.#name = newName
    }
    getCpf(){
        return this.#cpf
    }
    setCpf(newCpf){
        this.#cpf = newCpf
    }
    toString(){
        return `This person has the name ${this.#name} and the CPF ${this.#cpf}`
    }
}

class Adress{
    #road
    #number
    constructor(road,number){
        this.#road = road
        this.#number = number
    }

    getRoad(){
        return this.#road
    }
    setRoad(newRoad){
        this.#road = newRoad
    }
    getNumber(){
        return this.#number
    }
    setNumber(newNumber){
        this.number = newNumber 
    }
    toString(){
        return `This adress is ${this.#road}, number ${this.#number}`
    }
}

personOne = new Person("Gustavo","123.456.234-51")
console.log(personOne.toString())

adressOne = new Adress("Rua bacana legal","140")
adressTwo = new Adress("Rua somente legal", "160")
console.log(adressOne.toString())
console.log(adressTwo.toString())