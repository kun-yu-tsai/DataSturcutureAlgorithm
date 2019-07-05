package com.example.datastructure

import org.junit.Test

class LinkedListStack {
    class Node(val data: Int, var next: Node? = null, var previous: Node? = null)

    var head: Node? = null
    var end: Node? = null

    fun put(data: Int) {
        val node = Node(data)

        if (head == null) {
            node.previous = null
            node.next = null
            head = node
            end = node
        } else {
            node.previous = end
            node.next = null
            end?.next = node
            end = node
        }
    }

    fun pop() : Node{
        val pop = end
        end = end?.previous
        end?.next = null
        return pop!!
    }

    @Test
    fun test(){
        val linkedListStack = LinkedListStack()
        linkedListStack.put(3)
        linkedListStack.put(4)
        linkedListStack.put(5)
        linkedListStack.put(6)
        linkedListStack.pop()
        linkedListStack.put(1)
        linkedListStack.pop()
        linkedListStack.put(2)

        while (linkedListStack.end != null){
            println(linkedListStack.pop().data)
        }
    }
}