package ProblemTypes.easy

import java.util.Stack


fun main() {
    println(equalStack(intArrayOf(3, 2, 1, 1, 1), intArrayOf(0), intArrayOf(1, 1, 4, 1)))
    println(equalStack(intArrayOf(1), intArrayOf(1), intArrayOf(1)))
    println(equalStack(intArrayOf(1, 1, 1, 1, 1), intArrayOf(3, 2), intArrayOf(1, 3, 1)))
}


fun equalStack(h1: IntArray, h2: IntArray, h3: IntArray): Int {
    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()
    val stack3 = Stack<Int>()

    var result = 0

    fillStack(stack1,h1)
    fillStack(stack2,h2)
    fillStack(stack3,h3)

    while (!stack1.empty() && !stack2.empty() && !stack3.empty()) {
        val s1value = stack1.peek()
        val s2value = stack2.peek()
        val s3value = stack3.peek()
        if (s1value == s2value && s2value == s3value) {
            result = s1value
            break
        }
        when {
            s1value > s2value && s1value > s3value -> {
                stack1.pop()
            }

            s2value > s1value && s2value > s3value -> {
                stack2.pop()
            }

            s3value > s2value && s3value > s2value -> {
                stack3.pop()
            }
        }
    }
    return result
}

fun fillStack(stack: Stack<Int>, array: IntArray) {
    array.forEach {
        if (!stack.isEmpty()) {
            stack.push(it + (stack.peek() ?: 0))
        } else {
            stack.push(it)
        }
    }
}