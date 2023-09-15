class Stack:
    def __init__(self) -> None:
        self.stack = []
    
    def isStackEmpty(self):
        if len(self.stack) == 0:
            return True
        return False

    def getSizeOfTheStack(self):
        return len(self.stack)

    def pop(self):
        if len(self.stack) <= 0:
            return
        return self.stack.pop()
    
    def getStack(self):
        if not self.isStackEmpty():
            return self.stack
        print("Lista vazia")

    def append(self,data):
        self.stack.append(data)
    
# fila = []
# fila.estaVazia()
# fila.enfileira(34)
# fila.enfileira(26)
# fila.enfileira(44)
# fila.enfileira(55)
# fila.tamanho()
# fila.desenfileira()
# fila.desenfileira()
# fila.tamanho()

if __name__ == "__main__":

    stack = Stack()

    print("Is stack empty? ->",stack.isStackEmpty())
    stack.append(1)
    print(stack.getStack())
    stack.append(2)
    print(stack.getStack())
    stack.append(3)
    print(stack.getStack())
    stack.append(4)
    print(stack.getStack())
    print("Is stack empty? ->",stack.isStackEmpty())
    print("The lenght of the stack is: ",stack.getSizeOfTheStack())
    print("Removed the last value, and it was: ",stack.pop())
    print(stack.getStack())