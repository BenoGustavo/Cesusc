listaOne = () => {
    class Book {
        constructor(title, author, year, gender) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.gender = gender;
            this.score = null;
        }

        setAge() {
            let actualYear = new Date().getFullYear();
            this.age = actualYear - this.year;
        }

        setScore(score) {
            this.score ? console.log("Book already has a score") : this.score = score;
        }
    }

    let harryPotter = new Book("Harry Potter", "J.K. Rowling", 1997, "fantasy");
    console.log("Default book: ");
    console.log(harryPotter);
    harryPotter.setAge();
    console.log("Book with age: ");
    console.log(harryPotter);
    harryPotter.setScore(10);
    console.log("Book with score: ");
    console.log(harryPotter);
    harryPotter.setScore(5);
    harryPotter.gender = "adventure";
    console.log("Book gender changed: ")
    console.log(harryPotter);
    delete harryPotter.score;
    console.log("Book without score: ");
    console.log(harryPotter);
}

exListaTwo = () => {
    class BankAccount {
        constructor(owner, name, money) {
            this.name = name;
            this.money = money;
            this.owner = owner;
        }

        seeMoney = () => {
            console.log(`Money in ${this.owner.name} account: ${this.money}`);
        }

        deposit = (amount) => {
            this.money += amount;
            console.log(`Deposit of ${amount} in ${this.name} account. Total: ${this.money}`);
        }

        withdraw = (amount) => {
            amount > this.money ? console.log("Not enough money") : this.money -= amount;

            console.log(`Withdraw of ${amount} in ${this.name} account. Total: ${this.money}`);
        }

        toString = () => {
            return `${this.owner.name} - ${this.name} - ${this.money}`;
        }
    }

    class Adress {
        constructor(street, number, city, country) {
            this.street = street;
            this.number = number;
            this.city = city;
            this.country = country;
        }

        toString = () => {
            return `${this.street}, ${this.number} - ${this.city}, ${this.country}`;
        }
    }

    class Person {
        constructor(name, age, isOnRelationShip, hobbies) {
            this.name = name;
            this.age = age;
            this.isOnRelationShip = isOnRelationShip;
            this.hobbies = hobbies;
            this.bankAccounts = [];
        }

        setAdress = (Adress) => {
            this.adress = Adress;
        }

        setBankAccount = (BankAccount) => {
            this.bankAccounts.push(BankAccount);
        }

        printPerson = () => {
            for (let key in this) {
                if (typeof (this[key]) == Object) {
                    console.log(key + ": " + this[key].toString());
                } else {
                    console.log(`${key}: ${this[key]}`);
                }
            }
        }
    }

    let personOne = new Person("Gustavo", 21, true, ["Playing video games", "Watching animes", "Programming"]);
    let adressOne = new Adress("Rua 1", 123, "Florianopolis", "Brasil");
    personOne.setAdress(adressOne);
    let bankAccountOne = new BankAccount(personOne, "Savings", 1000);
    personOne.setBankAccount(bankAccountOne);
    personOne.printPerson();
    bankAccountOne.seeMoney();
    bankAccountOne.deposit(500);
    bankAccountOne.withdraw(200);

}

listaOne();
exListaTwo();