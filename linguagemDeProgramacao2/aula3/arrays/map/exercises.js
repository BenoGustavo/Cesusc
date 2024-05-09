// Exercise 1: Given an array of numbers, use the map function to create a new array where each number is multiplied by 3.

// Exercise 2: Given an array of strings, use the filter function to create a new array that only includes the strings that start with the letter 'a'.

// Exercise 3: Given an array of objects where each object has a property 'age', use the map function to create a new array that contains the age of each object.

// Exercise 4: Given an array of numbers, use the filter function to create a new array that only includes the numbers that are divisible by 5.

// Exercise 5: Given an array of strings, use the map function to create a new array where the first letter of each string is capitalized.

// Exercise 6: Given an array of numbers, use the map function to create a new array where each number is converted to a string.

// Exercise 7: Given an array of strings, use the filter function to create a new array that only includes the strings that have a length of 4.

const quantityOfIterations = Math.ceil(Math.random() * 30)
const possibleCharacters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';

const ARRAY_OF_NUMBERS = []
const ARRAY_OF_STRINGS = []
const PERSONS = []
const DIVISIBLE_BY_FIVE_ARRAY = []

for (let index = 0; index < quantityOfIterations; index++) {
    ARRAY_OF_NUMBERS.push(Math.ceil(Math.random() * 30))
}

for (let index = 0; index < quantityOfIterations; index++) {
    let randomString = '';
    for (let charIndex = 0; charIndex < 5; charIndex++) {
        randomString += possibleCharacters.charAt(Math.floor(Math.random() * possibleCharacters.length));
    }
    ARRAY_OF_STRINGS.push(randomString);
}

for (let index = 0; index < quantityOfIterations; index++) {
    PERSONS.push({ "name": ARRAY_OF_STRINGS[index], "age": ARRAY_OF_NUMBERS[index] })
}

for (let index = 0; index < quantityOfIterations; index++) {
    DIVISIBLE_BY_FIVE_ARRAY.push(index * 5)
    DIVISIBLE_BY_FIVE_ARRAY.push(ARRAY_OF_NUMBERS[index])
}

function exercise1(array_numbers) {
    return array_numbers.map(number => number * 3)
}

function exercise2(array_strings) {
    return array_strings.filter(string => string.charAt(string.length - 1) === "a" || string.charAt(string.length - 1) === "A")
}

function exercise3(array_of_objects_with_age) {
    return array_of_objects_with_age.map(object => object.age)
}

function exercise4(array_numbers) {
    return array_numbers.filter(number => (number % 5) == 0)
}

function exercise5(array_strings) {
    return array_strings.map(string => {
        let capitalizedChar = String(string).charAt(0).toUpperCase();
        return capitalizedChar + string.slice(1);
    });
}

function exercise6(array_numbers) {
    return array_numbers.map(number_string => String(number_string))
}

function exercise7(array_strings) {
    return array_strings.filter(string => string.length >= 4)
}

console.log("Original array: ", ARRAY_OF_NUMBERS)
console.log("Array Multiplied by 3x: ", exercise1(ARRAY_OF_NUMBERS))

console.log("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")

console.log("Array of strings: ", ARRAY_OF_STRINGS)
console.log("Array of strings that finishes with the letter 'a': ", exercise2(ARRAY_OF_STRINGS))

console.log("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")

console.log("Array of objects: ", PERSONS)
console.log("Array with only the age: ", exercise3(PERSONS))

console.log("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")

console.log("Array of numbers to divide by five: ", DIVISIBLE_BY_FIVE_ARRAY)
console.log("Array of numbers divisible by five: ", exercise4(DIVISIBLE_BY_FIVE_ARRAY))

console.log("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")

console.log("Array of strings: ", ARRAY_OF_STRINGS)
console.log("Array strings captalized: ", exercise5(ARRAY_OF_STRINGS))

console.log("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")

console.log("Array of numbers type number: ", ARRAY_OF_NUMBERS)
console.log("Array of numbers type string: ", exercise6(ARRAY_OF_NUMBERS), "Type of: ", typeof (exercise6(ARRAY_OF_NUMBERS)[0]))

console.log("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")

console.log("Array of strings: ", ARRAY_OF_STRINGS)
console.log("Array of string with len > then 4: ", exercise7(ARRAY_OF_STRINGS))