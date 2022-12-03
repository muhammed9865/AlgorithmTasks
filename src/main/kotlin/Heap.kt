import kotlin.math.floor

class Heap<in T : Comparable<T>>(
    private val list: List<T>,
) {

    private val array = list.toMutableList()
    private val size = array.size

    init {
        buildMaxHeap()
    }

    private fun left(node: Int): Int {
        return if (node != 0) node * 2 else 1
    }

    private fun right(node: Int) = if (node != 0) node * 2 + 1 else 2

    private fun maxHeapify(node: Int) {
        var largest: Int
        val left = left(node)
        val right = right(node)

        if (left < size && array[left] > array[node])
            largest = left
        else
            largest = node

        if (right < size && array[largest] < array[right]) {
            largest = right
        }

        if (largest != node) {
            swap(node, largest)
            maxHeapify(largest)
        }
    }

    private fun buildMaxHeap() {
        for (i in lastParent() downTo 0) {
            maxHeapify(i)
        }
    }

    private fun parent(node: Int) = floor(node / 2.0).toInt()

    fun print(node: Int = 0) {
        if (parent(node) in lastParent()..lastParent() + 1) {
            printNode(node)
            return
        } else {
            val left = left(node)
            val right = right(node)
            print(left)
            print(right)

          //  printNode(node)
        }
    }

    private fun printNode(node: Int) {
        val p = array[node]
        val l = left(node)
        val r = right(node)
        println("""
            p:${p}
            l:${array[l]}
            r:${array[r]}
        """.trimIndent())
    }


    private fun lastParent() = floor(size / 2.0).toInt()


    private fun swap(from: Int, to: Int) {
        val temp = array[to]
        array[to] = array[from]
        array[from] = temp
    }

}


fun main() {
    val heap = Heap<Int>(
        listOf(1, 4, 2, 0, 1, 10)
    )

    heap.print()


}