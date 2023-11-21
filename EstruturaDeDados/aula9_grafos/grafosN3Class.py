import networkx as nx
import matplotlib.pyplot as plt


class GrafoEstadosBrasileiros:
    """Classe que representa o grafo dos estados brasileiros adjacentes um ao outro

    Antes de utilizar qualquer função dessa classe é necessário chamar os metodos com o prefixo criar

    Dentro dessa classe existe: Representação grafica do grafo utilizando matplotlib, representaçao do grafo utilizando lista de adjacencia e matriz de adjacencia

    Returns: None (Todas as funções retornam None)
    """

    def __init__(self) -> None:
        # fmt: off
        self.__listaEstadosBrasileiros = [
            "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG",
            "PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"
        ]
        # fmt: on

        # Lista de ligações entre os estados
        self.__listaDeAdjacenciaEntreOsEstados = [
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

    def criarGrafo(self, name: str = None) -> None:
        # Create a graph
        self.grafo = nx.Graph(directed=False, name="Estados Brasileiros")

        for estado in self.__listaEstadosBrasileiros:
            self.grafo.add_node(estado)

        for ligacao in self.__listaDeAdjacenciaEntreOsEstados:
            # Verifica se existe uma lista de adjacencia
            if isinstance(ligacao[1], str):
                continue
            for estado in ligacao[1]:
                self.grafo.add_edge(ligacao[0], estado)

    def mostrarGrafoUsandoMatplotlib(self) -> None:
        nx.draw(self.grafo, with_labels=True)
        plt.show()

    def criarListaAdjacencia(self) -> None:
        self.listaAdjacencia = {}

        # Preenche a lista de adjacencia com as ligações entre os estados
        for ligacao in self.__listaDeAdjacenciaEntreOsEstados:
            estadoAtual = ligacao[0]
            estadoAdjacente = ligacao[1]

            if estadoAtual not in self.listaAdjacencia:
                self.listaAdjacencia[estadoAtual] = []

            if isinstance(estadoAdjacente, str):
                self.listaAdjacencia[estadoAtual].append(estadoAdjacente)
            else:
                self.listaAdjacencia[estadoAtual].extend(estadoAdjacente)

    def imprimirListaAdjacencia(self) -> None:
        print("\nLista de adjacência (Verificar a representação com o professor):")
        for estado, vizinhos in self.listaAdjacencia.items():
            print(estado, "->", vizinhos)

    def criarMatrizAdjacencia(self) -> None:
        print("\nMatriz de adjacência:")
        # Crie uma matriz de adjacência vazia

        self.matrizAdjacencia = [
            [0] * len(self.__listaEstadosBrasileiros)
            for _ in range(len(self.__listaEstadosBrasileiros))
        ]

        # Preencha a matriz de adjacência com as ligações entre os estados
        for ligacao in self.__listaDeAdjacenciaEntreOsEstados:
            # Verifica se existe uma lista de adjacencia
            if isinstance(ligacao[1], str):
                continue

            for estado in ligacao[1]:
                self.matrizAdjacencia[self.__listaEstadosBrasileiros.index(ligacao[0])][
                    self.__listaEstadosBrasileiros.index(estado)
                ] = 1

    def imprimirMatrizAdjacencia(self) -> None:
        # Imprima a matriz de adjacência com a legenda
        print("   ", end="")
        for estado in self.__listaEstadosBrasileiros:
            print(estado, end=" ")
        print()
        for i, linha in enumerate(self.matrizAdjacencia):
            estadoAtual = self.__listaEstadosBrasileiros[i]
            print(estadoAtual, linha)

    def imprimirInformacosDoGrafo(self):
        print("Numero de nodos " + str(self.grafo.number_of_nodes()))
        print("Numero de vertices " + str(self.grafo.number_of_edges()), end="\n\n")


if __name__ == "__main__":
    grafo = GrafoEstadosBrasileiros()
    grafo.criarGrafo()

    grafo.imprimirInformacosDoGrafo()

    grafo.criarListaAdjacencia()
    grafo.imprimirListaAdjacencia()
    grafo.criarMatrizAdjacencia()
    grafo.imprimirMatrizAdjacencia()
    grafo.mostrarGrafoUsandoMatplotlib()
