package leetcodeBlind75.binary

fun countBits(n: Int): IntArray {
    val result = IntArray(n+1)
    for (i in 0..n){
        result[i] = i.countOneBits()
    }
    return result
}