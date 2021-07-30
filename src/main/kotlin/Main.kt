import kotlin.random.Random

fun main() {
    val r = go(10)
    r.arrays.forEach {
        print("Size ${it.size} ")
        println("Values: ${it.joinToString()}")
    }
}


fun go(n: Int): ResultObject {
    if (n <= 0) return ResultObject(emptyArray())
    val arrays = mutableMapOf<Int, Array<Int>>()
    for (i in 1..n) {
        val size = Random.nextInt(0, 100 + n)
        if (arrays[size] != null) return go(n)
        val arr = Array(size) { Random.nextInt(0, 100_000) }.apply { if (size % 2 == 0) sort() else sortDescending() }
        arrays[size] = arr
    }
    return ResultObject(arrays.values.toTypedArray())
}

class ResultObject(val arrays: Array<Array<Int>>)
