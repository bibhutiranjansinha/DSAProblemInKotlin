package leetcodeBlind75.array


fun main(){
    twoSum(intArrayOf(-3,4,3,90),0).forEach { println(it) }
}
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    val array= IntArray(2)
    for(i in 0 until nums.size){
        val otherTarget = target-nums[i]
        if(map.containsKey(otherTarget)){
            array[1] = i
            array[0] =  map.get(otherTarget)?:0
            return array
        }else{
            map[nums[i]]= i
        }
    }
    return intArrayOf()
}