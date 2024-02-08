package leetcodeBlind75.dp


lateinit var dp: Array<IntArray>

fun main() {
    println(coinChange2(intArrayOf(1, 3, 4,11), 7))
}


/**
 * Improved
 */
fun coinChange2(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (i in 1..amount) {
        coins.forEach { coin ->
            if (i-coin >= 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin])
            }
        }
    }

    return if (dp[amount] < amount + 1) {
        dp[amount]
    } else {
        -1
    }
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



