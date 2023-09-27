package array

import kotlin.math.sign

//This is not solved yet
fun subArraysWithKDistinct(nums: IntArray, k: Int): Int {  //1,2,1,3,4
    var result = 0
    val mapB = mutableMapOf<Int,Int>()
    val mapS = mutableMapOf<Int,Int>()
    var ib = -1
    var ism = -1
    var j = -1
    while (true){
        var f1=false
        var f2=false
        var f3=false
        while(ib<nums.size){
            f1=true
            ib++
            if(mapB.size<k){
                mapB.put(nums[ib],mapB.getOrDefault(nums[ib],0)+1)
            }else{
                break
            }

            if(mapB.size==k+1){
                removeFromMap(mapB,nums[ib])
                ib--
            }
        }

        while(ism<ib){
            f2=true
            ism++
            if(mapS.size<k-1){
                mapS.put(nums[ism],mapS.getOrDefault(nums[ism],0)+1)
            }else{
                break
            }

            if(mapS.size==k){
                removeFromMap(mapB,nums[ism])
                ism--
            }
        } 

        while(j<ism){
            f3=true
            if(mapB.size==k && mapS.size==k-1){
                result += ib-ism
            }
            j++
            removeFromMap(mapB,nums[j])
            removeFromMap(mapS,nums[j])
            if(mapB.size<k || mapS.size<k-1){
                break
            }
        }

        if(!f1 && !f2 && !f3){
            break
        }
    }
    return result
}

fun removeFromMap(map: MutableMap<Int,Int>,key:Int){
    map[key]?.let {
        if(it>1){
            map.remove(key)
        }else{
            map[key] = it-1
        }
    }
}

fun main(){
    print(subArraysWithKDistinct(intArrayOf(1,2,1,3,4),3))
}