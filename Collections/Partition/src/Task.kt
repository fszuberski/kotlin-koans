// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers
        .filter {
            val (match, rest) = it.orders.partition { it.isDelivered }
            rest.count() > match.count()
        }.toSet()

