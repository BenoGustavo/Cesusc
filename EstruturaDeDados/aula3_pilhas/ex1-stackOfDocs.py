from creatingStack import Stack

stackOfDocuments = Stack()

#Creating 11 docs
for i in range(1,11):
    stackOfDocuments.append(f"Document {i}")

print(stackOfDocuments.getStack())