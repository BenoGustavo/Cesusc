const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the first number: ', (firstNumber) => {
    rl.question('Enter the second number: ', (secondNumber) => {
        rl.question('Enter the third number: ', (thirdNumber) => {
            const num1 = parseFloat(firstNumber);
            const num2 = parseFloat(secondNumber);
            const num3 = parseFloat(thirdNumber);

            const numbers = [num1, num2, num3];
            numbers.sort((a, b) => b - a);

            console.log(`Numbers in descending order: ${numbers.join(', ')}`);

            rl.close();
        });
    });
});