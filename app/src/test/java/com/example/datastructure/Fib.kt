package com.example.datastructure

import org.junit.Test
import kotlin.system.measureTimeMillis

class Fib {
    @Test
    fun test() {

        val n = 45
        val t1 = measureTimeMillis {
            println(fibIterative(n))
        }
        println(t1)

        val t2 = measureTimeMillis {
            println(fibRecursiveImprovewd(n))
        }
        println(t2)

        val t3 = measureTimeMillis {
            println(fibRecursive(n))
        }
        println(t3)
    }

    @Test
    fun factorial() {
        println(fac(20))
    }

    fun fac(n: Int): Long {
        // 5 = 5 * f(4)
        // 0 = 1
        // 1 = 1* f(0)
        if (n == 0)
            return 1

        return n * fac(n - 1)
    }

    val map = HashMap<Int, Int>()

    val memo = IntArray(51)

    @Test
    fun testFibArray() {
        for (index in memo.indices)
            memo[index] = -1

        memo[0] = 0
        memo[1] = 1


        val n = 42
        measureTimeMillis {
            println(fibRecursiveArray(n))
        }.apply { println(this) }

        measureTimeMillis {
            println(fibIterative(n))
        }.apply { println(this) }

        measureTimeMillis {
            println(fibRecursiveImprovewd(n))
        }.apply { println(this) }

        measureTimeMillis {
            println(fibRecursive(n))
        }.apply { println(this) }

    }

    fun fibRecursiveArray(n: Int): Int {
        if (memo[n] != -1)
            return memo[n]

        memo[n] = fibRecursive(n - 1) + fibRecursive(n - 2)
        return memo[n]
    }

    fun fibRecursive(n: Int): Int {
        if (n <= 1)
            return n
        return fibRecursive(n - 1) + fibRecursive(n - 2)
    }


    fun fibRecursiveImprovewd(n: Int): Int {
        if (map.containsKey(n))
            return map[n]!!

        if (n <= 1)
            return n

        val value = fibRecursive(n - 1) + fibRecursive(n - 2)
        if (!map.containsKey(n))
            map[n] = value

        return value
    }


    fun fibIterative(n: Int): Int {
        if (n <= 1)
            return n

        var f0 = 0
        var f1 = 1
        var f2 = 0
        for (i in 2..n) {
            f2 = f0 + f1
            f0 = f1
            f1 = f2
        }

        return f2
    }
}