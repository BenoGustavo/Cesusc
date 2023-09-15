from creatingQueue import Queue
from time import sleep

cars = ["Fuscao","Gol quadrado","Gol redondo","Fiat mobi"]

carToWashQueue = Queue()

for car in cars:
    carToWashQueue.Enqueue(car)

for i in range(carToWashQueue.getSize()):
    print("\nThe queue is: ")
    carToWashQueue.printQueue()
    print(f" with the size of {carToWashQueue.getSize()}",end="")
    car = carToWashQueue.Dequeue()

    print(f"\n{car} was washed and getted out of the queue")
    sleep(5)

