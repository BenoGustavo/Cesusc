//CELLPHONE

class Product {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }

    toString() {
        return `Product: ${this.name}, Price: ${this.price}`;
    }
}

cellphone = new Product('Samsung', 1000);
console.log(cellphone.toString());

//CAR CLASS

class engine{
    constructor(name, price){
        this.name = name;
        this.price = price;
    }

    toString(){
        return `Engine: ${this.name}, Price: ${this.price}`;
    }

}

class Car{
    constructor(brand, price, engine){
        this.brand = brand;
        this.engine = engine
        this.price = engine.price + price;
    }

    toString(){
        return `Car: ${this.brand}, Price: ${this.price}, Engine: ${this.engine.toString()}`;
    }
}

engine1 = new engine('V8', 10000);
car = new Car('Toyota', 20000, engine1);
console.log(car.toString());