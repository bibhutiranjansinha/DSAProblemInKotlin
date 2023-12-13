package leetcodeBlind75.array

fun main(){
    productExceptSelf(intArrayOf(1,2,3,4)).forEach {
        println(it)
    }
}

fun productExceptSelf(nums: IntArray): IntArray {
    val prefix = IntArray(nums.size)
    val postFix = IntArray(nums.size)
    val result = IntArray(nums.size)
    prefix[0] = nums[0]
    postFix[nums.size-1] = nums[nums.size-1]
    for(i in 1 until nums.size){
        prefix[i] =  prefix[i-1] * nums[i]
    }
    for(i in nums.size-2 downTo  0){
        postFix[i] =  postFix[i+1] * nums[i]
    }
    for(i in 0 until nums.size){
        if(i==0){
            result[i] = postFix[i+1]
        }
        else if(i==nums.size-1){
            result[i] = prefix[i-1]
        }
        else{
            result[i] = prefix[i-1] * postFix[i+1]
        }
    }

    return result
}