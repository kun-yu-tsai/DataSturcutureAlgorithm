package com.example.datastructure

import org.junit.Test
import java.util.*

class Sort {
    @Test
    fun sort() {
        val array = intArrayOf(3, 2, 5, 1, 6, 9, 8, 7, 4)
        insertionSort(array)

        println(Arrays.toString(array))
    }

    private fun insertionSort(array: IntArray) {
        var sortedIndex = 0
        val lastIndex = array.lastIndex

        // 0, 1, 2, 3, 4, 5
        // 0, 3, 4, 5, 2, 1
        // sortedIndex = 3
        // hole = 4
        // value = 2

        while (sortedIndex < lastIndex) { // when sortedIndex == lastIndex, exit

            var currentHole = sortedIndex + 1
            val unsortedValue = array[currentHole]

            while (currentHole > 0 && unsortedValue < array[currentHole - 1] ) {
                array[currentHole] = array[currentHole - 1]
                currentHole--
            }

            array[currentHole] = unsortedValue
            sortedIndex++
        }
    }

    private fun bubbleSort(array: IntArray) {
        // 0, 1, 2, 3, 4
        // 0, 3, 4, 5, 2
        // 0, 3, 4, 2, 5

        var lastIndex = array.lastIndex
        var i: Int
        var swapHappened: Boolean
        while (lastIndex > 0) {
            i = 0
            swapHappened = false
            while (i < lastIndex) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1)
                    swapHappened = true
                }
                i++
            }

            if (!swapHappened) {
                return
            }
            lastIndex--
        }
    }

    private fun selectionSort(array: IntArray) {
        var minValueIndex: Int
        var indexToSwap = 0
        val lastIndex = array.lastIndex

        while (indexToSwap < lastIndex) {
            minValueIndex = indexToSwap
            for (i in (indexToSwap + 1)..lastIndex) {
                if (array[i] < array[minValueIndex]) {
                    minValueIndex = i
                }
            }

            swap(array, indexToSwap, minValueIndex)
            indexToSwap++
        }

    }

    fun swap(array: IntArray, a: Int, b: Int) {
        val temp = array[a]
        array[a] = array[b]
        array[b] = temp
    }
}