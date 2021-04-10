package br.edu.uea.hefesto4.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var textResultado: TextView
    private lateinit var textImcResultado: TextView
    private lateinit var btnCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextPeso = findViewById(R.id.editTextPeso)
        editTextAltura = findViewById(R.id.editTextAltura)
        textResultado = findViewById(R.id.textResultado)
        textImcResultado = findViewById(R.id.txvImcResult)
        btnCalc = findViewById(R.id.btnCalc)
        btnCalc.setOnClickListener { calculate() }
    }

    private fun calculate() {
        val peso = editTextPeso.text.toString().toFloat()
        val altura = editTextAltura.text.toString().toFloat()

        val resultado = peso / (altura * altura)

        val nf = NumberFormat.getNumberInstance()
        nf.maximumFractionDigits = 1
        val nr = nf.format(resultado)

        textImcResultado.text = nr

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