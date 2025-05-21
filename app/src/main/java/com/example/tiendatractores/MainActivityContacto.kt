package com.example.tiendatractores

import android.content.Intent

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.EditorInfo
import androidx.core.net.toUri
import android.net.Uri

class MainActivityContacto : AppCompatActivity() {

    // Referencias a los elementos del formulario
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etMessage: EditText
    private lateinit var btnSendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contacto)

        // Inicialización de las vistas
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etMessage = findViewById(R.id.etMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)

        // Listener para el botón de enviar
        btnSendMessage.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val email = etEmail.text.toString()
            val message = etMessage.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && message.isNotEmpty()) {
                Toast.makeText(this, "Mensaje enviado exitosamente!", Toast.LENGTH_LONG).show()
                clearFields()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_LONG).show()
            }
        }

        // Listener para ocultar el teclado al presionar "Done"
        etMessage.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                closeKeyboard()
                etMessage.clearFocus()
                true
            } else {
                false
            }
        }
    }

    // Métodos para abrir redes sociales
    fun btnInsta(view: View) {
        val url = "https://www.instagram.com/apptractor2025?igsh=MTB6OHhxYWY2OXB2aw%3D%3D&utm_source=qr"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }


    fun btnFace(view: View) {
        val url = "https://www.facebook.com/share/1AN5K4BPJZ/?mibextid=wwXIfr"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }






    // Método optimizado para abrir URLs
    private fun openURL(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        startActivity(intent)
    }

    // Método para ocultar el teclado
    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // Método para limpiar los campos del formulario
    private fun clearFields() {
        etFirstName.text.clear()
        etLastName.text.clear()
        etEmail.text.clear()
        etMessage.text.clear()
    }
}
