import networkx as nx
import matplotlib.pyplot as plt

"""INSTALE AS DEPENDENCIAS ANTES DE EXECUTAR O CODIGO (pip install -r requirements.txt)"""


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
            "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","EX1","EX2","EX3",
            "PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"
        ]

        # Lista de ligações entre os estados
        self.__listaDeAdjacenciaEntreOsEstados = [
            ("AC", ("AM", "RO", "EX3")),
            ("AL", ("PE", "SE")),
            ("AP", ("PA","EX1","EX2")),
            ("AM", ("AC", "PA", "MT", "RO", "RR")),
            ("BA", ("SE", "PI", "TO", "MG", "ES")),
            ("CE", ("PI", "PE", "PB", "RN")),
            ("DF", ("GO",)),
            ("ES", ("MG", "RJ")),
            ("GO", ("MT", "TO", "BA", "MG", "DF", "MS")),
            ("MA", ("PI", "TO", "PA","EX2")),
            ("MT", ("RO", "AM", "PA", "TO", "GO", "MS","EX3")),
            ("MS", ("PR", "SP", "MG", "GO", "MT","EX3")),
            ("MG", ("GO", "DF", "BA", "ES", "RJ", "SP")),
            ("PA", ("AP", "MA", "TO", "MT", "AM", "RR","EX1","EX2")),
            ("PB", ("RN", "CE", "PE")),
            ("PR", ("SP", "MS", "SC")),
            ("PE", ("CE", "PI", "BA", "AL")),
            ("PI", ("MA", "TO", "BA", "PE", "CE")),
            ("RJ", ("ES", "MG", "SP")),
            ("RN", ("CE", "PB")),
            ("RS", ("SC",)),
            ("RO", ("AC", "AM", "MT","EX3")),
            ("RR", ("AM", "PA","EX1")),
            ("SC", ("PR")),
            ("SP", ("MG", "RJ", "PR", "MS")),
            ("SE", ("BA", "AL")),
            ("TO", ("MA", "PI", "BA", "GO", "MT", "PA")),
            ("EX1",("AP","PA","RR")),
            ("EX2",("AP","MA","PA")),
            ("EX3",("AC","MT","MS","RO")),
        ]

        #ANOTANDO AS PONDERAÇÕES ENTRE OS ESTADOS
        self.__ponderacaoEntreOsEstados = [
            (803, 510),  # AC -> AM, RO
            (87, 144),  # AL -> PE, SE
            (400),  # AP -> PA
            (803, 1490, 1424, 934, 804),  # AM -> AC, PA, MT, RO, RR
            (425,402,794,774,871),  # BA -> SE, PI, TO, MG, ES
            (529, 452, 341,263),  # CE -> PI, PE, PB, RN
            (174),  # DF -> GO
            (540,518),  # ES -> MG, RJ
            (880,827,1228,589,147,739),  # GO -> MT, TO, BA, MG, DF, MS
            (376, 743, 824),  # MA -> PI, TO, PA
            (736,1424,856,1021,880,928),  # MT -> RO, AM, PA, TO, GO, MS
            (573, 893, 1196, 739, 928),  # MS -> PR, SP, MG, GO, MT
            (598, 498, 774, 540, 557, 692),  # MG -> GO, DF, BA, ES, RJ, SP
            (400,824,604,856,1490,1440), # PA -> AP, MA, TO, MT, AM, RR
            (260, 341, 177),  # PB -> RN, CE, PE
            (575, 573, 325),  # PR -> SP, MS, SC
            (452, 687, 806, 87),  # PE -> CE, PI, BA, AL
            (376, 566, 402, 687, 529),  # PI -> MA, TO, BA, PE, CE
            (518, 557, 360),  # RJ -> ES, MG, SP
            (263, 260),  # RN -> CE, PB
            (490),  # RS -> SC
            (510, 934, 736),  # RO -> AC, AM, MT
            (804, 1440),  # RR -> AM, PA
            (325),  # SC -> PR
            (692, 360, 575, 893),  # SP -> MG, RJ, PR, MS
            (425, 144),  # SE -> BA, AL
            (743, 566, 794, 827, 1021,604 ),  # TO -> MA, PI, BA, GO, MT, PA
        ]

        self.__listaDeDadosDeTodosOsEstadosBrasileiros = [
            ("AC", (("AM", 803), ("RO", 510),("EX3",550))),
            ("AL", (("PE", 87), ("SE", 144))),
            ("AP", (("PA", 400),("EX1",400),("EX2",350))),
            ("AM", (("AC", 803), ("PA", 1490), ("MT", 1424), ("RO", 934), ("RR", 804))),
            ("BA", (("SE", 425), ("PI", 402), ("TO", 794), ("MG", 774), ("ES", 871))),
            ("CE", (("PI", 529), ("PE", 452), ("PB", 341), ("RN", 263))),
            ("DF", (("GO", 174),)),
            ("ES", (("MG", 540), ("RJ", 518))),
            ("GO", (("MT", 880), ("TO", 827), ("BA", 1228), ("MG", 589), ("DF", 147), ("MS", 739))),
            ("MA", (("PI", 376), ("TO", 743), ("PA", 824),("EX2",800))),
            ("MT", (("RO", 736), ("AM", 1424), ("PA", 856), ("TO", 1021), ("GO", 880), ("MS", 928),("EX3",380))),
            ("MS", (("PR", 573), ("SP", 893), ("MG", 1196), ("GO", 739), ("MT", 928),("EX3",450))),
            ("MG", (("GO", 598), ("DF", 498), ("BA", 774), ("ES", 540), ("RJ", 557), ("SP", 692))),
            ("PA", (("AP", 400), ("MA", 824), ("TO", 604), ("MT", 856), ("AM", 1490), ("RR", 1440),("EX1",900),("EX2",850))),
            ("PB", (("RN", 260), ("CE", 341), ("PE", 177))),
            ("PR", (("SP", 575), ("MS", 573), ("SC", 325))),
            ("PE", (("CE", 452), ("PI", 687), ("BA", 806), ("AL", 87))),
            ("PI", (("MA", 376), ("TO", 566), ("BA", 402), ("PE", 687), ("CE", 529))),
            ("RJ", (("ES", 518), ("MG", 557), ("SP", 360))),
            ("RN", (("CE", 263), ("PB", 260))),
            ("RS", (("SC", 490),)),
            ("RO", (("AC", 510), ("AM", 934), ("MT", 736),("EX3",325))),
            ("RR", (("AM", 804), ("PA", 1440),("EX1",450))),
            ("SC", (("PR", 325),)),
            ("SP", (("MG", 692), ("RJ", 360), ("PR", 575), ("MS", 893))),
            ("SE", (("BA", 425), ("AL", 144))),
            ("TO", (("MA", 743), ("PI", 566), ("BA", 794), ("GO", 827), ("MT", 1021), ("PA", 604))),
        ]
        # fmt: on

    def criarGrafo(self) -> None:
        """Esse metodo cria o grafo utilizando a biblioteca networkx"""

        # Cria um grafo vazio não direcionado e com um nome
        self.grafo = nx.Graph(directed=False, name="Estados Brasileiros")

        # Adiciona os estados brasileiros como nodos do grafo
        for estado in self.__listaEstadosBrasileiros:
            self.grafo.add_node(estado)

        # Adiciona os vértices e arestas ao grafo
        for estado, ligacoes in self.__listaDeDadosDeTodosOsEstadosBrasileiros:
            for ligacao, peso in ligacoes:
                self.grafo.add_edge(estado, ligacao, weight=peso)

    def mostrarGrafoUsandoMatplotlib(self) -> None:
        """Esse metodo mostra a representação grafica do grafo utilizando a biblioteca matplotlib

        ANTES DE UTILIZAR ESSE METODO É NECESSARIO CHAMAR O METODO criarGrafo"""

        # Define a posição dos nós
        pos = nx.spring_layout(self.grafo)

        # Utilizamos o metodo draw passando o nosso grafo preenchido como paramentro
        # O parametro with_labels é para mostrar o nome dos estados na representação grafica
        nx.draw(self.grafo, pos, with_labels=True)

        # Obtem os pesos das arestas e os adiciona como labels
        edge_labels = nx.get_edge_attributes(self.grafo, "weight")

        # Desenha os rótulos das arestas
        nx.draw_networkx_edge_labels(self.grafo, pos, edge_labels=edge_labels)

        # Mostra a representação grafica do grafo
        plt.savefig("grafo.png")
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

    def imprimirInformacosDoGrafo(self) -> None:
        """Mostra na tela o numero de vertices e arrestas do grafo"""
        print("Numero de vertices: " + str(self.grafo.number_of_nodes()))
        print("Numero de arrestas: " + str(self.grafo.number_of_edges()), end="\n\n")

    def buscaEmLargura(self, estado_inicial: str) -> None:
        """Realiza a busca em largura a partir de um estado inicial"""

        # Cria uma fila vazia para armazenar os estados a serem visitados
        fila = []

        # Cria um conjunto vazio para armazenar os estados visitados
        visitados = set()

        # Adiciona o estado inicial na fila
        fila.append(estado_inicial)

        # Inicializa o contador de etapas
        etapa = 0

        # Enquanto a fila não estiver vazia
        while fila:
            # Remove o primeiro estado da fila
            estado_atual = fila.pop(0)

            # Verifica se o estado atual já foi visitado
            if estado_atual not in visitados:
                # Marca o estado atual como visitado
                visitados.add(estado_atual)

                # Obtém os vizinhos do estado atual
                vizinhos = self.listaAdjacencia.get(estado_atual, [])

                # Imprime o estado atual, o número da etapa e os vizinhos
                print(
                    f"Etapa {etapa}: Visitando o estado {estado_atual}, que tem os vizinhos: {vizinhos}"
                )

                # Obtém os vizinhos do estado atual
                vizinhos = self.listaAdjacencia.get(estado_atual, [])

                # Adiciona os vizinhos na fila
                fila.extend(vizinhos)

                # Incrementa o contador de etapas
                etapa += 1

    def buscarMenorCaminhoEntreDoisEstados(
        self, estado_inicial: str, estado_final: str
    ) -> list[str]:
        """Realiza a busca em largura a partir de um estado inicial para encontrar o menor caminho até um estado final"""

        # Cria uma fila vazia para armazenar os estados a serem visitados
        fila = []

        # Cria um conjunto vazio para armazenar os estados visitados
        visitados = set()

        # Adiciona o estado inicial na fila
        fila.append([estado_inicial])

        # Enquanto a fila não estiver vazia
        while fila:
            # Remove o primeiro caminho da fila
            caminho = fila.pop(0)

            # Obtém o estado atual do caminho
            estado_atual = caminho[-1]

            # Verifica se o estado atual é o estado final
            if estado_atual == estado_final:
                return caminho

            # Verifica se o estado atual já foi visitado
            if estado_atual not in visitados:
                # Marca o estado atual como visitado
                visitados.add(estado_atual)

                # Obtém os vizinhos do estado atual
                vizinhos = self.listaAdjacencia.get(estado_atual, [])

                # Para cada vizinho do estado atual
                for vizinho in vizinhos:
                    # Cria um novo caminho adicionando o vizinho ao caminho atual
                    novo_caminho = list(caminho)
                    novo_caminho.append(vizinho)

                    # Adiciona o novo caminho na fila
                    fila.append(novo_caminho)


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

    print("\n\n")
    print("Busca em largura:")
    grafo.buscaEmLargura("AC")
    print("\n\n")

    menorCaminho = grafo.buscarMenorCaminhoEntreDoisEstados("AC", "MT")

    print("Menor caminho entre dois estados:")
    print(*menorCaminho, sep=" -> ")

    # Mostra a representação grafica do grafo
    grafo.mostrarGrafoUsandoMatplotlib()
