# Exercicio 1


class Node:
    def __init__(self, data: int) -> None:
        self.data = data
        self.nextNode = None

    def __str__(self) -> str:
        return str(self.data)


class LinkedList:
    def __init__(self, data: int) -> None:
        self.head = Node(data)
        self.data = data

    def findElement(self, data):
        node = self.head
        index = 0
        while node.data != data:
            index += 1
            node = node.nextNode

        if node.data == data:
            return index

        print("Valor não existe na lista")

    def removeAtBeginning(self):
        if self.head is not None:
            self.head = self.head.nextNode
        else:
            print("Your list is empty")

    def removeAtEnd(self):
        if self.head is None:
            print("Your list is empty")
            return

        # if the first next value of the head is none the last value is the head itself
        if self.head.nextNode is None:
            self.head = None
            return

        finalNode = self.head
        head = self.head
        while finalNode.nextNode:
            head = finalNode
            finalNode = finalNode.nextNode
        head.nextNode = None

    def insertAtBeginning(self, data):
        newNode = Node(data)
        newNode.nextNode = self.head
        self.head = newNode

    def insertAtEnd(self, data):
        newNode = self.head
        while newNode.nextNode:
            newNode = newNode.nextNode

        newNode.nextNode = Node(data)

    def InsertAtIndex(self, data: int, index: int) -> None:
        newNode = Node(data)
        actualNode = self.head

        count = 0
        while count < index - 1:
            if actualNode.nextNode == None:
                raise IndexError("Insert a valid index")

            count += 1
            actualNode = actualNode.nextNode

        newNode.nextNode = actualNode.nextNode
        actualNode.nextNode = newNode

    def printList(self):
        printedNode = self.head

        while printedNode:
            print(f"{printedNode}, ", end="")
            printedNode = printedNode.nextNode


# Testing functions

newList = LinkedList(1)
newList.insertAtBeginning(8)
newList.insertAtEnd(2)
newList.insertAtEnd(3)
newList.insertAtEnd(5)
newList.InsertAtIndex(4, 5)
newList.removeAtEnd()
print("Elemento encontrado no indice: ", newList.findElement(2))
# newList.removeAtBeginning()
# newList.removeAtBeginning()
# newList.removeAtBeginning()
# newList.removeAtBeginning()
# newList.removeAtBeginning()
newList.printList()


# Debug and understanding

# obj1 = Node(10)
# obj2 = Node(8)
# obj1.nextNode = obj2
# print(obj1)
# print(obj1.nextNode)
