class TestingThings:
    def __init__(self, lista=None) -> None:
        if lista is None:
            lista = []
        self.listaMassa = lista

    @property
    def getListaMassa(self):
        return self.listaMassa

    @getListaMassa.setter
    def setItemIntoLista(self, data):
        if data > 100 or data < 0:
            raise Exception("data need to be < 100 and > 0")
        self.listaMassa.append(data)


teste = TestingThings()

teste.setItemIntoLista = 100

print(teste.getListaMassa)
