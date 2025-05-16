/**

 * Using a when expression, update the following program so that it prints the corresponding actions
 * when you input the names of game console buttons:
 *
 * A → Yes
 * B → No
 * X → Menu
 * Y → Nothing
 * Other → There is no such button
 */
fun main() {
    val button = "b"

    val action = when (button.uppercase()) {
        "A" -> "Yes"
        "B" -> "No"
        "X" -> "Menu"
        "Y" -> "Nothing"
        else -> "There is no such button"
    }

    println(action)
}
