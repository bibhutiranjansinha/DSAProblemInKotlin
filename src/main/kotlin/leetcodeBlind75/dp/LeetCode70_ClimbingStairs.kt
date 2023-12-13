package leetcodeBlind75.dp

fun main() {
    println(  climbStairs(5))
}

fun climbStairs(n: Int): Int {
    var a = 1
    var b = 1
    var number=n
    while (number > 0) {
        val temp = b
        b = a + b
        a = temp
        number--
    }
    return a
}