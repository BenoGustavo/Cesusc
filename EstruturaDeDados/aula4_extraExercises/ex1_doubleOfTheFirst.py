from linkedList import LinkedList
from random import randint

numbersToAdd = [randint(0,100),randint(0,100),randint(0,100),randint(0,100),randint(0,100),randint(0,100),randint(0,100)]

for index,number in enumerate(numbersToAdd):
    if index == 0:
        firstLinkedList = LinkedList(number)
        secondLinkedList = LinkedList(number*2)
        continue

    firstLinkedList.insertAtEnd(number)
    secondLinkedList.insertAtEnd(number*2)

print(f"The standard list is: {numbersToAdd}\n\nThe first list is: ")
firstLinkedList.printList()
print(f"\nThe second list with the numbers in doubled are:")
secondLinkedList.printList()