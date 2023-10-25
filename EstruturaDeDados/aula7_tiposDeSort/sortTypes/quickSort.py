def quickSort(data: list) -> list:
    """This function takes a list of data as input and using quick sort algorithm returns the sorted list.

    The Quick Sort algorithm has a time complexity of O(n log n) on average,
    which means that its performance is much better than Bubble Sort and Insertion
    Sort for large lists. However, its worst-case time complexity is O(n^2), which occurs
    when the pivot is selected as the smallest or largest element in the list."""
    if isinstance(data, list) is False:
        raise TypeError("The data must be a list.")

    if len(data) <= 1:
        return data

    pivot = data[len(data) // 2]
    left = [x for x in data if x < pivot]
    middle = [x for x in data if x == pivot]
    right = [x for x in data if x > pivot]
    return quickSort(left) + middle + quickSort(right)
