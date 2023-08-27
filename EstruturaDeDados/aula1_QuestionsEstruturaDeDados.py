from random import randint


class aula1Questions:
    def __init__(self) -> None:
        ...

    @staticmethod
    def primeiraQuestao():
        print(
            "1) Crie as seguintes listas:\na) Lista de Nomes;\nb) Lista de números pares;"
        )
        listOfNames = ["Gustavo", "Leandro", "Gorges"]

        listOfNumbers = []
        rangeLen = randint(1, 20)
        for _ in range(rangeLen):
            randomNum = randint(1, 1000)
            if randomNum % 2 == 0:
                listOfNumbers.append(randomNum)

        print("\n" + "-=-" * 5 + "Numbers" + "-=-" * 5)
        for number in listOfNumbers:
            print("Inside ur list of number has the number: ", number)

        print("\n" + "-=-" * 5 + "Names" + "-=-" * 5)
        for name in listOfNames:
            print("Inside of ur list of names have the name: ", name, end="\n\n")

    @staticmethod
    def segundaQuestao():
        # Irei realizar esse um pouco diferente
        print(
            "2 Crie as seguintes listas ou array abaixo contendo, pelo menos 20 itens por lista: \nLista de Funcionários com os nomes e salários; \nLista de Contatos com os nomes e telefones; \nLista de Dólar Comercial com as datas, preço do dólar e preço do real.\n\n"
        )

        Data = {
            "Employess": [("Gustavo", 1.252), ("Leandro", 1.345), ("Gorges", 1.289)],
            "Contacts": [
                ("Gustavo", "(48)999999"),
                ("Leandro", "(48)99999"),
                ("Gorges", "(48)999999"),
            ],
            "dolarToday": {"dolar": {1.00}, "real": 5.00},
        }

        for dictionarie in Data:
            print(dictionarie, "->", Data[dictionarie], end="\n\n")

    @staticmethod
    def terceiraQuestao():
        print(
            "3) Crie uma lista de produtos com os seguintes requisitos: \nInicializará com 10 produtos, preços e quantidades; \nFaça um Foreach para calcular o valor total de cada produto;\n Ao final, mostre todos os produtos, preços, quantidade, total por produto e o total geral.\n"
        )

        # PRODUTO:[PRECO,QUANTIDADE]
        Products = {
            "Biscoito": [2.50, 3],
            "Agua": [0.90, 12],
            "Arroz1kg": [10.2, 2],
            "Feijao1kg": [10.6, 1],
            "Chocolate": [8.2, 2],
            "Azeite": [12.1, 2],
            "Salgadinho": [8, 3],
            "Papel": [1.5, 10],
        }

        total = 0
        for product, (price, quantity) in Products.items():
            total += price * quantity
            print(
                f"Product total: R${price*quantity} || Produto: {product} - Preço: {price} - Quantidade: {quantity}"
            )
        print(f"\nO total do carinho foi de {total}", end="\n\n")

    @staticmethod
    def quartaQuestao(matriz: list = None):
        print(
            "Ex4: Crie um programa que calcule o dobro dos\
 valores da diagonal principal de uma matriz\
 3X3."
        )

        if matriz == None:
            matriz = [
                [randint(0, 100), randint(0, 100), randint(0, 100)],
                [randint(0, 100), randint(0, 100), randint(0, 100)],
                [randint(0, 100), randint(0, 100), randint(0, 100)],
            ]

        double = []
        for index in range(len(matriz)):
            for jindex in range(len(matriz)):
                if index == jindex:
                    double.append(matriz[index][jindex] * 2)

        print("\nOs valores dobrados da diagnonal principal são: ")
        print(*double, sep=" - ", end="\n\n")

    @staticmethod
    def quintaQuestao(userMessage: str = None, randomAlfabeto: list = None):
        print(
            "Ex5: Crie um programa para realizar a criptografia e a descriptografia uma \
mensagem informada pelo usuário. Utilize programação orientada a \
objeto e dentro do objeto adicione o alfabeto como uma lista.\n\n"
        )

        # Crime cometido pelo autoformatador
        alfabeto = [
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z",
            " ",
        ]

        if userMessage == None:
            userMessage = "NENHUMA MENSAGEM ENVIADA"
        if randomAlfabeto == None:
            # Crime cometido pelo autoformatador
            randomAlfabeto = [
                "Z",
                "Y",
                "X",
                "W",
                "V",
                "U",
                "T",
                "S",
                "R",
                "Q",
                "P",
                "O",
                "N",
                "M",
                "L",
                "K",
                "J",
                "I",
                "H",
                "G",
                "F",
                "E",
                "D",
                "C",
                "B",
                "A",
                " ^ ",
            ]

        CriptMessage = ""

        for letter in userMessage:
            existOnRandomAlfabeto = (
                False  # Checks if the letter exist in the given alphabet
            )
            letterToFind = letter

            for index, alphabet in enumerate(alfabeto):
                if alphabet == letterToFind:
                    CriptMessage += randomAlfabeto[index]
                    existOnRandomAlfabeto = True

            if not existOnRandomAlfabeto:
                CriptMessage += "-"

        print(CriptMessage)


# Chamando as resoluçoes
aula1Questions.primeiraQuestao()
aula1Questions.segundaQuestao()
aula1Questions.terceiraQuestao()
aula1Questions.quartaQuestao()
aula1Questions.quintaQuestao()
