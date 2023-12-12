package greedy

import kotlin.math.max

fun main() {

}


/**
 * Jump game 1
 */
fun canJump(array: IntArray): Boolean {
    var goal = array.size - 1
    for (i in array.size - 2 downTo 0) {
        if (i + array[i] >= goal) {
            goal = i
        }
    }
    return goal == 0
}


/**
 * Jump Game 2
 */
fun jump(nums: IntArray): Int {
    var result = 0
    var l = 0
    var r = 0
    while (r<nums.size-1){
        var farthest = 0
        for (i in l..r){
            farthest = Math.max(farthest,nums[i]+i)
        }
        l = r +1
        r = farthest
        result++
    }
    return result
}
