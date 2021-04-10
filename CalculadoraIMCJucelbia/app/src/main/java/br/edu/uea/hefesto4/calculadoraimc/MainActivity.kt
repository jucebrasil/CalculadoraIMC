package br.edu.uea.hefesto4.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var editTextPeso: EditText? = null
    private var editTextAltura: EditText? = null
    private var textIMC: TextView? = null
    private var textResultado: TextView? = null
    private var btnCalc: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcular(v: View?) {

        val editTextPeso = findViewById<View>(R.id.editTextPeso) as EditText
        val editTextAltura = findViewById<View>(R.id.editTextAltura) as EditText
        val textIMC = findViewById<View>(R.id.textIMC) as TextView
        val textResultado = findViewById<View>(R.id.textResultado) as TextView


        val peso = editTextPeso.text.toString().toFloat()
        val altura = editTextAltura.text.toString().toFloat()
        val imc = textIMC.text.toString().toFloat()

        val resultado = peso / (altura * altura)
        if (resultado < 19) {
            //abaixo
            textResultado.text = "Abaixo do peso!"
        } else if (resultado > 32) {
            //obeso
            textResultado.text = "Acima do peso!"
        } else {
            //ok
            textResultado.text = "Peso ok!"
        }

    }
}