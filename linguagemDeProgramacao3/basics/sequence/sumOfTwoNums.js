const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function sumOfTwoNums(a, b) {
    return a + b;
}

rl.question('Enter the first number: ', (firstNumber) => {
    rl.question('Enter the second number: ', (secondNumber) => {
        const num1 = parseFloat(firstNumber);
        const num2 = parseFloat(secondNumber);
        const sum = sumOfTwoNums(num1, num2);

        console.log("Sum of the numbers " + num1 + " + " + num2 + " = " + sum);

        rl.close();
    });
});