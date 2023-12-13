package leetcodeBlind75.binary


fun main(){
    println(hammingWeight(0))
}
fun hammingWeight(n:Int):Int {
    var result = 0
    var number = n
    while (number!=0){
        result += number%2
        number = number shr 1
    }
    return result
}