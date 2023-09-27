package stringspractice

fun isGivenStringIsSubSequenceOfFirst(s1:String,s2:String):Boolean{
    var s2Index = 0
    s1.forEach {
        if(it==s2[s2Index] && s2Index<s2.length){
            s2Index++
        }
    }

    return s2Index == s2.length
}

fun main(){
    println(isGivenStringIsSubSequenceOfFirst("ABCDEF","AFD"))
}