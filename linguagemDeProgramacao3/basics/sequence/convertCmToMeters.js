const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the value in centimeters: ', (cm) => {
    const centimeters = parseFloat(cm);
    const meters = centimeters / 100;

    console.log(`${centimeters} cm in meters is: ${meters} meters`);

    rl.close();
});