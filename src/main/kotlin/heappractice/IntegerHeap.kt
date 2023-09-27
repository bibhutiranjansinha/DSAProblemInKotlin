package heappractice

import java.util.*
import kotlin.collections.ArrayList

class IntegerHeap{
    var heapData= ArrayList<Int>()
        private set

    private fun leftChildIndex(index: Int) = (2 * index) + 1
    private fun rightChildIndex(index: Int) = (2 * index) + 2
    private fun parentIndex(index: Int) = (index - 1) / 2


    fun insert(item:Int){
        heapData.add(item)
        siftUp(heapData.size-1)
    }


    fun remove():Int?{
        // checking if heapData is empty then return null
        if(heapData.isEmpty()){
            return null
        }
        Collections.swap(heapData, 0, heapData.size-1)
        val dataToReturn = heapData.removeAt(heapData.size-1)
        siftDown(0)
        return dataToReturn
    }

    fun removeAt(index:Int):Int?{
        if(index>heapData.size-1){
            return null
        }
        if(index==heapData.size-1){
            return heapData.removeAt(heapData.size-1)
        }else{
            Collections.swap(heapData, index, heapData.size-1)
            val dataToReturn = heapData.removeAt(heapData.size-1)
            siftDown(index)
            siftUp(index)
            return dataToReturn
        }
    }

    private fun siftUp(index: Int) {
        var childIndex = index
        var parentIndex = parentIndex(childIndex)
        while(childIndex>0 && heapData[childIndex]>parentIndex){
            Collections.swap(heapData,childIndex,parentIndex)
            childIndex =parentIndex
            parentIndex = parentIndex(childIndex)
        }
    }

    private fun siftDown(index: Int) {
        var parentIndex = index
        while(true){
            val leftChildIndex = leftChildIndex(parentIndex)
            val rightChildIndex = rightChildIndex(parentIndex)
            var candidateIndex = parentIndex
            //checking if left child is right candidate
            if(leftChildIndex<heapData.size && heapData[leftChildIndex]>heapData[candidateIndex]){
                candidateIndex = leftChildIndex
            }

            if(rightChildIndex<heapData.size && heapData[rightChildIndex]>heapData[candidateIndex]){
                candidateIndex = rightChildIndex
            }

            if(candidateIndex == parentIndex){
                return
            }

            Collections.swap(heapData,candidateIndex,parentIndex)
            parentIndex =candidateIndex
        }
    }

    private fun heapify(list: ArrayList<Int>){
        heapData = list
        if(heapData.isNotEmpty()){
            (heapData.size/2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

    companion object{
        fun create(list: ArrayList<Int>):IntegerHeap{
            val heap =  IntegerHeap()
            heap.heapify(list)
            return  heap
        }
    }
}

fun main(){
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val integerHeap = IntegerHeap.create(array)
    integerHeap.heapData.forEach {
        println(it)
    }
}