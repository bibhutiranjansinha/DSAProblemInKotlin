package com.example.dspractice

fun main(){
    println("maximum profit in [2, 3, 4, 8, 1, 2, 10] is : ${getMaximumProfit(arrayOf(2, 3, 4, 8, 1, 2, 10))}")

    println("maximum profit in [10,9,8,7,5,4] is : ${getMaximumProfit(arrayOf(10,9,8,7,5,4))}")

    println("maximum profit in [1,2,3,4,5,6,7,8,9,10] is : ${getMaximumProfit(arrayOf(1,2,3,4,5,6,7,8,9,10))}")
}


fun getMaximumProfit(array: Array<Int>):Int{
    var maxProfit = 0
    for(i in 1 until array.size){
        if(array[i]>array[i-1]){
            maxProfit+= array[i]-array[i-1]
        }
    }
    return maxProfit
}