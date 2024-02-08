package tries

class TrieNodeNG(var key:Char?,var parent:TrieNodeNG?){
    val children = HashMap<Char,TrieNodeNG?>()
    var isTerminating =false
}

class TrieNG{
    val root = TrieNodeNG(null,null)

    fun insert(string: String){
        var current = root
        string.forEach {element->
            if(current.children[element]==null){
                current.children[element]= TrieNodeNG(element,current)
            }
            current =current.children[element]!!
        }
        current.isTerminating=true
    }

    fun contains(string: String):Boolean{
        var current = root
        string.forEach {element->
            if(current.children[element]==null) return false
            current =current.children[element]!!
        }
        return current.isTerminating
    }

    fun remove(string: String){
        var current = root
        string.forEach {element->
            if(current.children[element]==null) return
            current =current.children[element]!!
        }
        if(!current.isTerminating) return

        current.isTerminating =false

        while(current.children.isEmpty() && !current.isTerminating){
            current.parent?.let {
                current.key?.let {key->
                    it.children[key] = null
                }
                current = it
            }
        }
    }

    fun printPrefixMatching(prefix:String):List<String>{
        var current =root
        prefix.forEach {
            current.children[it]?.let {
                current = it
            }?:return emptyList()
        }
        return collections(prefix,current)
    }

    private fun collections(prefix: String, node:TrieNodeNG?):List<String>{
        val result = mutableListOf<String>()
        if(node?.isTerminating==true){
            result.add(prefix)
        }
        node?.children?.forEach{key,node->
            result.addAll(collections(prefix+key,node))
        }
        return result
    }
}

fun main (){
    //val trie = TrieNG()

   /* trie.insert("cute")
    trie.insert("cutepi")
    if (trie.contains("cute")) {
        println("cute is in the trie")
    }
    if (trie.contains("cutepi")) {
        println("cutepi is in the trie")
    }
    trie.remove("cutepi")
    if (trie.contains("cute")) {
        println("cute is in the trie")
    }*/

    val trie = TrieNG().apply {
        insert("car")
        insert("card")
        insert("care")
        insert("cared")
        insert("cars")
        insert("carbs")
        insert("carapace")
        insert("cargo")
    }
    println("\nCollections starting with \"car\"")
    val prefixedWithCar = trie.printPrefixMatching("car")
    println(prefixedWithCar)
    println("\nCollections starting with \"care\"")
    val prefixedWithCare = trie.printPrefixMatching("care")
    println(prefixedWithCare)
}