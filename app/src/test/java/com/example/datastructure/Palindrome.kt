package com.example.datastructure

import org.junit.Test

class Palindrome {
    @Test
    fun test() {

    }

    fun isPalindrome(string: String, head: Int = 0, tail: Int = string.lastIndex): Boolean {
        var head = head
        var tail = tail

        while (head < tail) {
            if (string[head] == string[tail]) {
                head++
                tail--
                continue
            } else {
                return isPalindrome(string, head + 1, tail) || isPalindrome(string, head, tail - 1)

            }


        }

        return true
    }

}