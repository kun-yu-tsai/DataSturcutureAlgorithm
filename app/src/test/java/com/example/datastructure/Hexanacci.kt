package com.example.datastructure

import org.junit.Test
import java.math.BigInteger



class Hexanacci {

    @Test
    fun test() {
        // 1, 1, 2, 4, 8, 16, 32, 64, 128
        // f(n) = f(n-1) + f(n-2) + f(n-3) .... f(0)
        // f(n) = f(n-1)
        println(hexa(8))


    }

    fun hexa(n: Int): Int {
        if (n == 0) return 1
        var result = 0
        for (i in (n-1) downTo 0) {
            val hex = hexa(i)
            result += hex
        }

        return result
    }
}