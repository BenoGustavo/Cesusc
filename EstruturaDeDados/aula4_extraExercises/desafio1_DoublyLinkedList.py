class Node:
    def __init__(self, data: int) -> None:
        self.data = data
        self.nextNode = None
        self.previousNode = None

    def __str__(self) -> str:
        return str(self.data)
    
class DoublyLinkedList:
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

            #The head don't have previousNode so it's none
            self.head.previousNode = None
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
        newNode.nextNode.previousNode = newNode

        self.head = newNode


    def insertAtEnd(self, data):
        newNode = self.head
        while newNode.nextNode:
            newNode = newNode.nextNode

        newNode.nextNode = Node(data)
        newNode.nextNode.previousNode = newNode
        
        
    #This method don't append any kind of previous
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
        newNode.previousNode = actualNode

        if actualNode.nextNode is not None:
            actualNode.nextNode.previousNode = newNode  # Set the previous node of the node after the insertion point
        
        actualNode.nextNode = newNode

    def printBackwards(self):
        actualNode = self.head
        while actualNode.nextNode:
            actualNode = actualNode.nextNode
        
        while actualNode.previousNode:
            print(f"{actualNode.data}, ",end="")
            actualNode = actualNode.previousNode

        print(actualNode.data)

    def printList(self):
        printedNode = self.head

        while printedNode:
            print(f"{printedNode}, ", end="")
            printedNode = printedNode.nextNode

if __name__ == "__main__":

    # Testing functions

    newList = DoublyLinkedList(1)

    #Testing previous
    newList.insertAtBeginning(2)
    newList.insertAtBeginning(3)
    newList.insertAtBeginning(4)
    newList.InsertAtIndex(10,1)
    
    #newList.removeAtBeginning()
    #newList.removeAtEnd()

    newList.printList()
    print()
    newList.printBackwards()

    # newList.insertAtBeginning(2)
    # newList.insertAtBeginning(3)
    # newList.insertAtBeginning(5)
    # newList.InsertAtIndex(4, 5)
    # newList.removeAtEnd()
    # print("Elemento encontrado no indice: ", newList.findElement(2))
    # newList.removeAtBeginning()
    # newList.removeAtBeginning()
    # newList.removeAtBeginning()
    # newList.removeAtBeginning()
    # newList.removeAtBeginning()
    # newList.printList()


    # Debug and understanding

    # obj1 = Node(10)
    # obj2 = Node(8)
    # obj1.nextNode = obj2
    # print(obj1)
    # print(obj1.nextNode)