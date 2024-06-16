def InsertionSOrt(arr):
    x = len(arr)

    for i in range(1,x):
        M= arr[i]
        j = i-1
        while j>=0 and M<arr[j]:
            arr[j+1]=arr[j]
            j=j-1
        arr[j+1]=M

arr = [12,1,5,4,6,13]
print("Before sorting :{}".format(arr))
InsertionSOrt(arr)
print("After sorting {}".format(arr))
