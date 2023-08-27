from random import randint
from ex1_creatingLinkedList import LinkedList

# Exercicio4
randomNum = randint(0, 19)

listOfNumbers = LinkedList(randomNum)

for _ in range(0, 19):
    randomNum = randint(0, 19)
    listOfNumbers.insertAtBeginning(randomNum)

firstNumber = listOfNumbers.head.data
listHead = listOfNumbers.head

# Showing the values that are greather then the first value inserted
print(f"Numbers greater then {firstNumber} <- FirstNUM:  ")
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
