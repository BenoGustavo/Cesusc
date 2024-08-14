const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the price of the first product: ', (firstPrice) => {
    rl.question('Enter the price of the second product: ', (secondPrice) => {
        rl.question('Enter the price of the third product: ', (thirdPrice) => {
            const price1 = parseFloat(firstPrice);
            const price2 = parseFloat(secondPrice);
            const price3 = parseFloat(thirdPrice);

            let cheapest = price1;
            let cheapestProduct = 'first product';

            if (price2 < cheapest) {
                cheapest = price2;
                cheapestProduct = 'second product';
            }

            if (price3 < cheapest) {
                cheapest = price3;
                cheapestProduct = 'third product';
            }

            console.log(`You should buy the ${cheapestProduct} which costs: ${cheapest.toFixed(2)}`);

            rl.close();
        });
    });
});