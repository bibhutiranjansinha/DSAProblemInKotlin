package array

fun majorityElement(nums: IntArray): Int {
    var result = 0
    var count=1
    nums.forEachIndexed { index, i ->
        if(nums[result]==i){
            count++
        }else{
            count--
        }
        if(count<=0){
            count=1
            result=index
        }
    }
    count=0
    nums.forEach {
        if(it==nums[result]){
            count++
        }
    }
    return if (count>(nums.size/2)) nums[result] else 0
}