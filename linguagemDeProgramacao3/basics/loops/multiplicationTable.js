const tables = [];

for (let i = 1; i <= 10; i++) {
    const table = [];
    for (let j = 1; j <= 10; j++) {
        table.push(`${i} x ${j} = ${i * j}`);
    }
    tables.push(table);
}

for (let row = 0; row < 10; row++) {
    let line = '';
    for (let col = 0; col < 10; col++) {
        line += tables[col][row].padEnd(15, ' ');
    }
    console.log(line);
}