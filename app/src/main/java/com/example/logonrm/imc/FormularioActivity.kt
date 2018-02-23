package com.example.logonrm.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formulario.*

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btCalcular.setOnClickListener{
            val telaResultado = Intent(this, ResultadoActivity::class.java)
            startActivity(telaResultado)
            telaResultado.putExtra("PESO", inputPeso.editText?.text.toString())
            telaResultado.putExtra("ALTURA", inputAltura.editText?.text.toString())
        }

        btLimpar.setOnClickListener {
            inputAltura.editText?.setText("")
            inputPeso.editText?.setText("")
        }
    }
}
