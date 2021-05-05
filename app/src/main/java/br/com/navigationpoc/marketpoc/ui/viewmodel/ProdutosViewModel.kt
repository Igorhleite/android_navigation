package br.com.navigationpoc.marketpoc.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.navigationpoc.marketpoc.model.Produto
import br.com.navigationpoc.marketpoc.repository.ProdutoRepository

class ProdutosViewModel(private val repository: ProdutoRepository) : ViewModel() {

    fun buscaTodos(): LiveData<List<Produto>> = repository.buscaTodos()

}
