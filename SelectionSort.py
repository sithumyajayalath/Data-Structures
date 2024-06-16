def SelectionSort(arr):
    length = len(arr)
    for i in range(length):
        maxIndex = i
        for j in range(i+1, length):
            if arr[maxIndex] < arr[j]:  
                maxIndex = j

        arr[i], arr[maxIndex] = arr[maxIndex], arr[i]

arr = [21, 12, 4, 3, 7, 10]
print("Before sorting: {}".format(arr))
SelectionSort(arr)
print("After sorting in descending order: {}".format(arr))
