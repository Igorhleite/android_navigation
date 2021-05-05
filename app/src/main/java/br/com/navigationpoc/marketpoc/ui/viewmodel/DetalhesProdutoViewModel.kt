package br.com.navigationpoc.marketpoc.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.navigationpoc.marketpoc.repository.ProdutoRepository

class DetalhesProdutoViewModel(
    produtoId: Long,
    repository: ProdutoRepository
) : ViewModel() {

    val produtoEncontrado = repository.buscaPorId(produtoId)

}