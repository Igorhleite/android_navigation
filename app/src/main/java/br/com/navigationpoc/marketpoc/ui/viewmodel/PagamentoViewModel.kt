package br.com.navigationpoc.marketpoc.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.navigationpoc.marketpoc.model.Pagamento
import br.com.navigationpoc.marketpoc.repository.PagamentoRepository
import br.com.navigationpoc.marketpoc.repository.ProdutoRepository

class PagamentoViewModel(
    private val pagamentoRepository: PagamentoRepository,
    private val produtodRepository: ProdutoRepository) : ViewModel() {

    fun salva(pagamento: Pagamento) = pagamentoRepository.salva(pagamento)
    fun buscaProdutoPorId(id: Long) = produtodRepository.buscaPorId(id)

}