package stringspractice

fun isValidNumber(s:String):Boolean{
    var digitSeen = false
    var eseen = false
    var dotseen= false
    var countPlusMinus = 0
    s.forEachIndexed { index, c ->
        when{
            c.isDigit()->{
                digitSeen =true
            }
            c == '+'|| c== '-' ->{
                if(countPlusMinus==2){
                    return false
                }
                if (index>0 && (s[index-1] !='e'&& s[index-1] !='E')){
                    return false
                }
                if(index==s.lastIndex){
                    return false
                }
                countPlusMinus++
            }
            c == '.'->{
                if(eseen||dotseen){
                    return false
                }
                if(index ==s.lastIndex && !digitSeen){
                    return false
                }
                dotseen = true
            }

            c == 'e' || c == 'E' ->{
                if(eseen|| !digitSeen || index == s.lastIndex){
                    return false
                }
                eseen = true
            }
            else -> return false
        }
    }
    return true
}

fun main(){
    println(isValidNumber("005047e+6"))

}