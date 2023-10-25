import sortTypes.bubbleSort as bubbleSort
import sortTypes.insertionSort as insertionSort
import sortTypes.mergeSort as mergeSort
import sortTypes.quickSort as quickSort
import sortTypes.selectionSort as selectionSort

from random import randint
from timeit import default_timer as timer

listOfNumbers = [randint(0, 100) for _ in range(20)]
print(f"Original list: {listOfNumbers}")

print("\nBubbleSort:")
timerStart = timer()
print(f"Sorted list: {bubbleSort.bubbleSort(listOfNumbers)}")
timerEnd = timer()
print(f"Execution time: {timerEnd - timerStart} seconds")

print("\nselectionSort:")
timerStart = timer()
print(f"Sorted list: {selectionSort.selectionSort(listOfNumbers)}")
timerEnd = timer()
print(f"Execution time: {timerEnd - timerStart} seconds")

print("\nInsetionSort:")
timerStart = timer()
print(f"Sorted list: {insertionSort.insertionSort(listOfNumbers)}")
timerEnd = timer()
print(f"Execution time: {timerEnd - timerStart} seconds")

print("\nQuickSort:")
timerStart = timer()
print(f"Sorted list: {quickSort.quickSort(listOfNumbers)}")
timerEnd = timer()
print(f"Execution time: {timerEnd - timerStart} seconds")

print("\nMergeSort:")
timerStart = timer()
print(f"Sorted list: {mergeSort.mergeSort(listOfNumbers)}")
timerEnd = timer()
print(f"Execution time: {timerEnd - timerStart} seconds")
