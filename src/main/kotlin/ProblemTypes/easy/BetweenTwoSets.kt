package ProblemTypes.easy


fun main() {
    println(findMultiplesAndFactors(intArrayOf(2, 4), intArrayOf(16, 32, 96)))
}

fun findMultiplesAndFactors(array1: IntArray, array2: IntArray): Int {
    var result = 0
    var lcm = array1[0]
    array1.forEach {
        lcm = getLCM(lcm, it)
    }

    var gcd = array2[0]
    array2.forEach {
        gcd = getGCD(gcd, it)
    }

    var multiple = 0
    while (multiple <= gcd) {
        multiple += lcm
        if (gcd % multiple == 0) {
            result++
        }
    }

    return result

}


fun getLCM(n1: Int, n2: Int): Int {
    if (n2 == 0 && n1 == 0) {
        return 0
    }
    val gcd = getGCD(n1, n2)
    return Math.abs(n1 * n2) / gcd
}

fun getGCD(n1: Int, n2: Int): Int {
    if (n2 == 0) {
        return n1
    }
    return getGCD(n2, n1 % n2)
}