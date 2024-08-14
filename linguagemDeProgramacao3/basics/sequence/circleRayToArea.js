const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function circleRayToArea(ray) {
    return Math.PI * Math.pow(ray, 2);
}

rl.question('Enter the radius of the circle: ', (ray) => {
    const radius = parseFloat(ray);
    const area = circleRayToArea(radius);

    console.log("Circle area of radius " + radius + " is " + Math.floor(area));

    rl.close();
});