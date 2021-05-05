package br.com.navigationpoc.marketpoc.database.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.navigationpoc.marketpoc.model.Pagamento

@Dao
interface PagamentoDAO {

    @Insert
    fun salva(pagamento: Pagamento) : Long

}