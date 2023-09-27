package stringspractice

import kotlin.math.max

fun lengthOfLongestSubString(s:String):Int{
    var l = 0
    var result = 0
    val set = mutableSetOf<Char>()
    s.forEachIndexed { index, c ->
       while(c in set){
           set.remove(s[l])
           l++
       }
        set.add(c)
        result = max(result,index-l+1)
    }
    return result
}

fun main(){
    println(lengthOfLongestSubString("abcabcbb"))
}

