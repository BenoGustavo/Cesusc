from random import randint
from ex1_creatingLinkedList import LinkedList

# Exercicio4
randomNum = randint(0, 100)

#Colocando apenas valores unicos na lista
for _ in range(0, 19):
    if _ == 0:  # Criando as listas no primeiro loop
        listOfNumbers = LinkedList(randomNum)

    listHead = (
        listOfNumbers.head
    )  # colocando a head em outras variavel para poder realizar uma 'iteração'

    while listHead:  # Verificando se listHead é NULL
        if listHead.data == randomNum:
            randomNum = randint(0, 100)

            listHead = (
                listOfNumbers.head
            )  # É preciso resetar aqui pois deve-se checar o novo numero desde o inicio

            continue

        listHead = listHead.nextNode  # Passando para o proximo node

    listOfNumbers.insertAtEnd(randomNum)

firstNumber = listOfNumbers.head.data
listHead = listOfNumbers.head

print('The list is: ')
listOfNumbers.printList()

# Showing the values that are greather then the first value inserted
print(f"\n\nNumbers greater then {firstNumber} <- FirstNUM:  ")
while listHead:
    if firstNumber < listHead.data:
        print(f"{listHead.data, }", end="")
    listHead = listHead.nextNode

listHead = listOfNumbers.head  # reseting the head

# Showing the pair values
print(f"\n\nPair numbers in the list:  ")
while listHead:
    if listHead.data % 2 == 0:
        print(f"{listHead.data}, ", end="")
    listHead = listHead.nextNode
