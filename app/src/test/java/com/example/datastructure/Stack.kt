package com.example.datastructure

import org.junit.Test

class Stack {
    var index = -1
    var array = IntArray(10)

    fun put(value: Int) {
        index++
        array[index] = value

        if (array.lastIndex == index) {
            val newArray = IntArray(array.size * 2)
            for (position in array.indices) {
                newArray[position] = array[position]
            }
            array = newArray
        }
    }

    fun pop() : Int{
        if(index == -1){
            return -1
        }

        index--
        return array[index + 1]
    }

    @Test
    fun test(){
        val stack = Stack()
        stack.put(2)
        stack.put(3)
        stack.put(4)
        stack.put(5)
        stack.put(6)

        while( stack.index != -1){
            println(stack.pop())
        }
    }
}