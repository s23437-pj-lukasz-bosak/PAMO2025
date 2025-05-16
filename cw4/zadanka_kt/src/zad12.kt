/**
  * You have a list of actions supported by a web service, a common prefix for all requests,
 * and an ID of a particular resource.
 * Use a lambda expression to create a list of URLs from the list of actions.
 * Example output for ID = 5 and action = "title":
 * https://example.com/book-info/5/title
 */
fun main() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5

    val urls = actions.map { action -> "$prefix/$id/$action" }
    println(urls)
}
