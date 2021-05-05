package br.com.navigationpoc.marketpoc.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.navigationpoc.marketpoc.database.converter.ConversorBigDecimal
import br.com.navigationpoc.marketpoc.database.dao.PagamentoDAO
import br.com.navigationpoc.marketpoc.database.dao.ProdutoDAO
import br.com.navigationpoc.marketpoc.model.Pagamento
import br.com.navigationpoc.marketpoc.model.Produto

@Database(
    version = 2,
    entities = [Produto::class, Pagamento::class],
    exportSchema = false
)
@TypeConverters(ConversorBigDecimal::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDAO
    abstract fun pagamentoDao(): PagamentoDAO
}