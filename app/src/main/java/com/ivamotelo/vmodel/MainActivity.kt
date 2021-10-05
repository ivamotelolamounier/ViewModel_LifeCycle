package com.ivamotelo.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    /**
     * Cria as variáveis referentes aos componentes Txt e btn da UI
     * cria uma variável do tipo 'ViewModel', importada da classe 'mainViewModel'
     */

    lateinit var mViewModel : MainViewModel

    lateinit var edtContador : EditText
    lateinit var btnDados : Button
    lateinit var btnMostar : Button

    //var contador : Int = 0
    //val logCycle : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        //logCycle(valor = "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        //initContador()
        initClick()
    }
    /**
     * inicializa e instância os componentes EditText e Buttons da UI, importando os mesmos da
     * parte gráfica para programação. Implementa-se a variável mViewModel na inicialização
     * dos dados da UI, que recebe a 'MainViewModel da class.java'
     */
    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        edtContador = findViewById(R.id.edt_contador)
        btnDados = findViewById(R.id.btn_dados)
        btnMostar = findViewById(R.id.btn_mostrar)

        /** Sempre que contador for alterado, o observer desencadeará uma ação, no caso setando
         * o 'edtContador' com o 'valor' alterado
         */

        mViewModel.mContador.observe(this, Observer { valor ->
            edtContador.setText(valor)
        })
    }
    /**
     * Função para gerenciar o Button 'btn_Dados', de modo que toda as vezes que houver um click
     * no mesmo, será somado 1 no EditText 'edt_contador' na função 'initContador()'.
     * Ao clicar no 'btn_mostrar', será exibido um Toast com o valor atualizado do contador.
     * É chamada a função 'initContador()' para incrementar o contador e exibir os dados atualizados
     * no EditText 'edt_contador'.
     * Após validar se o contador atingiu o valor limite (6), a função 'validaContador()' será ativada
     * sua chamda será no btn_Dados
     */
    private fun initClick() {
        btnDados.setOnClickListener {
            mViewModel.contador()
            // contador++
            // validaContador()
            // initContador()

        }
        btnMostar.setOnClickListener {
          Toast.makeText(applicationContext,"Contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }
}
    /**
    override fun onStart() {
        logCycle(valor = "onStart")
        super.onStart()
    }

    override fun onResume() {
        logCycle(valor = "onResume")
        super.onResume()
    }

    override fun onPause() {
        logCycle(valor = "onPause")
        super.onPause()
    }

    override fun onRestart() {
        logCycle(valor = "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        logCycle(valor = "onDestroy")
        super.onDestroy()
    }

    private fun logCycle(tag: String = "LifeCycle", valor: String){
        Log.d(tag, valor)

    }
    */


    /**
     * Função para inicializar o o EditText 'contador' como zero
    private fun initContador(){
        edtContador.setText(contador.toString())
    }
     */

