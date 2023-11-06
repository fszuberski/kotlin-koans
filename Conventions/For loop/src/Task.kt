class DateRange(private val start: MyDate, private val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        var current: MyDate = start

        return object : Iterator<MyDate> {
            override fun hasNext() = current <= end

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = current
                current = current.followingDate()
                return result
            }

        }

    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}