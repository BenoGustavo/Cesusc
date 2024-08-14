const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter a letter: ', (letter) => {
    const lowerLetter = letter.toLowerCase();
    const vowels = ['a', 'e', 'i', 'o', 'u'];

    if (vowels.includes(lowerLetter)) {
        console.log("Vowel");
    } else {
        console.log("Consonant");
    }

    rl.close();
});