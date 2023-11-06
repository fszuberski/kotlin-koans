import java.util.HashMap

fun <K,V> buildMutableMap(block: HashMap<K, V>.() -> Unit): HashMap<K, V> =
    HashMap<K,V>().apply(block)

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
