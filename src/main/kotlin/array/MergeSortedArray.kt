package array

fun main() {

    var nums1 = intArrayOf(1,2,3,0,0,0)
    var nums2 = intArrayOf(2,5,6)
    merge(nums1,3,nums2,3)
    nums1.forEach { println(it)  }
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var last = m+n-1
    var mIndex= m-1
    var nIndex= n-1
    while(mIndex>=0 && nIndex>=0){
        if(nums1[mIndex]>nums2[nIndex]){
            nums1[last]=nums1[mIndex]
            mIndex--
        }else{
            nums1[last]=nums2[nIndex]
            nIndex--
        }
        last--
    }

    while(nIndex>=0){
        nums1[last]=nums2[nIndex]
        nIndex--
        last--
    }
}
