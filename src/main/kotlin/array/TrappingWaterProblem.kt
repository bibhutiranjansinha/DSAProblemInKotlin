package com.example.dspractice

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(
        "max water trapped for [3, 2, 1,0, 5] is ${
            getMaximumQuantityOfWaterTrapped(
                arrayOf(
                    0,
                    8,
                    0,
                    0,
                    5,
                    0,
                    0,
                    10,
                    0,
                    0,
                    1,
                    1,
                    0,
                    3
                )
            )
        }"
    )
    println("max water trapped for [5,0,1,2,6,1] is ${getMaximumQuantityOfWaterTrapped(arrayOf(5, 0, 1, 2, 6, 1))}")
    println("max water trapped for [1,2,3,4,5] is ${getMaximumQuantityOfWaterTrapped(arrayOf(1, 2, 3, 4, 5))}")
    println("max water trapped for [5,4,3,2,1] is ${getMaximumQuantityOfWaterTrapped(arrayOf(5, 4, 3, 2, 1))}")
}


fun getMaximumQuantityOfWaterTrapped(array: Array<Int>): Int {

    if(array.isEmpty()){
        return 0
    }
    val lmax = IntArray(array.size)
    val rmax = IntArray(array.size)
    var result = 0
    lmax[0] = array[0]
    for (i in 1..<array.size){
        lmax[i]= max(array[i],lmax[i-1])
    }
    rmax[array.size-1] = array[array.size-1]
    for (i in array.size-2 downTo 0){
        rmax[i]= max(array[i],rmax[i+1])
    }

    for (i in array.indices){
        result = result + min(lmax[i],rmax[i])-array[i]
    }


    return result
}


fun getMaximumWaterWithTwoPointer(height: IntArray):Int{
    var l = 0
    var r = height.size-1
    var result = 0
    var currentArea = 0
    while (l<r){
        currentArea =(r-l)*Math.min(height[l],height[r])
        result = Math.max(result,currentArea)
        if(height[l]>height[r]){
            r--
        }else{
            l++
        }
    }
    return result
}