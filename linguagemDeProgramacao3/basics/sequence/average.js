function average(arr) {
    return arr.reduce((a, b) => a + b, 0) / arr.length;
}

const GRADES = [7, 8, 9, 10, 11, 12];


console.log("The average of the grades " + GRADES + " is: " + average(GRADES));
