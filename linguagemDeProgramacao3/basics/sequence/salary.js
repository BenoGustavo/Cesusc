const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the value per hour worked: ', (valuePerHour) => {
    rl.question('Enter the number of hours worked in the month: ', (hoursWorked) => {
        const totalSalary = parseFloat(valuePerHour) * parseFloat(hoursWorked);

        console.log(`The total salary for the month is: $${totalSalary.toFixed(2)}`);

        rl.close();
    });
});