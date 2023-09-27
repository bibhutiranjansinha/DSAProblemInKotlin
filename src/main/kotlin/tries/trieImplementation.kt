package tries

import treepractice.TreeNode

class TrieNode<Key>(var key:Key?, var parent:TrieNode<Key>?){
    val children = HashMap<Key, TrieNode<Key>>()
    var isTerminating =false
}

class Trie<Key> {
    private val root = TrieNode<Key>(key = null, parent = null)

    fun insert(list:List<Key>){
        var current =root
        list.forEach {element->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isTerminating =true
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

}

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}
fun Trie<Char>.contains(string: String): Boolean {
    return contains(string.toList())
}

fun main (){
    val trie = Trie<Char>()
   /* trie.insert("cute".toList())
    if (trie.contains("cute".toList())) {
        println("cute is in the trie")
    }*/

    trie.insert("cute")
    trie.insert("cutepi")
    if (trie.contains("cute")) {
        println("cute is in the trie")
    }
    if (trie.contains("cutepi")) {
        println("cutepi is in the trie")
    }

    if (trie.contains("cut")) {
        println("cutepi is in the trie")
    }
}