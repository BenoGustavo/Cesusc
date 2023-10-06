from time import time

timeStart = time()

n = 10000

for i in range(n):
    print(i)

timeEnd = time()

print("Tempo de execução: ", timeEnd - timeStart)