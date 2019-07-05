package com.example.datastructure

import org.junit.Test

class QueueArray {
    var array = IntArray(10)
    var head = -1
    var tail = -1

    fun enqueue(data: Int) {
        if (tail == array.lastIndex) {
            // increase the array
            throw Exception()
        }

        if (head == -1) {
            head++
            array[head] = data
            tail = head
        } else {
            tail++
            array[tail] = data
        }
    }

    fun dequeue(): Int {
        if( head <= tail){
            val pop = array[head]
            head++
            return pop
        }
        else
            return -1
    }

    @Test
    fun test(){
        val queueArray = QueueArray()
        queueArray.enqueue(2)
        queueArray.enqueue(3)
        queueArray.enqueue(4)
        queueArray.enqueue(5)
        queueArray.enqueue(5)
        queueArray.enqueue(5)
        queueArray.enqueue(5)

        while(queueArray.head <= queueArray.tail){
            println(queueArray.dequeue())
        }
    }
}