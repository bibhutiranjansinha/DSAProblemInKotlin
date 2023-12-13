package leetcodeBlind75.array

import com.example.dspractice.printTheLeadersInArray
import java.util.Arrays

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    Arrays.sort(nums)
    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            val threeSum = nums[i] + nums[l] + nums[r]
            if (threeSum > 0) {
                r--
            } else if (threeSum < 0) {
                l++
            } else {
                result.add(listOf(nums[i], nums[l], nums[r]))
                l++
                while (nums[l - 1] == nums[l] && l < r) {
                    l++
                }
            }
        }
    }
    return result
}


/**
 * Leetcode 167, Two Sum II
 */

fun twoSumForSortedArray(numbers: IntArray, target: Int): IntArray {
    var l = 0
    var r = numbers.size - 1
    while (l < r) {
        val twoSum = numbers[l] + numbers[r]
        if (twoSum > target) {
            r--
        } else if (twoSum < target) {
            l++
        } else {
            return intArrayOf(l + 1, r + 1)
        }
    }
    return intArrayOf()
}