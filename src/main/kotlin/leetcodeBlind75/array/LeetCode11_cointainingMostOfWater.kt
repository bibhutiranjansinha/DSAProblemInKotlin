package leetcodeBlind75.array

fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var result = 0
    while (l < r) {
        val currentArea = (r - l) * Math.min(height[l], height[r])
        result = Math.max(result, currentArea)
        if (height[l] > height[r]) {
            r--
        } else {
            l++
        }
    }
    return result
}