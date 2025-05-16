/**
 * Write a program that simulates the FizzBuzz game.
 * Print numbers from 1 to 100. For each number:
 * - If divisible by 3 → print "fizz"
 * - If divisible by 5 → print "buzz"
 * - If divisible by both 3 and 5 → print "fizzbuzz"
 * - Otherwise, print the number
 */
fun main() {
    for (i in 1..100) {
        val result = when {
            i % 3 == 0 && i % 5 == 0 -> "fizzbuzz"
            i % 3 == 0 -> "fizz"
            i % 5 == 0 -> "buzz"
            else -> i.toString()
        }
        println(result)
    }
}