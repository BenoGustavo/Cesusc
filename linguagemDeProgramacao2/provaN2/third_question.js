//Crie a superclasse Funcionário com os atributos nome, email, cpf. 
//Crie as subclasses Engenheiro, Diretor, Secretário e Gerente. 
//A classe Funcionário deve possuir como parâmetros no construtor: nome, email, cpf. 
//As subclasses devem conter um atributo de sua escolha que tenha relação ao cenário de uma empresa de construção civil. 
//Cada subclasse deve conter um atributo diferente da classe “irmã”.

//Crie 1 objetos para cada subclasse.

class Employee{
    constructor(name,email,cpf,salary){
        this.name = name
        this.email = email
        this.cpf = cpf
        this.salary = salary
    }

    toString(){
        return `The employee ${this.name} have the e-mail ${this.email}`
    }
}

class Manager extends Employee{
    constructor(name,email,cpf,salary,age,sector){
        super(name,email,cpf,salary)
        this.age = age
        this.sector = sector
    }

    toString(){
        return super.toString() + `,he/her is the Manager of the ${this.sector} sector`
    }
}

class Secretary extends Employee{
    constructor(name,email,cpf,salary,secretaryOf){
        super(name,email,cpf,salary)
        this.secretaryOf = secretaryOf
    }

    toString(){
        return super.toString() + `,he/her is a Secretary of ${this.secretaryOf}`
    }
}

class Diretor extends Employee{
    constructor(name,email,cpf,salary,workWalletID){
        super(name,email,cpf,salary)
        this.workWalletID = workWalletID
    }

    toString(){
        return super.toString() + `,he/her is a Diretor and his work Wallet ID is ${this.workWalletID}`
    }
}

class Engineer extends Employee{
    constructor(name,email,cpf,salary,projectsFinished,seniority){
        super(name,email,cpf,salary)
        this.projectsFinished = projectsFinished
        this.Seniority = seniority
    }

    toString(){
        return super.toString() + `,he/her is a Engineer and finished a total of ${this.projectsFinished}`
    }
}

managerInstance = new Manager("Manager Cool name", "manager@gmail.com","133.133.133-53","5000","42","T.I")
secretaryInstance = new Secretary("Secretary Cool name", "secretary@gmail.com","999.999.999-99","2000","32",managerInstance)
directorInstance = new Diretor("Diretor Cool name", "diretor@gmail.com","999.999.999-99","3000","76","123456789")
engineerInstance = new Engineer("Engineer Cool name", "engineer@gmail.com","999.999.999-99","3500","33",["project A","Project B","Project C"])

console.log(managerInstance,secretaryInstance,directorInstance,engineerInstance)
console.log(managerInstance.toString() +"\n",secretaryInstance.toString() +"\n",directorInstance.toString() +"\n",engineerInstance.toString())