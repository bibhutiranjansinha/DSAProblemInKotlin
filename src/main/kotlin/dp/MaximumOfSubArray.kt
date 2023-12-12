package dp

import array.subArraysWithKDistinct
import kotlin.math.max

fun main() {
    print(maxProduct(intArrayOf(-2)))
}


fun maxProduct(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    var prefix = 1
    var sufix = 1
    nums.forEachIndexed { index, item ->
        if (prefix == 0) {
            prefix = 1
        }
        if (sufix == 0) {
            sufix = 1
        }
        prefix *= item
        sufix *= nums[nums.size - 1 - index]
        result = Math.max(result, Math.max(prefix, sufix))
    }

    return result
}