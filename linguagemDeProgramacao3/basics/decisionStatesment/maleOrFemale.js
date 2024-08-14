const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter a letter (F or M): ', (letter) => {
    const upperLetter = letter.toUpperCase();

    if (upperLetter === 'F') {
        console.log("F - Female");
    } else if (upperLetter === 'M') {
        console.log("M - Male");
    } else {
        console.log("Invalid sex");
    }

    rl.close();
});