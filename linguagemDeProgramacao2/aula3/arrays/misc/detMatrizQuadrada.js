// criar uma matriz de ordem 2x2

const matrizQuadra = [
    [2,4],
    [8,12]
]

// console.table(matrizQuadra)

const det = matrizQuadra[0][0] * matrizQuadra[1][1] - matrizQuadra[0][1] * matrizQuadra[1][0]

console.table(det)