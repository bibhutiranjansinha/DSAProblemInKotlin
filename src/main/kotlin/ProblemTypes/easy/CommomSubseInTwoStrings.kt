package ProblemTypes.easy

fun twoStrings(s1: String, s2: String): Boolean {
    val set1 = mutableSetOf<Char>()
    val set2 = mutableSetOf<Char>()
    s1.forEach {
        set1.add(it)
    }
    s2.forEach {
        set2.add(it)
    }
    set1.retainAll(set2)
    return set1.isNotEmpty()
}

fun main(){
    println(twoStrings("abc","def"))
    println(twoStrings("barbell","trapper"))
}