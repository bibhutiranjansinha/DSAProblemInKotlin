package com.example.dspractice

import java.util.Arrays

fun abc() {
//    println("isArraySorted:${isArraySorted(arrayOf(1, 3, 5, 6, 7, 9))}")
//
//    println("isArraySorted:${isArraySorted(arrayOf(1, 3, 5, 6, 10, 9))}")
//
//    println("isArraySorted:${isArraySorted(arrayOf(10, 10))}")
//
//    println("isArraySorted:${isArraySorted(arrayOf(100))}")

//    println(
//        "isArraySorted:${
//            Arrays.toString(reverseAnArray(arrayOf(1, 3, 5, 6, 7, 9)))
//        }"
//    )
//
//    println("isArraySorted:${Arrays.toString(reverseAnArray(arrayOf(1, 3, 5, 6, 0, 10, 9)))}")

//    val arrayOfDuplicate = arrayOf(2, 3, 3, 5, 5, 8, 9)
//
//    for (i in 0..removeDuplicatesInSorted(arrayOfDuplicate)) {
//        print("${arrayOfDuplicate[i]} ")
//    }
//    println("")
//    val arrayOfDuplicate1 = arrayOf(2, 3, 3, 5, 5, 8, 9, 10, 10, 11)
//
//    for (i in 0..removeDuplicatesInSorted(arrayOfDuplicate1)) {
//        print("${arrayOfDuplicate1[i]} ")
//    }

//    println(
//        "moveAllZero:${
//            moveAllZeroToTheEnd(
//                arrayOf(
//                    1,
//                    3,
//                    5,
//                    0,
//                    3,
//                    0,
//                    2,
//                    0,
//                    1
//                )
//            ).contentToString()
//        }"
//    )
//    println("moveAllZero:${Arrays.toString(moveAllZeroToTheEnd(arrayOf(1, 0, 0, 0, 0, 0)))}")
//    println("moveAllZero:${moveAllZeroToTheEnd(arrayOf(0, 0, 0, 0, 0, 1)).contentToString()}")

//    println("moveAllZero:${leftRotateArrayByOne(arrayOf(1,2,3,4,5,6,7,8)).contentToString()}")
//
//    println("moveAllZero:${leftRotateArrayByOne(arrayOf(1,0,3,4,5,6,7,0)).contentToString()}")

    println(
        "moveAllZero:${
            leftRotateArrayByGivenPosition(
                arrayOf(1, 2, 3, 4, 5, 6, 7, 8),
                2
            ).contentToString()
        }"
    )

    println(
        "moveAllZero:${
            leftRotateArrayByGivenPosition(
                arrayOf(1, 0, 3, 4, 5, 6, 7, 0),
                2
            ).contentToString()
        }"
    )

}


fun main() {
    printTheLeadersInArray(arrayOf(3,4,6,8,10,3,4))
    printTheLeadersInArray(arrayOf(1,2,3,4,5,6,7,8))
    printTheLeadersInArray(arrayOf(8,7,6,5,4,3,2,1))
}

fun isArraySorted(array: Array<Int>): Boolean {
    var isArraySorted = true
    for (i in 0 until array.size - 1) {
        if (array[i] > array[i + 1]) {
            isArraySorted = false
            break
        }
    }
    return isArraySorted
}

fun reverseAnArray(array: Array<Int>): Array<Int> {
    var startPointer = 0
    var endPointer = array.size - 1
    while (startPointer < endPointer) {
        array[startPointer] = array[startPointer] + array[endPointer]
        array[endPointer] = array[startPointer] - array[endPointer]
        array[startPointer] = array[startPointer] - array[endPointer]
        startPointer++
        endPointer--
    }
    return array
}


fun removeDuplicatesInSorted(array: Array<Int>): Int {
    var lastDistinctElementIndex = 1
    for (i in 1 until array.size) {
        if (array[i] != array[lastDistinctElementIndex - 1]) {
            array[lastDistinctElementIndex] = array[i]
            lastDistinctElementIndex++
        }
    }
    return lastDistinctElementIndex - 1
}

// 1, 3, 5, 0, 3, 0, 2, 0, 1
fun moveAllZeroToTheEnd(array: Array<Int>): Array<Int> {
    var lastZeroItemIndex = 0
    var temp = 0
    for (i in array.indices) {
        if (array[i] != 0) {
            temp = array[i]
            array[i] = array[lastZeroItemIndex]
            array[lastZeroItemIndex] = temp
            lastZeroItemIndex++
        }
    }
    return array
}


fun leftRotateArrayByOne(arrays: Array<Int>): Array<Int> {
    val firstNumber = arrays[0]
    for (i in 0 until arrays.size - 1) {
        arrays[i] = arrays[i + 1]
    }
    arrays[arrays.size - 1] = firstNumber
    return arrays
}


fun leftRotateArrayByGivenPosition(arrays: Array<Int>, position: Int): Array<Int> {
    reverseAnArray(arrays, 0, position - 1)
    reverseAnArray(arrays, position, arrays.size - 1)
    reverseAnArray(arrays, 0, arrays.size - 1)
    return arrays
}


fun reverseAnArray(array: Array<Int>, startPointer: Int, endPointer: Int): Array<Int> {
    var startPointer = startPointer
    var endPointer = endPointer
    while (startPointer < endPointer) {
        array[startPointer] = array[startPointer] + array[endPointer]
        array[endPointer] = array[startPointer] - array[endPointer]
        array[startPointer] = array[startPointer] - array[endPointer]
        startPointer++
        endPointer--
    }
    return array
}


fun printTheLeadersInArray(array: Array<Int>){
    var currentLeader = array[array.size-1]
    print("$currentLeader\t")
    for (i in array.size-2 downTo 1){
        if(array[i]>currentLeader){
            currentLeader=array[i]
            print("$currentLeader\t")
        }
    }
    println("")
}







