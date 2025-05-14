package com.example.tiendatractores

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivityDrcc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_drcc) //Usa el layout de activity_register_drcc.xml


        //Ir a la activity de Iniciar sesion
        val btnEtiInicSes = findViewById<TextView>(R.id.eti_inic_ses)

        btnEtiInicSes.setOnClickListener{
            goToInicSes()


        }

        /*
        //Ir a la activity de catalogo
        val btnregistrarse = findViewById<Button>(R.id.btn_registrarse)

        btnregistrarse.setOnClickListener{
            goToCatalog()
        }
        */

        //Validacion campos vacios

        val caja_calle: EditText = findViewById(R.id.caja_calle)
        val caja_numExt: EditText = findViewById(R.id.caja_numExt)
        val caja_numInt: EditText = findViewById(R.id.caja_numInt)
        val caja_estado: EditText = findViewById(R.id.caja_estado)
        val caja_pais: EditText = findViewById(R.id.caja_pais)
        val caja_colonia: EditText = findViewById(R.id.caja_colonia)
        val caja_cp: EditText = findViewById(R.id.caja_cp)
        val caja_telefono: EditText = findViewById(R.id.caja_telefono)
        val btn_registrarse: Button = findViewById(R.id.btn_registrarse)

        btn_registrarse.setOnClickListener {
            if (validateFields(caja_calle, caja_numExt,caja_numInt,caja_estado,caja_pais,caja_colonia,caja_cp,caja_telefono)) {

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                goToCatalog()
            }
        }


    }

    private fun goToInicSes(){
        val irAInicSes = Intent(this, MainActivityLogin::class.java)
        startActivity(irAInicSes)
    }

    private fun goToCatalog(){
        val irACat = Intent(this, MainActivityCatalogo::class.java)
        startActivity(irACat)
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