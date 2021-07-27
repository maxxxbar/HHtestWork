import kotlin.random.Random

fun main() {
    val r = go(10)
    r.arrays.forEach {
        print("Size ${it.size} ")
        println("Values: ${it.joinToString()}")
    }
}

fun go(n: Int): Result {
    if (n <= 0) return Result(emptyArray())
    val arrays = mutableMapOf<Int, Array<Int>>()
    for (i in 1..n) {
        val size = Random.nextInt(0, 100)
        val arr = Array(size) { Random.nextInt(0, 10_000) }
        arrays[size] = arr
    }
    val even = arrays.filter { it.key % 2 == 0 }.values.map { it.sortedArray() }.toTypedArray()
    val notEven = arrays.filter { it.key % 2 != 0 }.values.map { it.sortedArrayDescending() }.toTypedArray()
    return Result(arrayOf(*even, *notEven))
}

class Result(val arrays: Array<Array<Int>>)
