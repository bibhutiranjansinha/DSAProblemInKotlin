package greedy

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    intervals.plus(newInterval).sortedBy { it[0] }.forEach {
        if(result.isEmpty()){
            result.add(it)
        }
        else if(result.last()[1]>=it[0]){
            result.last()[1] = Math.max(result.last()[1],it[1])
        }else{
            result.add(it)
        }
    }
    return result.toTypedArray()
}