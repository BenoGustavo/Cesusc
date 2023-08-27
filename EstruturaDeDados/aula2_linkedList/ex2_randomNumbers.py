# Exercicio 2
from ex1_creatingLinkedList import LinkedList
from random import randint

# Inicializando primeira lista
newList2 = LinkedList(randint(1, 100))

# Inicializando lista dobrada
newListDouble2 = LinkedList(newList2.head.data * 2)

newListHead2 = newList2.head

for _ in range(0, 5):
    newList2.insertAtEnd(randint(1, 100))
    while newListHead2.nextNode:
        newListHead2 = newListHead2.nextNode
    newListDouble2.insertAtEnd(newListHead2.data * 2)

# Output
print("\nStandard list")
newList2.printList()
print("\nDoubled list")
newListDouble2.printList()
