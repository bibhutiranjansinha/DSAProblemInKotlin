package ProblemTypes.medium

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String,MutableList<String>>()
    for (str in strs){
        val fString = getFrequencyString(str)
        if(map.containsKey(fString)){
            map[fString]?.add(str)
        }else{
            map[fString] = mutableListOf(str)
        }
    }
    return map.values.toList()
}

fun getFrequencyString(str: String): String {
    val freq = Array(26) { 0 }
    for (c in str) {
        freq[c.code - 'a'.code]++
    }
    return freq.joinToString("")
}

fun main() {
    println(getFrequencyString("aabc"))
    println(getFrequencyString("aabc"))
}