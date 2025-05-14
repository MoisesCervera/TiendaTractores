package com.example.tiendatractores

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registro_usuario)   //Usa el layout de registro_usuario.xml



        //Ir a la activity de Iniciar sesion
        val btnEtiInicSes = findViewById<TextView>(R.id.eti_inic_ses)

        btnEtiInicSes.setOnClickListener{
            goToInicSes()


        }


        /*
        //Ir a la activity de Registro usuario direccion
        val btnFlecha = findViewById<ImageView>(R.id.btn_flecha)

        btnFlecha.setOnClickListener{
            goToRegDirecc()


        }
    */

        //Validacion campos vacios

        val caja_correo: EditText = findViewById(R.id.caja_correo)
        val caja_nombres: EditText = findViewById(R.id.caja_nombres)
        val caja_apelPat: EditText = findViewById(R.id.caja_apelPat)
        val caja_apelMat: EditText = findViewById(R.id.caja_apelMat)
        val caja_psswrd: EditText = findViewById(R.id.caja_psswrd)
        val caja_psswrdR: EditText = findViewById(R.id.caja_psswrdR)
        val nextButton: Button = findViewById(R.id.btn_registrarse)

        nextButton.setOnClickListener {
            if (validateFields(caja_correo, caja_nombres,caja_apelPat,caja_apelMat,caja_psswrd,caja_psswrdR)) {
                val irAInicSes = Intent(this, MainActivityLogin::class.java)
                startActivity(irAInicSes)
            }
        }



    }

    private fun goToInicSes(){
        val irAInicSes = Intent(this, MainActivityLogin::class.java)
        startActivity(irAInicSes)
    }

    private fun goToRegDirecc(){
        val irAregDirecc = Intent(this, RegisterActivityDrcc::class.java)
        startActivity(irAregDirecc)
    }

    private fun validateFields(vararg fields: EditText): Boolean {
        var allFieldsValid = true

        for (field in fields) {
            if (field.text.toString().trim().isEmpty()) {
                field.error = "Este campo es obligatorio"
                allFieldsValid = false
            } else {
                field.error = null
            }
        }

        return allFieldsValid
    }
}