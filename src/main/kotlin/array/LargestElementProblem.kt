package com.example.dspractice

fun main() {
    println(greatestNumber(arrayOf(3, 4, 20, 9, 1)))
    println(greatestNumber(arrayOf(5, 88, 20, 9, 1)))
    println(greatestNumber(arrayOf(3, 4, 2, 9, 1)))
    println(greatestNumber(arrayOf(90, 4, 20, 9, 1)))
    println(greatestNumber(arrayOf(64, 4, 20, 9, 65)))
    println(greatestNumber(arrayOf(10, 10, 10)))

    println(secondLargestBetter(arrayOf(3, 4, 20, 9, 1)))
    println(secondLargestBetter(arrayOf(5, 88, 20, 9, 1)))
    println(secondLargestBetter(arrayOf(3, 4, 2, 9, 1)))
    println(secondLargestBetter(arrayOf(90, 4, 20, 9, 1)))
    println(secondLargestBetter(arrayOf(64, 4, 20, 9, 65)))
    println(secondLargestBetter(arrayOf(10, 10, 10)))
}


/**
 * Find greatest number in the Array
 */
fun greatestNumber(array: Array<Int>): Int {
    var gretest = array[0]
    for (i in 1 until array.size) {
        if (array[i] > gretest) {
            gretest = array[i]
        }
    }
    return gretest
}


/**
 * Find Second largest value with two iteration
 */
fun secondLargest(array: Array<Int>): Int {
    val largest = greatestNumber(array)
    var secondLargest = -1
    for (i in 0 until array.size) {
        if (array[i] != largest) {
            if (secondLargest == -1) {
                secondLargest = array[i]
            } else if (array[i] > secondLargest) {
                secondLargest = array[i]
            }
        }
    }

    return secondLargest
}


/**
 * Find second largest value with one iteration
 */
fun secondLargestBetter(array: Array<Int>): Int {
    var gretest = array[0]
    var secondGretest = -1
    for (i in 1 until array.size) {
        if (array[i] > gretest) {
            secondGretest = gretest
            gretest = array[i]
        } else if (array[i] > secondGretest && array[i] != gretest) {
            secondGretest = array[i]
        }
    }
    return secondGretest
}