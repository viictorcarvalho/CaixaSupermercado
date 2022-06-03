package br.com.zup.caixasupermercado.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.zup.caixasupermercado.MENSAGEM_CAMPO_OBRIGATORIO
import br.com.zup.caixasupermercado.NOME_PRODUTO
import br.com.zup.caixasupermercado.Produto.Produto
import br.com.zup.caixasupermercado.R
import br.com.zup.caixasupermercado.databinding.ActivityMainBinding
import br.com.zup.caixasupermercado.segundaTela.MainActivity2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nomeProduto: String
    private lateinit var qntdProduto: String
    private lateinit var valorProduto: String
    private lateinit var produto: Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.name_home)

        val btnCalcular = binding.btnCalcularTotal
        btnCalcular.setOnClickListener {
            enviarDadosProduto()
        }
    }
        private fun enviarDadosProduto() {
            recuperarDadosCampoEdicao()
            if (!verificarCamposEdicao()) {
                val produto = Produto(
                    nomeProduto,
                    qntdProduto.toInt(),
                    valorProduto.toDouble()
                )

                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra(NOME_PRODUTO, produto)
                }
                startActivity(intent)
                limparCamposEdicao()
            }
        }

        private fun recuperarDadosCampoEdicao() {
            this.nomeProduto = binding.etProduto.text.toString()
            this.qntdProduto = binding.etQntdProduto.text.toString()
            this.valorProduto = binding.etValorProduto.text.toString()
        }

        private fun verificarCamposEdicao(): Boolean {
            when {
                this.nomeProduto.isEmpty() -> {
                    binding.etProduto.error = MENSAGEM_CAMPO_OBRIGATORIO
                    return true
                }
                this.qntdProduto.isEmpty() -> {
                    binding.etQntdProduto.error = MENSAGEM_CAMPO_OBRIGATORIO
                    return true
                }
                this.valorProduto.isEmpty() -> {
                    binding.etValorProduto.error = MENSAGEM_CAMPO_OBRIGATORIO
                    return true
                }
            }
            return false
        }

        private fun limparCamposEdicao() {
            binding.etProduto.text.clear()
            binding.etQntdProduto.text.clear()
            binding.etValorProduto.text.clear()
        }
    }