package com.example.tiendatractores

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    // Regex para validar email
    private val emailPattern = Pattern.compile(
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registro_usuario)

        setupViews()
    }

    private fun setupViews() {
        // Referencias a los campos
        val tilEmail = findViewById<TextInputLayout>(R.id.til_email)
        val tilNombres = findViewById<TextInputLayout>(R.id.til_names)
        val tilApellidoPaterno = findViewById<TextInputLayout>(R.id.til_lastname1)
        val tilApellidoMaterno = findViewById<TextInputLayout>(R.id.til_lastname2)
        val tilPassword = findViewById<TextInputLayout>(R.id.til_password)
        val tilConfirmPassword = findViewById<TextInputLayout>(R.id.til_confirm_password)

        val etEmail = findViewById<TextInputEditText>(R.id.caja_correo)
        val etNombres = findViewById<TextInputEditText>(R.id.caja_nombres)
        val etApellidoPaterno = findViewById<TextInputEditText>(R.id.caja_apelPat)
        val etApellidoMaterno = findViewById<TextInputEditText>(R.id.caja_apelMat)
        val etPassword = findViewById<TextInputEditText>(R.id.caja_psswrd)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.caja_psswrdR)

        val chkTerms = findViewById<CheckBox>(R.id.chk_terms)
        val btnRegistrarse = findViewById<Button>(R.id.btn_registrarse)
        val btnIniciarSesion = findViewById<TextView>(R.id.eti_inic_ses)

        // Configurar listeners
        btnRegistrarse.setOnClickListener {
            if (validateAndRegister(
                    tilEmail, tilNombres, tilApellidoPaterno, tilApellidoMaterno,
                    tilPassword, tilConfirmPassword,
                    etEmail, etNombres, etApellidoPaterno, etApellidoMaterno,
                    etPassword, etConfirmPassword,
                    chkTerms
                )) {
                // Registro exitoso
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                goToLogin()
            }
        }

        btnIniciarSesion.setOnClickListener {
            goToLogin()
        }
    }

    private fun validateAndRegister(
        tilEmail: TextInputLayout, tilNombres: TextInputLayout,
        tilApellidoPaterno: TextInputLayout, tilApellidoMaterno: TextInputLayout,
        tilPassword: TextInputLayout, tilConfirmPassword: TextInputLayout,
        etEmail: TextInputEditText, etNombres: TextInputEditText,
        etApellidoPaterno: TextInputEditText, etApellidoMaterno: TextInputEditText,
        etPassword: TextInputEditText, etConfirmPassword: TextInputEditText,
        chkTerms: CheckBox
    ): Boolean {

        var isValid = true

        // Obtener valores
        val email = etEmail.text.toString().trim()
        val nombres = etNombres.text.toString().trim()
        val apellidoPaterno = etApellidoPaterno.text.toString().trim()
        val apellidoMaterno = etApellidoMaterno.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        // Limpiar errores previos
        clearErrors(tilEmail, tilNombres, tilApellidoPaterno, tilApellidoMaterno, tilPassword, tilConfirmPassword)

        // Validar email
        if (email.isEmpty()) {
            tilEmail.error = "El correo electrónico es obligatorio"
            isValid = false
        } else if (!emailPattern.matcher(email).matches()) {
            tilEmail.error = "Ingrese un correo electrónico válido"
            isValid = false
        } else if (UsuariosManager.emailYaExiste(email)) {
            tilEmail.error = "Este correo ya está registrado"
            isValid = false
        }

        // Validar nombres
        if (nombres.isEmpty()) {
            tilNombres.error = "El nombre es obligatorio"
            isValid = false
        } else if (nombres.length < 2) {
            tilNombres.error = "El nombre debe tener al menos 2 caracteres"
            isValid = false
        }

        // Validar apellido paterno
        if (apellidoPaterno.isEmpty()) {
            tilApellidoPaterno.error = "El apellido paterno es obligatorio"
            isValid = false
        } else if (apellidoPaterno.length < 2) {
            tilApellidoPaterno.error = "El apellido debe tener al menos 2 caracteres"
            isValid = false
        }

        // Validar apellido materno
        if (apellidoMaterno.isEmpty()) {
            tilApellidoMaterno.error = "El apellido materno es obligatorio"
            isValid = false
        } else if (apellidoMaterno.length < 2) {
            tilApellidoMaterno.error = "El apellido debe tener al menos 2 caracteres"
            isValid = false
        }

        // Validar contraseña
        if (password.isEmpty()) {
            tilPassword.error = "La contraseña es obligatoria"
            isValid = false
        } else if (password.length < 6) {
            tilPassword.error = "La contraseña debe tener al menos 6 caracteres"
            isValid = false
        }

        // Validar confirmación de contraseña
        if (confirmPassword.isEmpty()) {
            tilConfirmPassword.error = "Debe confirmar la contraseña"
            isValid = false
        } else if (password != confirmPassword) {
            tilConfirmPassword.error = "Las contraseñas no coinciden"
            isValid = false
        }

        // Validar términos y condiciones
        if (!chkTerms.isChecked) {
            Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        // Si todas las validaciones pasan, registrar usuario
        if (isValid) {
            val nuevoUsuario = Usuario(
                email = email,
                nombres = nombres,
                apellidoPaterno = apellidoPaterno,
                apellidoMaterno = apellidoMaterno,
                password = password
            )

            if (!UsuariosManager.registrarUsuario(nuevoUsuario)) {
                Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                return false
            }
        }

        return isValid
    }

    private fun clearErrors(vararg textInputLayouts: TextInputLayout) {
        textInputLayouts.forEach { it.error = null }
    }

    private fun goToLogin() {
        val intent = Intent(this, MainActivityLogin::class.java)
        startActivity(intent)
        finish() // Opcional: cerrar la actividad actual
    }
}