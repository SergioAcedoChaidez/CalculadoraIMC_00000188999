package acedo.chaidez.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etPeso = findViewById<EditText>(R.id.etPeso)
        val etEstatura = findViewById<EditText>(R.id.etEstatura)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        //evento button o cliclistener
        btnCalcular.setOnClickListener {

            val peso = etPeso.text.toString().toDouble()
            val estatura = etEstatura.text.toString().toDouble()
            val IMC = (peso/(estatura* estatura))
            tvResultado.text = IMC.toString()
            tvEstado(IMC)


            }
    }
    //Funcion para asignar el estado
    fun tvEstado(tvResultado:Double):String {
        val tvEstado = findViewById<TextView>(R.id.tvEstado)
        if(tvResultado < 18.5 )
            tvEstado.text = "Bajo peso"
        else if (tvResultado >= 18.5 && tvResultado < 25)
            tvEstado.text = "Normal"
        else if (tvResultado >= 25 && tvResultado <30)
            tvEstado.text = "Sobrepeso"
        else if (tvResultado >= 30 && tvResultado <35)
            tvEstado.text = "Obesidad Grado 1"
        else if (tvResultado >= 35 && tvResultado <40)
            tvEstado.text = "Obesidad Grado 2"
        else if (tvResultado >= 40)
            tvEstado.text = "Obesidad Grado 3"
        return tvEstado.toString()

    }
}



