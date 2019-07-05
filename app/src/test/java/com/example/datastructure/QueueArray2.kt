package com.example.datastructure

import org.junit.Assert
import org.junit.Test

class QueueArray2 {
//    class MyQueue(size: Int) {
//        val array = IntArray(size){ -1 }
//        var currentAvailableHead = -1
//        var lastEmptyPosition = 0
//
//        fun enqueue(data: Int) {
//            if (lastEmptyPosition > array.lastIndex) throw IllegalStateException("Full")
//            array[lastEmptyPosition] = data
//            lastEmptyPosition++
//
//            if (lastEmptyPosition > array.lastIndex && currentAvailableHead != -1) lastEmptyPosition = 0
//            if (currentAvailableHead == -1) currentAvailableHead = 0
//
//            println("enqueue $data ${Arrays.toString(array)}")
//        }
//
//        fun dequeue(): Int {
//            if (currentAvailableHead == -1) throw IllegalStateException("No available data")
//            if (currentAvailableHead > array.lastIndex) throw IllegalStateException("Over fetch")
//
//            return array[currentAvailableHead].apply {
//                array[currentAvailableHead] = -1
//                currentAvailableHead++
//                if(currentAvailableHead > array.lastIndex && lastEmptyPosition)
//                println("pop ${Arrays.toString(array)}")
//            }
//        }
//    }

    class MyQueue(size: Int) {
        val array = IntArray(size) { -1 }
        var currentPopOutLocationInTheQueue = 0 // start from 0
        var lastItemOfTheQueue = -1 // no item at first

        fun enqueue(data: Int) {
            lastItemOfTheQueue++
            if (lastItemOfTheQueue > array.lastIndex && currentPopOutLocationInTheQueue > 0){
                lastItemOfTheQueue = 0
            }

            array[lastItemOfTheQueue] = data
        }

        fun dequeue(): Int {
            if(currentPopOutLocationInTheQueue > array.lastIndex && lastItemOfTheQueue < array.lastIndex){
                currentPopOutLocationInTheQueue = 0
            }
            val pop = array[currentPopOutLocationInTheQueue]
            currentPopOutLocationInTheQueue++
            return pop
        }
    }

    @Test
    fun test() {
        val queue = MyQueue(3)

        queue.enqueue(5)
        queue.enqueue(6)
        queue.enqueue(7)
        queue.enqueue(1) // shall throw exception

        Assert.assertEquals(5, queue.dequeue())
        queue.enqueue(8)

        Assert.assertEquals(6, queue.dequeue())
        queue.enqueue(9)


        Assert.assertEquals(7, queue.dequeue())
//        Assert.assertEquals(7, queue.dequeue()) // throw error
        Assert.assertEquals(8, queue.dequeue())
        Assert.assertEquals(9, queue.dequeue())
//        Assert.assertEquals(9, queue.dequeue())

        queue.enqueue(5)
        queue.enqueue(6)
        queue.enqueue(7)

        Assert.assertEquals(5, queue.dequeue())
        Assert.assertEquals(6, queue.dequeue())
        queue.enqueue(10)
        Assert.assertEquals(7, queue.dequeue())

        Assert.assertEquals(10, queue.dequeue())
    }
}