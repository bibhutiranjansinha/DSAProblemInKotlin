package queuepractice

fun main() {
    val queue = ArrayListQueue<String>().apply {
        enqueue("Vincent")
        enqueue("Remel")
        enqueue("Lukiih")
        enqueue("Allison")
    }
    println(queue)
    println("===== boardgame =======")
    println("Next Player: ${queue.nextPlayer()}")
    println(queue)
    println("Next Player: ${queue.nextPlayer()}")
    println(queue)
    println("Next Player: ${queue.nextPlayer()}")
    println(queue)
    println("Next Player: ${queue.nextPlayer()}")
    println(queue)

}

fun <T> ArrayListQueue<T>.nextPlayer(): T? {
    val nextPlayer = this.dequeue()
    if (nextPlayer != null) {
        this.enqueue(nextPlayer)
    }
    return nextPlayer
}