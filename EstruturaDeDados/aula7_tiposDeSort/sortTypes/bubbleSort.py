def bubbleSort(data: list) -> list:
    """This function takes a list of data as input and using bubble sort algorithm returns the sorted list.

    Its time complexity is O(n^2) which means that its performance degrades quickly as the size of the list increases.
    """

    if isinstance(data, list) is False:
        raise TypeError("The data must be a list.")

    listSize = len(data)

    for i in range(listSize):
        for j in range(0, listSize - i - 1):
            # Swap if the element found is greater than the next element
            if data[j] > data[j + 1]:
                data[j], data[j + 1] = data[j + 1], data[j]

    return data
