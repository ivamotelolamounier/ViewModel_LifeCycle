package com.ivamotelo.vmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Classe ViewModel utilizada para separar os componentes de UI das regras de negócio
 * bem como para gerenciar o ciclo de vida da Activity, através dos métodos 'lifedata'
 * e 'observer' e também da classe MutableLiveData, uma vez que for introduzido um valor
 *
 */
class MainViewModel : ViewModel() {
    var mContador = MutableLiveData<String>().apply{ value = contador.toString() }
    private var contador: Int = 0

    /**
     * Função para checar se o contador atingiu o valor limite (6), se verdadeiro, então o contador
     * é zerado e recomeça a rotina
     */
    private fun setmContador(){
        mContador.value = contador.toString()
    }
    private fun validaContador() {
        contador++
        if (contador >= 6) {
            contador = 0
        }
        setmContador()
    }

    fun contador(){
        validaContador()
    }
}