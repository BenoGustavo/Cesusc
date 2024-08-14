const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the first number: ', (firstNumber) => {
    rl.question('Enter the second number: ', (secondNumber) => {
        const num1 = parseFloat(firstNumber);
        const num2 = parseFloat(secondNumber);

        if (num1 > num2) {
            console.log(`The larger number is: ${num1}`);
        } else if (num2 > num1) {
            console.log(`The larger number is: ${num2}`);
        } else {
            console.log('Both numbers are equal.');
        }

        rl.close();
    });
});