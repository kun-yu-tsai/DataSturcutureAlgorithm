package com.example.datastructure

import org.junit.Test

class LinkedListTest {
    class Node(val data: Int, var node: Node? = null) {
        fun print() {
            println(data)
            node?.print()
        }
    }

    class MyLinkedList {
        private var head: Node? = null
        private var end: Node? = null

        fun addTail(data: Int) {
            end?.node = Node(data)
            end = end?.node
        }

        fun addHead(data: Int) {
            val newHead = Node(data, head)
            head = newHead
            if (end == null)
                end = head
        }

        fun addIndex(data: Int, index: Int) {
            var temp: Node? = head
            repeat(index - 1) {
                temp = temp?.node
            }

            temp?.node = Node(data, temp?.node)
        }

        fun traversePrint() {
            head?.print()
        }

        fun reverseAll() {
            fun reverse(firstNode: Node, secondNode: Node): Node {
                val thirdNode = secondNode.node
                secondNode.node = firstNode
                return if (thirdNode != null)
                    reverse(secondNode, thirdNode)
                else {
                    secondNode
                }
            }

            val node = reverse(head!!, head?.node!!)
            head?.node = null
            end = head
            head = node
        }

        fun iterativeReverse(){
            var current = head
            var previous : Node? = null
            var next = current?.node

            while (current != null){
                current.node = previous

                previous = current
                current = next
                next = next?.node
            }

            head = previous
        }
    }

    @Test
    fun test1(){
        repeat(5){
            println(it)
        }
    }

    @Test
    fun test() {
        val myLinkedList = MyLinkedList()
        myLinkedList.addHead(3)
        myLinkedList.addHead(2)
        myLinkedList.addHead(1)
        myLinkedList.addTail(4)
        myLinkedList.addTail(5)
        myLinkedList.addTail(100)
        myLinkedList.addHead(0)
        myLinkedList.addIndex(6, 2)
        myLinkedList.addIndex(10, 4)
        myLinkedList.traversePrint()
//        myLinkedList.reverseAll()
        myLinkedList.iterativeReverse()
        println()
        myLinkedList.traversePrint()

    }
}