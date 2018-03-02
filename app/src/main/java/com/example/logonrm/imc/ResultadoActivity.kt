package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonrm.imc.extension.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if (intent != null){
            val peso = intent.getStringExtra("PESO").toDouble()
            val altura = intent.getStringExtra("ALTURA").toDouble()

            val imc = peso / (altura * altura)

            tvValorIMC.setText(imc.format(1))

            if(imc <= 18.5){
                alteraImagemIMC(R.drawable.abaixo)
                tvStatusIMC.text = "Abaixo do peso"
            } else if(imc <= 24.9){
                alteraImagemIMC(R.drawable.ideal)
                tvStatusIMC.text = "Peso ideal"
            } else if(imc <= 29.9){
                alteraImagemIMC(R.drawable.sobre)
                tvStatusIMC.text = "Sobrepeso"
            } else if(imc <= 34.9){
                alteraImagemIMC(R.drawable.obesidade)
                tvStatusIMC.text = "Obesidade I"
            } else if(imc <= 39.9){
                alteraImagemIMC(R.drawable.obesidade)
                tvStatusIMC.text = "Obesidade II (severa)"
            } else {
                alteraImagemIMC(R.drawable.obesidade)
                tvStatusIMC.text = "Obesidade III (mórbida)"
            }
        }
    }

    fun alteraImagemIMC(idImagem: Int){
        ivImagemIMC.setImageDrawable(
                ContextCompat.getDrawable(this, idImagem)
        )
    }
}
