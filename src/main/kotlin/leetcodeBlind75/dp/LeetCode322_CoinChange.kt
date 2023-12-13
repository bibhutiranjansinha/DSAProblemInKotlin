package leetcodeBlind75.dp


lateinit var dp: Array<IntArray>

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
}


fun coinChange(coins: IntArray, amount: Int): Int {
    dp = Array(coins.size) { IntArray(amount + 1) { -1 } }
    return coinChangeR(coins, coins.size - 1, amount)
}

fun coinChangeR(coins: IntArray, index: Int, amount: Int): Int {
    if (index == 0) {
        return if (amount % coins[0] == 0) amount / coins[0]
        else Int.MAX_VALUE
    }

    if (dp[index][amount] != -1) {
        return dp[index][amount]
    }
    val notTake = 0 + coinChangeR(coins, index - 1, amount)
    val take = if (coins[index] <= amount) {
        1 + coinChangeR(coins, index, amount - coins[index])
    } else {
        Int.MAX_VALUE
    }
    dp[index][amount] = Math.min(notTake, take)
    return dp[index][amount]
}
