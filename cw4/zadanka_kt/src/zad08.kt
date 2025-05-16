/**
  * You have a list of words. Use `for` and `if` to print only the words that start with the letter 'L'.
 * Hint: Use the `startsWith()` function for String type.
 */
fun main() {
    val words = listOf("dinosaur", "Limousine", "magazine", "language")

    for (w in words) {
        if (w.startsWith("L", ignoreCase = true)) {
            println(w)
        }
    }
}
