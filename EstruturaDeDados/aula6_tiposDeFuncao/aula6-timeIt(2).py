from time import time

timeStart = time()

n = 10000

for i in range(n):
    j = i
    for j in range(n):
        print(j)
    print(i)

timeEnd = time()

print("Tempo de execução: ", timeEnd - timeStart)