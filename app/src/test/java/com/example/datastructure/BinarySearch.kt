package com.example.datastructure

import org.junit.Test

class BinarySearch {
    @Test
    fun test() {
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val target = 4

        println(search(array, 0, array.lastIndex, target))
        println(searchRecursive(array, 0, array.lastIndex, target))
        println(searchIterative(array, target))
    }

    fun searchRecursive(array: IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end)
            return -1

        val mid = (start + end) / 2
        if (array[mid] == target)
            return mid

        if (target > array[mid])
            return searchRecursive(array, mid + 1, end, target)
        else
            return searchRecursive(array, start, mid - 1, target)
    }

    fun searchIterative(array: IntArray, target: Int): Int {
        var start = 0
        var end = array.lastIndex

        while (start <= end) {
            val mid = (start + end) / 2

            if (array[mid] == target)
                return mid

            if (target > array[mid]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return -1
    }

    fun search(array: IntArray, start: Int, end: Int, target: Int): Int {
        // 1,2,3,4
        if (start > end)
            return -1 // can't find it.

        val mid = (start + end) / 2

        if (array[mid] == target)
            return mid

        if (target > array[mid])
            return search(array, mid + 1, end, target)
        else
            return search(array, start, mid - 1, target)
    }
}