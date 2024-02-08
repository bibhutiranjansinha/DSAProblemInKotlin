package leetcodeBlind75.dp



fun main(){
  println(rob(intArrayOf(2,7,9,3,1)))
}
fun rob(nums: IntArray): Int {
    if(nums.isNotEmpty()){
        var p1=0
        var p2=1
        var sum1=0
        var sum2 =0
        while(p1<=nums.size-1 && p2<=nums.size-1){
            sum1 += nums[p1]
            sum2 += nums[p2]
            p1+=2
            p2+=2
        }
        if(p1<=nums.size-1){
            sum1 += nums[p1]
        }
        if(p2<=nums.size-1){
            sum2 += nums[p2]
        }

        return Math.max(sum1,sum2)
    }else{
        return -1
    }
}