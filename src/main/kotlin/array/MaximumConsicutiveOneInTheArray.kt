package com.example.dspractice

fun main() {
    println("max count of [1,0,1,0,1,1,1,0,1,1] is ${findMaximumConsecutiveOneInArray(arrayOf(1,0,1,0,1,1,1,0,1,1))}")
    println("max count of [1,1,1,1] is ${findMaximumConsecutiveOneInArray(arrayOf(1,1,1,1))}")
    println("max count of [0,0,0,0] is ${findMaximumConsecutiveOneInArray(arrayOf(0,0,0,0))}")
    println("max count of [1,1,1,0,1,1,1,1] is ${findMaximumConsecutiveOneInArray(arrayOf(1,1,1,0,1,1,1,1))}")
}

fun findMaximumConsecutiveOneInArray(array: Array<Int>): Int {
    var maxCount = 0
    var tempCount = 0
    for (i in array.indices) {
        if(array[i]==1){
            tempCount++
        }else{
            maxCount = maxOf(maxCount,tempCount)
            tempCount=0
        }
    }
    return  maxOf(maxCount,tempCount)
}