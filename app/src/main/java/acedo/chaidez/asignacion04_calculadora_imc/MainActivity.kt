package acedo.chaidez.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //VARIABLES
    val peso = findViewById<EditText>(R.id.etPeso)
    val estatura = findViewById<EditText>(R.id.etEstatura)
    val calculatebutton = findViewById<Button>(R.id.btnCalcular)
    val Imc = findViewById<TextView>(R.id.tvIMC)
    val Rango = findViewById<TextView>(R.id.tvRange)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //evento boton
        calculatebutton.setOnClickListener() {

            var weightValue = 0.0
            var heightValue = 0.0
            if (peso.text.toString().isNotEmpty()) {
                weightValue = peso.text.toString().toDouble()

            }
            if (estatura.text.toString().isNotEmpty()) {
                heightValue = estatura.text.toString().toDouble()
            }
            val bmiValue = String().format(".2f", weightValue / heightValue.pow(2))

            Imc.text = bmiValue
            Rango.text = bmiStatusValue(weightValue / heightValue.pow(2))

        }

    }

    private fun bmiStatusValue(bmi: Double): String {
        lateinit var bmiStatus: String
        if (bmi < 18.5)
            bmiStatus = "Bajo peso"
        else if (bmi >= 18.5 && bmi < 25)
            bmiStatus = "Normal"
        else if (bmi >= 25 && bmi < 30)
            bmiStatus = "Sobrepeso"
        else if (bmi >= 30 && bmi < 34.9)
            bmiStatus = "Obesidad grado 1"
        else if (bmi >= 35 && bmi < 39.9)
            bmiStatus = "Obesidad grado 2"
        else if (bmi > 40)
            bmiStatus = "Obesidad grado 3"

        return  bmiStatus
    }
}

