package br.com.zup.caixasupermercado.Produto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Produto(
    private var produtoNome: String,
    private var produtoQntd: Int,
    private var produtoValor: Double,

) : Parcelable {

    fun getNomeProduto() = produtoNome
    fun getQntdProduto() = produtoQntd
    fun getValorProduto() = produtoValor
}