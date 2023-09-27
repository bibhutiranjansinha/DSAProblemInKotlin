package array

fun subArraysWithAtKDistinct(nums: IntArray, k: Int): Int {
    var count = 0
    val validatorMap = mutableMapOf<Int,Int>()
    var leftPointer = 0
    nums.forEach { value ->
        while(validatorMap.size>=k && leftPointer<nums.size){
            validatorMap[leftPointer]?.let {
                if (it > 1) {
                    validatorMap[leftPointer] = it - 1
                } else {
                    validatorMap.remove(leftPointer)
                }
            }
            leftPointer++
        }
        validatorMap[value]?.let {
            validatorMap[value] = it +1
        }?:validatorMap.put(value,1)
        count += validatorMap.values.sum()
    }
    return count
}

fun main(){
   print(subArraysWithAtKDistinct(intArrayOf(1,2,1,3,4),3))
}

