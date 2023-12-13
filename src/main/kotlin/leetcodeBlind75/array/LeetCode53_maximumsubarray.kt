package leetcodeBlind75.array


fun main() {
    //println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArray(intArrayOf(-1)))
}

fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    var maxSum = 0
    for (i in 0 until nums.size) {
        sum += nums[i]
        if (sum < 0)
            sum = 0
        maxSum = Math.max(maxSum, sum)
    }
    if (maxSum == 0) {
        maxSum = nums[0]
    }
    return maxSum
}
