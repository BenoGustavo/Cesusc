import sys
from time import time

sys.setrecursionlimit(10000000)

timeStart = time()

def recursion(n):
    if n == 0:
        return 0
    else:
        return n + recursion(n-1)

recursion(10000000)

timeEnd = time()
print("Tempo de execução: ", timeEnd - timeStart)