package com.example.dspractice

import java.util.Arrays

fun main() {
    printFrequencyInSortedArray(arrayOf(3, 4, 5, 5, 6, 6, 6, 7, 9, 9, 10))
}

fun printFrequencyInSortedArray(array: Array<Int>) {
    println("Finding frequency if array:${Arrays.toString(array)}")
    var frequency = 1
    var valueInArray = array[0]
    for (i in 1 until array.size) {
        if (array[i] == valueInArray) {
            frequency++
        } else {
            println("Frequency of $valueInArray is $frequency")
            frequency = 1
            valueInArray = array[i]
        }
    }
    println("Frequency of $valueInArray is $frequency")
}