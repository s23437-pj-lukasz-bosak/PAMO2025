/**
 * You have a function that translates a time interval given in hours, minutes, and seconds into seconds.
 * Improve the function and the code that calls it by using default parameter values and named arguments
 * so that the code is easier to read.
 */
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
    (hours * 60 + minutes) * 60 + seconds

fun main() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1, seconds = 25))
    println(intervalInSeconds(hours = 2))
    println(intervalInSeconds(minutes = 10))
    println(intervalInSeconds(hours = 1, seconds = 1))
}
