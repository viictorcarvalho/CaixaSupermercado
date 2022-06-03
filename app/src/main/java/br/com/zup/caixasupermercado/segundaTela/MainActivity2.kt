package br.com.zup.caixasupermercado.segundaTela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.caixasupermercado.NOME_PRODUTO
import br.com.zup.caixasupermercado.Produto.Produto
import br.com.zup.caixasupermercado.R
import br.com.zup.caixasupermercado.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.carrinho)
        recuperarExibirDados()

        binding.btnVoltar.setOnClickListener {
            onBackPressed()
        }
    }

    private fun recuperarExibirDados() {
        val produto = intent.getParcelableExtra<Produto>(NOME_PRODUTO)
        if (produto != null) {
            exibirNomeProduto(produto.getNomeProduto())
            val valorTotal = calcularValorTotal(
                produto.getQntdProduto(),
                produto.getValorProduto()
            )
            exibirMensagem(valorTotal)
        }
    }

    private fun exibirNomeProduto(nome: String) {
        binding.tvMensagem.text = nome
    }

    private fun calcularValorTotal(qntdProduto: Int, valorProduto: Double): Double {
        return (qntdProduto * valorProduto)
    }

    private fun exibirMensagem(valorTotal: Double) {
        binding.tvMensagem.text = getString(R.string.valor_total, "%.2f".format(valorTotal))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}