package stringspractice

fun isValidAnagram(s: String, t: String): Boolean {
    val smap = mutableMapOf<Char, Int>()
    val tmap = mutableMapOf<Char, Int>()
    s.forEach { char ->
        smap[char] = smap[char]?.let { count ->
            count + 1
        } ?: 1
    }
    t.forEach { char ->
        tmap[char] = tmap[char]?.let { count ->
            count + 1
        } ?: 1
    }

    smap.forEach{
        if(tmap[it.key]!=it.value){
            return false
        }
    }
    return true
}

fun isValidAnagramOptimised(s: String, t: String): Boolean{
    if(s.length!=t.length){
        return false
    }

    val intArray = IntArray(256)
    for (i in s.indices){
        intArray[s[i].code]++
        intArray[t[i].code]--
    }
    intArray.forEach {
        if(it!=0){
            return false
        }
    }
    return true
}

fun main(){
    println(isValidAnagramOptimised("anagram","nagawram"))
}