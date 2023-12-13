package leetcodeBlind75.binary

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */


fun getSum(a: Int, b: Int): Int {
    var aTemp = a
    var bTemp = b
    while (bTemp != 0) {
        val tmp = (aTemp and bTemp) shl 1
        aTemp = aTemp xor bTemp
        bTemp = tmp
    }
    return aTemp
}