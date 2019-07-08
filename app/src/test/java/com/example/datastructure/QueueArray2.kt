package com.example.datastructure

import org.junit.Assert
import org.junit.Test

// try to do circle queue, but failed.
class QueueArray2 {

    class MyQueue(size: Int) {
        val array = IntArray(size) { -1 }
        var currentPopOutLocationInTheQueue = -1 // nothing to pop up
        var lastItemOfTheQueue = -1 // no item at first

        fun enqueue(data: Int) {
            lastItemOfTheQueue++

            if (lastItemOfTheQueue > array.lastIndex && currentPopOutLocationInTheQueue <= 0)
                throw IllegalStateException("Full")
            if (lastItemOfTheQueue > array.lastIndex && currentPopOutLocationInTheQueue > 0) lastItemOfTheQueue = 0
            if (lastItemOfTheQueue == currentPopOutLocationInTheQueue) throw IllegalStateException("Another full")

//            if(lastItemOfTheQueue > array.lastIndex) throw IllegalStateException("Full")

            array[lastItemOfTheQueue] = data
            if (currentPopOutLocationInTheQueue == -1) currentPopOutLocationInTheQueue = 0
        }

        fun dequeue(): Int {
            if (currentPopOutLocationInTheQueue > array.lastIndex && lastItemOfTheQueue != array.lastIndex)
                currentPopOutLocationInTheQueue = 0

            if (currentPopOutLocationInTheQueue == -1) throw IllegalStateException("no data")
            val pop = array[currentPopOutLocationInTheQueue]
            currentPopOutLocationInTheQueue++
            return pop
        }

//        fun enqueue(data: Int) {
//            lastItemOfTheQueue++
//
//            if (lastItemOfTheQueue > array.lastIndex) lastItemOfTheQueue = 0 // go to first index
//            if (lastItemOfTheQueue == currentPopOutLocationInTheQueue) throw IllegalStateException("Full")
//
//            array[lastItemOfTheQueue] = data
//            if (currentPopOutLocationInTheQueue == -1) currentPopOutLocationInTheQueue = 0
//        }
//
//        fun dequeue(): Int {
//            val pop = array[currentPopOutLocationInTheQueue]
//            currentPopOutLocationInTheQueue++
//
//            if (currentPopOutLocationInTheQueue > array.lastIndex) {
//                if (lastItemOfTheQueue == array.lastIndex)
//                    currentPopOutLocationInTheQueue = -1
//                else if (lastItemOfTheQueue >= 0)
//                    currentPopOutLocationInTheQueue = 0
//            }
//
//            return pop
//        }
    }

    @Test
    fun test3() {
        val queue = MyQueue(3)
        queue.enqueue(5)
        queue.enqueue(6)
        queue.enqueue(7)
        queue.enqueue(1) // shall throw exception
    }

    @Test
    fun test() {
        val queue = MyQueue(3)

        queue.enqueue(5)
        queue.enqueue(6)
        queue.enqueue(7)
//        queue.enqueue(1) // shall throw exception

        Assert.assertEquals(5, queue.dequeue())
        queue.enqueue(8)

        Assert.assertEquals(6, queue.dequeue())
        queue.enqueue(9)


        Assert.assertEquals(7, queue.dequeue())
//        Assert.assertEquals(7, queue.dequeue()) // throw error
        Assert.assertEquals(8, queue.dequeue())
        Assert.assertEquals(9, queue.dequeue())
//        Assert.assertEquals(9, queue.dequeue())

        println("${queue.currentPopOutLocationInTheQueue}, ${queue.lastItemOfTheQueue}")
        queue.enqueue(5)
        queue.enqueue(6)
        queue.enqueue(7)
        println("${queue.currentPopOutLocationInTheQueue}, ${queue.lastItemOfTheQueue}")
        queue.enqueue(8)
//        queue.enqueue(9)

        Assert.assertEquals(5, queue.dequeue())
        Assert.assertEquals(6, queue.dequeue())
        queue.enqueue(10)
        queue.enqueue(11)
        Assert.assertEquals(7, queue.dequeue())

        Assert.assertEquals(10, queue.dequeue())
    }

    @Test
    fun test1() {
        val queue = MyQueue(3)

        queue.enqueue(5)
        queue.enqueue(6)
        queue.enqueue(7)

        Assert.assertEquals(5, queue.dequeue())
        queue.enqueue(8)
        Assert.assertEquals(6, queue.dequeue())
        Assert.assertEquals(7, queue.dequeue())
        queue.enqueue(10)
        Assert.assertEquals(8, queue.dequeue())
        Assert.assertEquals(10, queue.dequeue())
    }
}