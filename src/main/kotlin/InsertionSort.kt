fun sort(arr: Array<Int>) {
    for (i in arr.indices) {
        val key = arr[i] // Key is current element being sorted

        var j = i - 1

        /*
            * if key < arr[j]
            * replace current position with previous position
            * since j points at previous position, j + 1 will point at current position
            * then decrement j again
            * repeat above steps till key > arr[previous position (j)]
            * set arr[j+1] to key,
         */
        while (j >= 0 && key < arr[j]) {
            arr[j + 1] = arr[j]
            j -= 1
        }

        arr[j + 1] = key
    }

}


fun main() {
    val arr = arrayOf(2,3,1,4,5,7)
    sort(arr)
    arr.forEach { print(it) }
}

