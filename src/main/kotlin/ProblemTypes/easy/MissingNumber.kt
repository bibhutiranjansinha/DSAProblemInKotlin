package ProblemTypes.easy

fun findMissingNumber(originalArray: IntArray, otherArray: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    originalArray.forEach { number ->
        map[number]?.let {
            map[number] = it + 1
        } ?: run {
            map[number] = 1
        }
    }
    otherArray.forEach { number ->
        map[number]?.let {
            map[number] = it - 1
        }
        if (map[number] == 0) {
            map.remove(number)
        }
    }

  /*  //return  map.toList().sortedBy { (_, value) -> value}.toMap().keys.toIntArray()
    map.flatMap {

    }*/
    return map.isEmpty()
}

fun main() {
    println(findMissingNumber(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 4, 5)))
    println(findMissingNumber(intArrayOf(2, 3, 4, 1, 5, 1, 1, 1), intArrayOf(1, 1, 2, 4, 5)))
}