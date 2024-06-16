
def BubbleSort(arr):
    x=len(arr)
    for y in range(0,x):
        for j in range(0,x-y-1):
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1]= arr[j+1],arr[j]


arr = [2,1,5,4,6,3]

print("Before sorting :{}".format(arr))
BubbleSort(arr)
print("After sorting {}".format(arr))

