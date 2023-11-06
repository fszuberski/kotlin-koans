fun renderProductTable(): String {
    return html {

        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            getProducts().forEachIndexed { index, product ->
                tr {
                    td(getCellColor(index, 0)) {
                        text(product.description)
                    }
                    td(getCellColor(index, 1)) {
                        text(product.price)
                    }
                    td(getCellColor(index, 2)) {
                        text(product.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, column: Int) = if ((index + column) % 2 == 0) "#dce4ff" else "#eff2ff"
