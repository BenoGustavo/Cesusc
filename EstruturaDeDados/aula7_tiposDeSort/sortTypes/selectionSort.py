def selectionSort(data: list) -> list:
    """This function takes a list of data as input and using selection sort algorithm returns the sorted list.

    The Selection Sort algorithm has a time complexity of O(n^2), which means that its performance
    degrades quickly as the size of the list increases. However, it has the advantage of sorting the list
    in place, without requiring additional memory.
    """
    if isinstance(data, list) is False:
        raise TypeError("The data must be a list.")

    for i in range(len(data)):
        min = i
        for j in range(i + 1, len(data)):
            if data[min] > data[j]:
                min = j

        data[i], data[min] = data[min], data[i]
    return data
