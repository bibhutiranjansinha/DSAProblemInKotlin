package leetcodeBlind75.array

fun main() {
    //println(findMin(intArrayOf(4,5,6,7,0,1,2)))
    //println(findMin(intArrayOf(2, 1)))
    println(search(intArrayOf( 4,5,6,7,0,1,2),5))
}

fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    var min = nums[0]
    while (l <= r) {
        if (nums[l] < nums[r]) {
            min = Math.min(min, nums[l])
            break
        }
        val n = (l + r) / 2
        min = Math.min(min, nums[n])
        if (nums[l] <= nums[n]) {
            l = n + 1
        } else {
            r = n - 1
        }
    }

    return min
}


//Leetcode 22 Search in roated sorted array
fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    var result = -1
    while (l <= r) {
        if (nums[l] == target) {
            result = l
            break
        }
        if (nums[r] == target) {
            result = r
            break
        }
        val n = (l + r) / 2
        if (nums[n] == target) {
            result = n
            break
        }
        if (nums[l] <= nums[n] && target <= nums[n]) {
            l = n + 1
        } else {
            r = n - 1
        }
    }

    return result
}