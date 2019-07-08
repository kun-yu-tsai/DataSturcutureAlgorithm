package com.example.datastructure

import org.junit.Test
import java.util.*

class MergeSort {

    @Test
    fun test() {
        val array = intArrayOf(3, 1, 4, 2, 6, 5, 7, 0, 10, 8,15,13,50,22,19,11,12,51,24)
        sort(array)
        println(Arrays.toString(array))
    }

    fun sort(array: IntArray) {
        // sortArray(xx)
        // sortArray(yy)
        // merge(xx,yy)

        // kill me. Please kill me.
        // break down the problem into sub-problem

        val size = array.size
        if (size < 2) return

        // cut the array into 2 arrays
        val mid = size / 2
        val leftArray = IntArray(mid)
        val rightArray = IntArray(size - mid)

        for (i in 0 until mid) {
            leftArray[i] = array[i]
        }

        for (i in mid until array.size) {
            rightArray[i - mid] = array[i]
        }

        sort(leftArray)
        sort(rightArray)

        // merge
        var i1 = 0
        var i2 = 0
        var updateIndex = 0

        while (i1 < leftArray.size && i2 < rightArray.size) {
            if (leftArray[i1] < rightArray[i2]) {
                array[updateIndex] = leftArray[i1]
                i1++
            } else {
                array[updateIndex] = rightArray[i2]
                i2++
            }
            updateIndex++
        }

        while (i1 < leftArray.size) {
            array[updateIndex] = leftArray[i1]
            updateIndex++
            i1++
        }

        while (i2 < rightArray.size) {
            array[updateIndex] = rightArray[i2]
            updateIndex++
            i2++
        }
    }
}