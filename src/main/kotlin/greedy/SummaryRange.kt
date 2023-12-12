package greedy


fun main() {
    println(summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)).toString())
}

fun summaryRanges(nums: IntArray): List<String> {
    val result = mutableListOf<String>()
    if (nums.size <= 0) {
        return result
    }
    var startRange = nums[0]
    var endRange = nums[0]
    for (i in 1..nums.size - 1) {
        if (endRange + 1 == nums[i]) {
            endRange++
        } else {
            if (startRange == endRange) {
                result.add("${endRange}")
            } else {
                result.add("$startRange->${endRange}")
            }
            startRange = nums[i]
            endRange = nums[i]
        }
    }

    if (startRange == endRange) {
        result.add("${endRange}")
    } else {
        result.add("$startRange->${endRange}")
    }
    return result
}