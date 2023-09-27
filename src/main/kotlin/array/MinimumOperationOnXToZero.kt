package array

/**
 * [Minimum Operations to Reduce X to Zero]
 * You are given an integer array nums and an integer x. In one operation,
 * you can either remove the leftmost or the rightmost element from the array
 * nums and subtract its value from x. Note that this modifies the array for future operations.
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise,
 * return -1.
 */

fun main(){
    print(minOperations(intArrayOf(5,6,7,8,9),11))
}

fun minOperations(nums: IntArray, x: Int): Int {
    var firstPointer = 0
    var secondPointer = nums.size - 1
    var count = 0
    var num = x
    while(firstPointer<secondPointer && num>0){
        if(nums[firstPointer]<=num){
            num -= nums[firstPointer]
            firstPointer++
            count++
        }else if(nums[secondPointer]<=num){
            num -= nums[secondPointer]
            secondPointer--
            count++
        }else{
            break
        }
    }
    if(count==0){
        count = -1
    }
    return count
}