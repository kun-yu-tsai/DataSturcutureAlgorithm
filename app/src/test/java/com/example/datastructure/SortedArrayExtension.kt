package com.example.datastructure

import org.junit.Test
import java.util.*

class SortedArrayExtension {
    @Test
    fun test() {
        var array = intArrayOf(
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            9,
            9,
            10,
            11,
            12,
            12,
            12,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            19,
            20,
            20,
            20,
            20,
            20
        )

        val array2 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        array = array2
        println(findRotationCountMaster(array))

        rotateArray(array, 5)
        println(Arrays.toString(array))
        println(findRotationCountMaster(array))
    }

    fun rotateArray(array: IntArray, count: Int) {
        val lastValue = array[array.lastIndex]
        repeat(count) {
            for (index in array.lastIndex - 1 downTo 0) {
                array[index + 1] = array[index]
            }
            array[0] = lastValue
        }
    }

    fun findRotationCountMaster(array: IntArray): Int {
        biggestValueIndex = array.lastIndex
        findRotationCount(array, 0, array.lastIndex)
        if (biggestValueIndex == array.lastIndex) return 0
        else return biggestValueIndex + 1
    }

    var biggestValueIndex: Int = -1
    fun findRotationCount(array: IntArray, head: Int, tail: Int) {
        if (head < tail) {
            val mid = (head + tail) / 2
            if (array[biggestValueIndex] < array[mid]) biggestValueIndex = mid

            if (array[tail] > array[head])
                return

            if (array[mid] > array[tail]) { // look right
                findRotationCount(array, mid + 1, tail)
            } else if (array[head] > array[mid]) { // look left
                findRotationCount(array, head, mid - 1)
            } else
                return
        }
    }
}