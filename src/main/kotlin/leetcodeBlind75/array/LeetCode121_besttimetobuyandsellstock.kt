package leetcodeBlind75.array

fun main(){
    println(maxProfit(intArrayOf(1,2,4,2,5,7,2,4,9,0,9)))
}

fun maxProfit(prices: IntArray): Int {
    var l = 0
    var r = 1
    var max = 0
    while(r<prices.size){
        if(prices[l]>=prices[r]){
            l=r
        }else{
            max = Math.max(max,prices[r]-prices[l])
        }
        r++
    }
    return  max
}