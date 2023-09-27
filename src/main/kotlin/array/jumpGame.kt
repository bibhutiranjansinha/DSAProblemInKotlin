package array

import kotlin.math.max

fun canJump(array:IntArray):Boolean{
    var rechable = 0
    array.forEachIndexed { index,value->
       if(rechable<index)
           return false
        rechable = max(rechable,index+value)
    }
    return true
}

