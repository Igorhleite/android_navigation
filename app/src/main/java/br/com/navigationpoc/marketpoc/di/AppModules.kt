package br.com.navigationpoc.marketpoc.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.navigationpoc.marketpoc.database.AppDatabase
import br.com.navigationpoc.marketpoc.database.dao.PagamentoDAO
import br.com.navigationpoc.marketpoc.database.dao.ProdutoDAO
import br.com.navigationpoc.marketpoc.model.Produto
import br.com.navigationpoc.marketpoc.repository.PagamentoRepository
import br.com.navigationpoc.marketpoc.repository.ProdutoRepository
import br.com.navigationpoc.marketpoc.ui.fragment.DetalhesProdutoFragment
import br.com.navigationpoc.marketpoc.ui.fragment.ListaProdutosFragment
import br.com.navigationpoc.marketpoc.ui.fragment.PagamentoFragment
import br.com.navigationpoc.marketpoc.ui.recyclerview.adapter.ProdutosAdapter
import br.com.navigationpoc.marketpoc.ui.viewmodel.DetalhesProdutoViewModel
import br.com.navigationpoc.marketpoc.ui.viewmodel.PagamentoViewModel
import br.com.navigationpoc.marketpoc.ui.viewmodel.ProdutosViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.math.BigDecimal

private const val NOME_BANCO_DE_DADOS = "aluraesporte.db"
private const val NOME_BANCO_DE_DADOS_TESTE = "aluraesporte-test.db"

val testeDatabaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS_TESTE
        ).fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(IO).launch {
                        val dao: ProdutoDAO by inject()
                        dao.salva(
                            Produto(
                                nome = "Bola de futebol",
                                preco = BigDecimal("100")
                            ), Produto(
                                nome = "Camisa",
                                preco = BigDecimal("80")
                            ),
                            Produto(
                                nome = "Chuteira",
                                preco = BigDecimal("120")
                            ), Produto(
                                nome = "Bermuda",
                                preco = BigDecimal("60")
                            )
                        )
                    }
                }
            }).build()
    }
}

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }
}

val daoModule = module {
    single<ProdutoDAO> { get<AppDatabase>().produtoDao() }
    single<PagamentoDAO> { get<AppDatabase>().pagamentoDao() }
    single<ProdutoRepository> { ProdutoRepository(get()) }
    single<PagamentoRepository> { PagamentoRepository(get()) }
}

val uiModule = module {
    factory<DetalhesProdutoFragment> { DetalhesProdutoFragment() }
    factory<ListaProdutosFragment> { ListaProdutosFragment() }
    factory<PagamentoFragment> { PagamentoFragment() }
    factory<ProdutosAdapter> { ProdutosAdapter(get()) }
}

val viewModelModule = module {
    viewModel<ProdutosViewModel> { ProdutosViewModel(get()) }
    viewModel<DetalhesProdutoViewModel> { (id: Long) -> DetalhesProdutoViewModel(id, get()) }
    viewModel<PagamentoViewModel> { PagamentoViewModel(get(), get()) }
}