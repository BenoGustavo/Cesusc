# ( X1 + X2) * 10 * ( X3 + X4).


class Node:
    def __init__(self) -> None:
        self.data = None
        self.left = None
        self.right = None

    def insertRegex(self, regex: str):
        division = regex.split("*")

        if self.data:
            self.data = division[1].replace(" ", "")

        if self.left:
            self.left = division[0][division[0].find("+")]

        if self.right:
            self.right = division[2][division[2].find("+")]


node = Node()

node.insertRegex("( X1 + X2) * 10 * ( X3 + X4)")
