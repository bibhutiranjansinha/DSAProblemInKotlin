package array

fun printFirstNegativeInEveryWindowK(array: IntArray, windowSize:Int){
    var i = 0
    var j = 0
    val queue = mutableListOf<Int>()
    while (j<array.size){
        if(array[j]<0){
            queue.add(array[j])
        }
        if(j-i+1<windowSize){
            j++
        }else if(j-i+1==windowSize){
            if(queue.isEmpty()){
                println(0)
            }else{
                val firstNegative= queue.first()
                println(firstNegative)
                if(array[i]==firstNegative){
                    queue.removeAt(0)
                }
            }
            i++
            j++
        }
    }
}

fun main(){
    printFirstNegativeInEveryWindowK(intArrayOf(12,-1,-7,8,-15,30,16,28),3)
}