package com.example.tiendatractores

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityLogin : AppCompatActivity() {
// test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_login) //Usa el layout de activity_main.xml



        //Ir a la activity de Registrarse
        val btnEtiReg = findViewById<TextView>(R.id.eti_regist)

        btnEtiReg.setOnClickListener{
            goToRegister()
        }


        /*
        //Ir a la activity de catalogo
        val btnInicSes = findViewById<Button>(R.id.btn_login)

        btnInicSes.setOnClickListener{
            goToCatalog()
        }

         */

        //Ir a la activity de contacto
        val btnEtiContac = findViewById<TextView>(R.id.eti_contacto)

        btnEtiContac.setOnClickListener{
            goToContact()
        }


        //Validacion campos vacios

        val cajaUsername: EditText = findViewById(R.id.caja_username)
        val cajaPassword: EditText = findViewById(R.id.caja_psswrd)
        val submitButton: Button = findViewById(R.id.btn_login)

        submitButton.setOnClickListener {
            if (validateFields(cajaUsername, cajaPassword)) {

                Toast.makeText(this, "Sesion iniciada", Toast.LENGTH_SHORT).show()
                goToCatalog()
            }
        }



    }



    private fun goToRegister(){
        val irAReg = Intent(this, RegisterActivity::class.java)
        startActivity(irAReg)
    }

    private fun goToCatalog(){
        val irACat = Intent(this, MainActivityCatalogo::class.java)
        startActivity(irACat)
    }

    private fun goToContact(){
        val irACont = Intent(this, MainActivityContacto::class.java)
        startActivity(irACont)
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