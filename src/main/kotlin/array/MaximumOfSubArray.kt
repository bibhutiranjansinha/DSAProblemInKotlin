package com.example.dspractice

fun main(){
    println(findMaximumSumOfSubArray(arrayOf(1,2,3,4)))
    println(findMaximumSumOfSubArray(arrayOf(-1,-2,-3,3,7)))
    println(findMaximumSumOfSubArray(arrayOf(-3,8,-2,4,-5,6)))
}

fun findMaximumSumOfSubArray(array: Array<Int>):Int{
    var maxSum = array[0]
    var maxEnding = array[0]
    for (i in 1..<array.size){
        maxEnding = maxOf(array[i],maxEnding+array[i])
        maxSum = maxOf(maxSum,maxEnding)
    }
    return maxSum
}