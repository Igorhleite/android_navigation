package br.com.navigationpoc.marketpoc.repository

import androidx.lifecycle.LiveData
import br.com.navigationpoc.marketpoc.database.dao.ProdutoDAO
import br.com.navigationpoc.marketpoc.model.Produto

class ProdutoRepository(private val dao: ProdutoDAO) {

    fun buscaTodos(): LiveData<List<Produto>> = dao.buscaTodos()

    fun buscaPorId(id: Long): LiveData<Produto> = dao.buscaPorId(id)

}
