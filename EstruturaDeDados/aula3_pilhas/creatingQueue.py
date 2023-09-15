class Queue:
    def __init__(self) -> None:
        self.items = list()

    def isEmpty(self) -> bool:
        if not self.items:
            return True
        return False

    def Enqueue(self, item) -> None:
        self.items.append(item)

    def Dequeue(self) -> None:
        if self.isEmpty():
            raise IndexError("Your list is empty or the index don't exist")

        return self.items.pop(0)

    def getSize(self) -> int:
        return len(self.items)

    def printQueue(self) -> None:
        for item in self.items:
            print(item, end=", ")


myQueue = Queue()

if __name__ == "__main__":
    # DEBUG
    myQueue.isEmpty()
    myQueue.Enqueue(34)
    myQueue.Enqueue(26)
    myQueue.Enqueue(44)
    myQueue.Enqueue(55)
    myQueue.getSize()
    myQueue.Dequeue()
    myQueue.Dequeue()
    myQueue.getSize()
