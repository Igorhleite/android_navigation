package br.com.navigationpoc.marketpoc.extensions

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formatParaMoedaBrasileira(): String {
    val formatoBrasileiro = DecimalFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return formatoBrasileiro
        .format(this)
}