const saudacao = (nome) => console.log(`Olá ${nome}`);

const isMajor = (age) => age > 17 ? console.log("Maior de idade") : console.log("Menor de idade");

const isPalindrome = (string) => string.split().reverse().join() == string ? console.log(string + " É palindromo") : console.log(string + " Não é palindromo")

const greathestNumber = (...numbers) => numbers.reduce((number, greathest) => number > greathest ? greathest = number : greathest = greathest);

const makePow = (base, pow) => Math.pow(base, pow)

console.log("Saudação: ")
saudacao("Gustavo");
console.log("17 anos é:")
isMajor(17)
console.log("18 anos é")
isMajor(18)
console.log("Arara é palindromo")
isPalindrome("arara")
console.log("Maior numero:")
console.log(greathestNumber(1, 2, 3, 4, 5, 6, 7, 8, 9))
console.log("A oh potencia: ")
console.log(makePow(2, 2))
