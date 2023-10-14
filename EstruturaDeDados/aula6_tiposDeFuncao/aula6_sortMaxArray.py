from time import time
import sys

#Remove recursion limit (Can explode ur computer)
sys.setrecursionlimit(1000000)

def sortMaxArray(A,n):
    currentMax = A[0]
    for i in range(1,n):
        if A[i] > currentMax:
            currentMax = A[i]
    return currentMax

def recursiveMaxArray(A,n):
    if n == 1:
        return A[0]
    else:
        return max(A[n-1],recursiveMaxArray(A,n-1))

#Don't finished
def recursiveMaxArrayLegit(array,currentMax,index):
    if index  + 1 == len(array):
        return currentMax
    elif len(array) >= 0 and index  <= len(array):
        if currentMax < array[index]:
            currentMax = array[index]
        recursiveMaxArrayLegit(array,currentMax,index + 1)


startTime = time()
print(sortMaxArray([1,2,3,4,5,6,7,8,9,10],3))
print(f"For loop: {time() - startTime}")
startTime = time()
print(recursiveMaxArray([1,2,3,4,5,6,7,8,9,10],10))
print(f"Recursive: {time() - startTime}")
print(recursiveMaxArrayLegit([1,2,3,4,5,6,7,8,9,10],10,0))