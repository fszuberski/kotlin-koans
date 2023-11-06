import java.util.*

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(
    col1: C,
    col2: C,
    predicate: (T) -> Boolean
): Pair<MutableCollection<T>, MutableCollection<T>> {
    val (first, second) = partition(predicate)

    first.forEach { col1.add(it) }
    second.forEach { col2.add(it) }

    return Pair(col1, col2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
