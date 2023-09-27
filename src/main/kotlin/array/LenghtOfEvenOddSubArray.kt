package com.example.dspractice

fun main(){

}

fun findMaxLenghtOfEvenOddSubArray(array: Array<Int>):Int{
    var length = 1
    var tempLenght = 1
    var wasEven = array[0]%2 == 0
    for (i in 1 until array.size){
        if(wasEven && array[i]%2 !==0){
            tempLenght++
            wasEven = false
        }
        else if(!wasEven && array[i]%2==0){
            tempLenght++
            wasEven = true
        }
    }
    return length
}