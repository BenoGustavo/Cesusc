const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function fahrenheitToCelsius(fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
}

rl.question('Enter the temperature in degrees Fahrenheit: ', (fahrenheit) => {
    const tempFahrenheit = parseFloat(fahrenheit);
    const tempCelsius = fahrenheitToCelsius(tempFahrenheit);

    console.log(`${tempFahrenheit} degrees Fahrenheit is equal to ${tempCelsius.toFixed(2)} degrees Celsius`);

    rl.close();
});