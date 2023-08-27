from ex1_creatingLinkedList import LinkedList
from random import randint

# Exercicio 3
randomNum = randint(0, 19)

for _ in range(0, 19):
    if _ == 0:  # Criando as listas no primeiro loop
        listOne = LinkedList(randomNum)
        listTwo = LinkedList(randomNum)

    listOneHead = (
        listOne.head
    )  # colocando a head em outras variavel para poder realizar uma 'iteração'

    while listOneHead:  # Verificando se listOneHead é NULL
        if listOneHead.data == randomNum:
            randomNum = randint(0, 19)

            listOneHead = (
                listOne.head
            )  # É preciso resetar aqui pois deve-se checar o novo numero desde o inicio

            continue

        listOneHead = listOneHead.nextNode  # Passando para o proximo node

    listOne.insertAtEnd(randomNum)
    listTwo.insertAtBeginning(randomNum)

# Output
print("\nList One")
listOne.printList()
print("\nList Two")
listTwo.printList()


# Maneira desonesta de resolver o exercicio
# numbersInserted = set()

# numbersInserted.add(randomNum)

# while len(numbersInserted) < 19:
#     randomNum = randint(0, 19)

#     if randomNum not in numbersInserted:
#         numbersInserted.add(randomNum)
#         listOne.insertAtEnd(randomNum)
#         listTwo.insertAtBeginning(randomNum)
