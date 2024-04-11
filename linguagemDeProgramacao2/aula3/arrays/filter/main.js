// Crie um array com 30 produtos. Cada produto possui os campos: nome, preço e validade (true/false). Em seguida
// mostre para os usuários:

// a) Filtro 1: liste apenas os produtos que estão dentro do
// prazo de validade;
// b) Filtro 2: liste apenas os produtos com valor entre R$50,00
// a R$100,00.

let produtos = [];

for (let i = 0; i < 30; i++) {
    let produto = {
        nome: `Produto ${i+1}`,
        preco: Math.floor(Math.random() * 100) + 1, // preço aleatório entre 1 e 100
        validade: Math.random() >= 0.5 // validade aleatória (true ou false)
    };
    produtos.push(produto);
}

let dentroDaValidade = produtos.filter(p => p.validade);

let dentroEntre50e100 = produtos.filter(p => p.preco >= 50 && p.preco <= 100);

console.log('Produtos dentro da validade:');
console.table(dentroDaValidade)

console.log("\nProdutos entre 50 e 100 Reais: ");
console.table(dentroEntre50e100)