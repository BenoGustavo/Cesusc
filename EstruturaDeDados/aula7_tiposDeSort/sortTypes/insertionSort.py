def insertionSort(data: list) -> list:
    """This function takes a list of data as input and using insertion sort algorithm returns the sorted list.

    Its time complexity is O(n^2) which means that its performance degrades quickly as the size of the list increases.
    """

    if isinstance(data, list) is False:
        raise TypeError("The data must be a list.")

    for i in range(1, len(data)):
        key = data[i]
        j = i - 1

        # Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
        while j >= 0 and key < data[j]:
            data[j + 1] = data[j]
            j -= 1

        data[j + 1] = key

    return data
