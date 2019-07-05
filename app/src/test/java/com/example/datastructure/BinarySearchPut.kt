package com.example.datastructure

import org.junit.Assert
import org.junit.Test

class BinarySearchPut {
    @Test
    fun search(){
        Assert.assertEquals(3, searchPut2(intArrayOf(3,5,7,9,11,12,13,14), 9))
        Assert.assertEquals(0, searchPut2(intArrayOf(3,5,7,9,11,12,13,14), 3))
        Assert.assertEquals(1, searchPut2(intArrayOf(3,5,7,9,11,12,13,14), 4))
        Assert.assertEquals(2, searchPut2(intArrayOf(3,5,7,9,11,12,13,14), 6))
        Assert.assertEquals(6, searchPut2(intArrayOf(3,5,7,9,11,12,13,14), 13))
        Assert.assertEquals(8, searchPut2(intArrayOf(3,5,7,9,11,12,13,14), 15))
        Assert.assertEquals(0, searchPut2(intArrayOf(), 15))

    }

    fun searchPut(array: IntArray, num: Int): Int {
        var head = 0
        var tail = array.lastIndex

        while (head <= tail) {
            var mid = (head + tail) / 2
            if (num == array[mid])
                return mid
            else if (num > array[mid]) {
                head = mid + 1
            } else {
                tail = mid - 1
            }
        }

        return -1
    }

    fun searchPut1(array: IntArray, num: Int): Int {
        var head = 0
        var tail = array.lastIndex

        while (head <= tail) {
            var mid = (head + tail) / 2
            if (num == array[mid])
                return mid
            else if (num > array[mid]) {
                head = mid + 1
            } else {
                tail = mid - 1
            }
        }

        return head
    }

    fun searchPut2(array: IntArray, num: Int): Int {
        var head = 0
        var tail = array.lastIndex

        while( head <= tail){
            var mid = (head + tail )/ 2
            if(num == array[mid])
                return mid
            else if( num > array[mid]){
                head = mid + 1
            }else{
                tail = mid - 1
            }
        }

        return head
    }
}