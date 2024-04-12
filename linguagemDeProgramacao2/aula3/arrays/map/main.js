// Exercício de Fixação

// Crie um lista de alunos e médias no formato JSON. Mostre ao
// usuário apenas os alunos aprovados com médias maiores que
// 7,0.

const MEDIA = {
    "medias":[
        {"media": 7.5},
        {"media": 8.9},
        {"media": 6.8},
        {"media": 9.2},
        {"media": 7.1},
        {"media": 8.3},
        {"media": 6.5},
        {"media": 9.5},
        {"media": 7.7},
        {"media": 8.1},
        {"media": 7.4},
        {"media": 8.7},
        {"media": 6.9},
        {"media": 8.2},
        {"media": 9.0},
        {"media": 7.3},
        {"media": 8.5},
        {"media": 6.7},
        {"media": 9.1},
        {"media": 7.8},
        {"media": 8.4},
        {"media": 6.6},
        {"media": 9.3},
        {"media": 7.6},
        {"media": 8.6},
        {"media": 6.4},
        {"media": 9.4},
        {"media": 7.9},
        {"media": 8.8},
        {"media": 6.3},
        {"media": 9.6},
        {"media": 7.0},
        {"media": 8.0},
        {"media": 6.2},
        {"media": 9.7},
        {"media": 7.2},
        {"media": 8.9},
        {"media": 6.1},
        {"media": 9.8},
        {"media": 7.1},
        {"media": 8.7},
        {"media": 6.0},
        {"media": 9.9},
        {"media": 7.3},
        {"media": 8.6},
        {"media": 5.9},
        {"media": 10.0}
    ]
}

const ALUNOS = {
    "alunos": [
        {"nome": "João"},
        {"nome": "Maria"},
        {"nome": "Pedro"},
        {"nome": "Ana"},
        {"nome": "Carlos"},
        {"nome": "Mariana"},
        {"nome": "Lucas"},
        {"nome": "Julia"},
        {"nome": "Fernando"},
        {"nome": "Camila"},
        {"nome": "Rafael"},
        {"nome": "Carla"},
        {"nome": "Paulo"},
        {"nome": "Natália"},
        {"nome": "Luiz"},
        {"nome": "Gabriela"},
        {"nome": "Marcos"},
        {"nome": "Patrícia"},
        {"nome": "Daniel"},
        {"nome": "Aline"},
        {"nome": "Gustavo"},
        {"nome": "Isabela"},
        {"nome": "Diego"},
        {"nome": "Larissa"},
        {"nome": "Roberto"},
        {"nome": "Vanessa"},
        {"nome": "Eduardo"},
        {"nome": "Bianca"},
        {"nome": "Felipe"},
        {"nome": "Laura"},
        {"nome": "Ricardo"},
        {"nome": "Tatiane"},
        {"nome": "Vinícius"},
        {"nome": "Monique"},
        {"nome": "Leonardo"},
        {"nome": "Amanda"},
        {"nome": "Henrique"},
        {"nome": "Cristina"},
        {"nome": "Renato"},
        {"nome": "Sara"},
        {"nome": "Hugo"},
        {"nome": "Beatriz"},
        {"nome": "Jorge"},
        {"nome": "Raquel"},
        {"nome": "Alexandre"},
        {"nome": "Talita"},
        {"nome": "Guilherme"}
    ]
}

const ALUNOS_ACIMA_DE_SETE = ALUNOS.map((aluno, index) => {
    if (media[index] > 7) {
        return aluno;
    } else {
        return null;
    }
}).filter(aluno => aluno !== null);

console.log(ALUNOS_ACIMA_DE_SETE)
