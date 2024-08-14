const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const squareArea = (side) => {
    const area = side * side;
    return area;
};

rl.question('Enter the side length of the square: ', (side) => {
    const sideLength = parseFloat(side);
    const area = squareArea(sideLength);
    const doubleArea = area * 2;

    console.log(`Square area of side ${sideLength} is ${area}`);
    console.log(`The double of the square area is ${doubleArea}`);

    rl.close();
});