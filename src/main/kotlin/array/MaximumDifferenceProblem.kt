package com.example.dspractice

import kotlin.math.min

fun main() {
    println(
        "Max difference in [3,4, 10,4,8, 5] is ${
            findMaximumDifference(
                arrayOf(
                    3,
                    4,
                    10,
                    4,
                    8,
                    5
                )
            )
        }"
    )
    println(
        "Max difference in [10,9,8,7,6,5] is ${
            findMaximumDifference(
                arrayOf(
                    10,
                    9,
                    8,
                    7,
                    6,
                    5
                )
            )
        }"
    )

    println(
        "Max difference in [5,6,7,8,9,10] is ${
            findMaximumDifference(
                arrayOf(
                    5,
                    6,
                    7,
                    8,
                    9,
                    10
                )
            )
        }"
    )

    print(
        "Max difference in [10,10,10] is ${
            findMaximumDifference(
                arrayOf(
                    10,
                    10,
                    10
                )
            )
        }"
    )
}

// 3,4 10,4,8 5
fun findMaximumDifference(array: Array<Int>): Int {
    var minValue = array[0]
    var result = array[1] - array[0]
    for (i in 1 until array.size) {
        result = Math.max(result, array[i] - minValue)
        minValue = Math.min(minValue, array[i])
    }

    return result
}