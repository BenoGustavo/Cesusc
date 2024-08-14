const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the first partial grade: ', (firstGrade) => {
    rl.question('Enter the second partial grade: ', (secondGrade) => {
        const grade1 = parseFloat(firstGrade);
        const grade2 = parseFloat(secondGrade);
        const average = (grade1 + grade2) / 2;

        console.log(`Average grade: ${average.toFixed(2)}`);

        if (average === 10.0) {
            console.log("Aprovado com Distinção");
        } else if (average >= 7.0) {
            console.log("Aprovado");
        } else {
            console.log("Reprovado");
        }

        rl.close();
    });
});