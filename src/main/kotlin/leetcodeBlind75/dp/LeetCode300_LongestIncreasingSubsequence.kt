package leetcodeBlind75.dp

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }
    for (i in nums.size-1 downTo 0){
        for( j in i+1..<nums.size){
            if(nums[i]<nums[j]){
                dp[i] = Math.max(dp[i],1+dp[j])
            }
        }
    }
    return dp.maxOrNull() ?: 0
}

fun main(){
   print(lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}