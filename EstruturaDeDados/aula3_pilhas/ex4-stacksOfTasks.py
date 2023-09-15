from creatingStack import Stack
from datetime import datetime
from time import sleep

tasks = ["Run some errands 5:00PM","Clean the dishes 12:30PM","Clean the floor 8:00AM"]

stackOfTasks = Stack()

for task in tasks:
    stackOfTasks.append(task)

for i in range(stackOfTasks.getSizeOfTheStack()):
    dateTime = datetime.now().strftime("%H:%M:%S")
    print("\nThe stack is: ")
    print(stackOfTasks.getStack())
    task = stackOfTasks.pop()

    print(f"\n{task} was finished at {dateTime} and getted out of the stack")
    sleep(5)

