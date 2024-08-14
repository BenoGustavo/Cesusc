const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function celsiusToFahrenheit(celsius) {
    return (celsius * 9 / 5) + 32;
}

rl.question('Enter the temperature in degrees Celsius: ', (celsius) => {
    const tempCelsius = parseFloat(celsius);
    const tempFahrenheit = celsiusToFahrenheit(tempCelsius);

    console.log(`${tempCelsius} degrees Celsius is equal to ${tempFahrenheit.toFixed(2)} degrees Fahrenheit`);

    rl.close();
});