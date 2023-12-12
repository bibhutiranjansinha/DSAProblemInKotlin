package dp


fun main() {

    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
}

lateinit var resultArray: Array<IntArray>

fun lengthOfLIS(nums: IntArray): Int {
    resultArray = Array(nums.size) { IntArray(nums.size + 1) { -1 } }
    return lengthOfLIS(nums, 0, -1)
}

fun lengthOfLIS(nums: IntArray, currentIndex: Int, lastIndex: Int): Int {
    if (currentIndex == nums.size) {
        return 0
    }

    if (resultArray[currentIndex][lastIndex + 1]!=-1){
        return resultArray[currentIndex][lastIndex + 1]
    }

    var len = lengthOfLIS(nums, currentIndex + 1, lastIndex)

    if (lastIndex == -1 || nums[currentIndex] > nums[lastIndex])
        len = Math.max(len, (1 + lengthOfLIS(nums, currentIndex + 1, currentIndex)))

    resultArray[currentIndex][lastIndex + 1] = len
    return len
}