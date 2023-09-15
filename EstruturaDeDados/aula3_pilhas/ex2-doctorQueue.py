from creatingQueue import Queue
from time import sleep

peoples = ["Joao","Fernando","Gustavo"]

doctorQueue = Queue()

for people in peoples:
    doctorQueue.Enqueue(people)

for i in range(doctorQueue.getSize()):
    print("\nThe queue is: ")
    doctorQueue.printQueue()
    people = doctorQueue.Dequeue()

    print(f"\n{people} was called and getted out of the queue")
    sleep(5)

