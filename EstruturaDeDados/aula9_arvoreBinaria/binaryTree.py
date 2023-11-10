class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def insert(self, data):
        """Valores maiores que a raiz são inseridos na direita, menores para a esquerda"""
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Node(data)
                else:
                    self.left.insert(data)
            elif data > self.data:
                if self.right is None:
                    self.right = Node(data)
                else:
                    self.right.insert(data)
        else:
            self.data == data

    def printTree(self):
        if self.left:
            self.left.printTree()

        print(self.data)

        if self.right:
            self.right.printTree()

    def printPreOrderedTree(self):
        print(self.data)

        if self.left:
            self.left.printTree()

        if self.right:
            self.right.printTree()

    def printPostOrderedTree(self):
        if self.left:
            self.left.printTree()

        if self.right:
            self.right.printTree()

        print(self.data)

    def searchInTree(self, data):
        if self.data == data:
            return self

        if self.left:
            if self.left.searchInTree(data):
                return self.left.searchInTree(data)

        if self.right:
            if self.right.searchInTree(data):
                return self.right.searchInTree(data)

        return None


if __name__ == "__main__":
    listOfNumbers = [5, 2, 7, 15, 22]
    tree = Node(10)

    for number in listOfNumbers:
        tree.insert(number)

    print("Pre-ordered tree")
    tree.printPreOrderedTree()
    print("post-ordered tree")
    tree.printPostOrderedTree()
    print("ordered tree")
    tree.printTree()

    print("search in tree")
    print(tree.searchInTree(2).data)
