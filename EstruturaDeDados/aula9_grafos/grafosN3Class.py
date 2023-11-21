import networkx as nx
import matplotlib.pyplot as plt


class GrafoEstadosBrasileiros:
    """Classe que representa o grafo dos estados brasileiros adjacentes um ao outro

    Antes de utilizar qualquer função dessa classe é necessário chamar os metodos com o prefixo criar

    Dentro dessa classe existe: Representação grafica do grafo utilizando matplotlib, representaçao do grafo utilizando lista de adjacencia e matriz de adjacencia

    Returns: None (Todas as funções retornam None)
    """

    def __init__(self) -> None:
        # cria uma lista de estados brasileiros (O comentario a baixo é para remover a formatação automatica do black)

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

    def criarGrafo(self) -> None:
        """Esse metodo cria o grafo utilizando a biblioteca networkx"""

        # Cria um grafo vazio não direcionado e com um nome
        self.grafo = nx.Graph(directed=False, name="Estados Brasileiros")

        # Adiciona os estados brasileiros como nodos do grafo
        for estado in self.__listaEstadosBrasileiros:
            self.grafo.add_node(estado)

        # Adiciona as ligações entre os estados como arestas do grafo
        for ligacao in self.__listaDeAdjacenciaEntreOsEstados:
            # Verifica se existe uma lista de adjacencia
            if isinstance(ligacao[1], str):
                continue

            # Vincula os elementos da tupla como arestas da ligação[0]
            for estado in ligacao[1]:
                self.grafo.add_edge(ligacao[0], estado)

    def mostrarGrafoUsandoMatplotlib(self) -> None:
        """Esse metodo mostra a representação grafica do grafo utilizando a biblioteca matplotlib

        ANTES DE UTILIZAR ESSE METODO É NECESSARIO CHAMAR O METODO criarGrafo"""

        # Utilizamos o metodo draw passando o nosso grafo preenchido como paramentro
        # O parametro with_labels é para mostrar o nome dos estados na representação grafica
        nx.draw(self.grafo, with_labels=True)

        # Mostra a representação grafica do grafo
        plt.show()

    def criarListaAdjacencia(self) -> None:
        """Esse metodo cria a lista de adjacencia do grafo"""

        # Cria um dict vazio para alocar as lista de adjacencia
        self.listaAdjacencia = {}

        # Preenche a lista de adjacencia com as ligações entre os estados
        for ligacao in self.__listaDeAdjacenciaEntreOsEstados:
            # Coleta o estado atual e o estado adjacente
            estadoAtual = ligacao[0]
            estadoAdjacente = ligacao[1]

            # Verifica se o estado atual já existe na lista de adjacencia
            if estadoAtual not in self.listaAdjacencia:
                self.listaAdjacencia[estadoAtual] = []

            # Verifica se o estado adjacente é uma string se for é porque é um estado que não tem ligação com nenhum outro estado
            if isinstance(estadoAdjacente, str):
                # Adiciona o estado adjacente na lista de adjacencia do estado atual
                self.listaAdjacencia[estadoAtual].append(estadoAdjacente)
            else:
                # Adiciona os estados adjacentes na lista de adjacencia do estado atual
                self.listaAdjacencia[estadoAtual].extend(estadoAdjacente)

    def imprimirListaAdjacencia(self) -> None:
        """Esse metodo imprime a lista de adjacencia do grafo

        ANTES DE UTILIZAR ESSE METODO É NECESSARIO CHAMAR O METODO criarListaAdjacencia
        """

        print("\nLista de adjacência (Verificar a representação com o professor):")

        # Passa por todos os itens do dicionario desempacotando o estado e seus vizinhos
        for estado, vizinhos in self.listaAdjacencia.items():
            # Imprime o estado e seus vizinhos
            print(estado, "->", vizinhos)

    def criarMatrizAdjacencia(self) -> None:
        """Esse metodo cria a matriz de adjacencia do grafo"""

        print("\nMatriz de adjacência:")
        # Crie uma matriz de adjacência vazia

        # Utiliza a list Comprehension para criar uma matriz de adjacencia vazia com o tamanho da lista de estados brasileiros
        self.matrizAdjacencia = [
            [0] * len(self.__listaEstadosBrasileiros)
            for _ in range(len(self.__listaEstadosBrasileiros))
        ]

        # Preenche a matriz de adjacência com as ligações entre os estados
        for ligacao in self.__listaDeAdjacenciaEntreOsEstados:
            # Verifica se existe uma lista de adjacencia (se for string não deve ser iterado)
            if isinstance(ligacao[1], str):
                continue

            # Vincula os elementos da tupla como arestas da ligação[0]
            for estado in ligacao[1]:
                # Preenche a matriz de adjacência com 1 se existir uma ligação entre os estados
                self.matrizAdjacencia[self.__listaEstadosBrasileiros.index(ligacao[0])][
                    self.__listaEstadosBrasileiros.index(estado)
                ] = 1

    def imprimirMatrizAdjacencia(self) -> None:
        """Esse metodo imprime a matriz de adjacencia do grafo

        ANTES DE UTILIZAR ESSE METODO É NECESSARIO CHAMAR O METODO criarMatrizAdjacencia
        """

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
    # Cria um objeto da classe GrafoEstadosBrasileiros
    grafo = GrafoEstadosBrasileiros()
    # Cria o grafo
    grafo.criarGrafo()

    # Imprime as informações do grafo (numero de nodos e numero de vertices)
    grafo.imprimirInformacosDoGrafo()

    # Cria a lista de adjacencia e imprime ela
    grafo.criarListaAdjacencia()
    grafo.imprimirListaAdjacencia()

    # Cria a matriz de adjacencia e imprime ela
    grafo.criarMatrizAdjacencia()
    grafo.imprimirMatrizAdjacencia()

    # Mostra a representação grafica do grafo
    grafo.mostrarGrafoUsandoMatplotlib()
