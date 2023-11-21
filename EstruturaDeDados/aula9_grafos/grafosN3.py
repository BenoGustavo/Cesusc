import networkx as nx
import matplotlib.pyplot as plt

# Lista de todos os estados brasileiros
# fmt: off
estados_brasileiros = [
    "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG",
    "PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"
]
# fmt: on

# Lista de ligações entre os estados
lista_de_estados_adjacentes = [
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

# Create a graph
G = nx.Graph(directed=False, name="Estados Brasileiros")

for estado in estados_brasileiros:
    G.add_node(estado)

for ligacao in lista_de_estados_adjacentes:
    if isinstance(ligacao[1], str):
        continue
    for estado in ligacao[1]:
        G.add_edge(ligacao[0], estado)

print("Numero de nodos " + str(G.number_of_nodes()))
print("Numero de vertices " + str(G.number_of_edges()), end="\n\n")

# Crie uma matriz de adjacência vazia
print("Matriz de adjacência:")
adj_matrix = [[0] * len(estados_brasileiros) for _ in range(len(estados_brasileiros))]

# Preencha a matriz de adjacência com as ligações entre os estados
for ligacao in lista_de_estados_adjacentes:
    estado_origem = estados_brasileiros.index(ligacao[0])
    if isinstance(ligacao[1], str):
        estado_destino = estados_brasileiros.index(ligacao[1])
        adj_matrix[estado_origem][estado_destino] = 1
    else:
        for estado in ligacao[1]:
            estado_destino = estados_brasileiros.index(estado)
            adj_matrix[estado_origem][estado_destino] = 1

# Imprima a matriz de adjacência com a legenda
print("   ", end="")
for estado in estados_brasileiros:
    print(estado, end=" ")
print()
for i, linha in enumerate(adj_matrix):
    estado_origem = estados_brasileiros[i]
    print(estado_origem, linha)

# Draw the graph
nx.draw(G, with_labels=True)
plt.show()
