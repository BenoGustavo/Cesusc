import networkx as nx
import matplotlib.pyplot as plt


class GrafoEstadosBrasileiros:
    def __init__(self) -> None:
        # fmt: off
        self.listaEstadosBrasileiros = [
            "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG",
            "PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"
        ]
        # fmt: on

        # Lista de ligações entre os estados
        self.listaDeAdjacenciaEntreOsEstados = [
            ("AC", ("AM", "RO")),
            ("AL", ("PE", "SE")),
            ("AP", ("PA")),
            ("AM", ("AC", "PA", "MT", "RO", "RR")),
            ("BA", ("SE", "AL", "PE", "PI", "MA", "TO", "GO", "MG", "ES")),
            ("CE", ("PI", "PE", "PB", "RN")),
            ("DF", ("GO",)),
            ("ES", ("MG", "RJ")),
            ("GO", ("MT", "TO", "BA", "MG", "DF", "MS")),
            ("MA", ("PI", "TO", "PA")),
            ("MT", ("RO", "AM", "PA", "TO", "GO", "MS")),
            ("MS", ("PR", "SP", "MG", "GO", "MT")),
            ("MG", ("GO", "DF", "BA", "ES", "RJ", "SP")),
            ("PA", ("AP", "MA", "TO", "MT", "AM", "RR")),
            ("PB", ("RN", "CE", "PE")),
            ("PR", ("SP", "MS", "SC")),
            ("PE", ("PB", "CE", "PI", "BA", "AL")),
            ("PI", ("MA", "TO", "BA", "PE", "CE")),
            ("RJ", ("ES", "MG", "SP")),
            ("RN", ("CE", "PB")),
            ("RS", ("SC",)),
            ("RO", ("AC", "AM", "MT")),
            ("RR", ("AM", "PA")),
            ("SC", ("PR", "RS")),
            ("SP", ("MG", "RJ", "PR", "MS")),
            ("SE", ("BA", "AL")),
            ("TO", ("MA", "PI", "BA", "GO", "MT", "PA")),
        ]

    def criarGrafo(self, name: str = None):
        # Create a graph
        self.grafo = nx.Graph(directed=False, name="Estados Brasileiros")

        for estado in self.listaEstadosBrasileiros:
            self.grafo.add_node(estado)

        for ligacao in self.listaDeAdjacenciaEntreOsEstados:
            # Verifica se existe uma lista de adjacencia
            if isinstance(ligacao[1], str):
                continue
            for estado in ligacao[1]:
                self.grafo.add_edge(ligacao[0], estado)

    def mostrarGrafoUsandoMatplotlib(self):
        nx.draw(self.grafo, with_labels=True)
        plt.show()

    def criarMatrizAdjacencia(self):
        # Crie uma matriz de adjacência vazia
        self.matrizAdjacencia = [
            [0] * len(self.listaEstadosBrasileiros)
            for _ in range(len(self.listaEstadosBrasileiros))
        ]

        # Preencha a matriz de adjacência com as ligações entre os estados
        for ligacao in self.listaDeAdjacenciaEntreOsEstados:
            # Verifica se existe uma lista de adjacencia
            if isinstance(ligacao[1], str):
                continue

            for estado in ligacao[1]:
                self.matrizAdjacencia[self.listaEstadosBrasileiros.index(ligacao[0])][
                    self.listaEstadosBrasileiros.index(estado)
                ] = 1

    def imprimirMatrizAdjacencia(self):
        # Imprima a matriz de adjacência com a legenda
        print("   ", end="")
        for estado in self.listaEstadosBrasileiros:
            print(estado, end=" ")
        print()
        for i, linha in enumerate(self.matrizAdjacencia):
            estadoAtual = self.listaEstadosBrasileiros[i]
            print(estadoAtual, linha)
