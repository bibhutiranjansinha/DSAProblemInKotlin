package array

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    var fsp = 0
    var ssp=0
    var tsp=0
    while(fsp<s1.length || ssp<s2.length){
        while(fsp<s1.length && s3[tsp]==s1[fsp]){
            fsp++
            tsp++
        }
        while(ssp<s2.length && s3[tsp]==s2[ssp]){
            ssp++
            tsp++
        }
    }
    if(tsp==s3.length){
        return true
    }else{
        return false
    }
}


fun main(){
    /* val bst = BinarySearchTree<Int>()
     (0..4).forEach {
         bst.insert(it)
     }
     println(bst)*/


    print(isInterleave("aabcc","dbbca","aadbbcbcac"))
}