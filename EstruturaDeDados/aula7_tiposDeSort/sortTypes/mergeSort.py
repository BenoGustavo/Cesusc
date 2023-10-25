def merge(arr, left, right):
    i = j = k = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            arr[k] = left[i]
            i += 1
        else:
            arr[k] = right[j]
            j += 1
        k += 1
    while i < len(left):
        arr[k] = left[i]
        i += 1
        k += 1
    while j < len(right):
        arr[k] = right[j]
        j += 1
        k += 1


def mergeSort(data: list) -> list:
    """This function takes a list of data as input and using bubble sort algorithm returns the sorted list.

    The Merge Sort algorithm has a time complexity of O(n log n), which means that its performance is much better
    than Bubble Sort and Insertion Sort for large lists. It is also a stable sorting algorithm, which means that it maintains
    the relative order of equal elements in the sorted list."""

    if isinstance(data, list) is False:
        raise TypeError("The data must be a list.")

    if len(data) > 1:
        mid = len(data) // 2
        left = data[:mid]
        right = data[mid:]
        mergeSort(left)
        mergeSort(right)
        merge(data, left, right)
    return data
