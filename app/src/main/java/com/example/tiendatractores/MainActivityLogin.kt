package com.example.tiendatractores

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class MainActivityLogin : AppCompatActivity() {

    // Regex para validar email
    private val emailPattern = Pattern.compile(
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    )

    // SharedPreferences para "Recordarme"
    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "TractoresLoginPrefs"
    private val PREF_EMAIL = "remembered_email"
    private val PREF_REMEMBER = "remember_me"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_login)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)

        setupViews()
        loadRememberedCredentials()
    }

    private fun setupViews() {
        // Referencias a los campos
        val tilEmail = findViewById<TextInputLayout>(R.id.til_email)
        val tilPassword = findViewById<TextInputLayout>(R.id.til_password)
        val etEmail = findViewById<TextInputEditText>(R.id.caja_username)
        val etPassword = findViewById<TextInputEditText>(R.id.caja_psswrd)
        val chkRemember = findViewById<CheckBox>(R.id.chk_remember)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegistrar = findViewById<TextView>(R.id.eti_regist)
        val btnContacto = findViewById<TextView>(R.id.eti_contacto)

        // Configurar listeners
        btnLogin.setOnClickListener {
            if (validateAndLogin(tilEmail, tilPassword, etEmail, etPassword, chkRemember)) {
                saveRememberCredentials(etEmail.text.toString(), chkRemember.isChecked)
                goToCatalog()
            }
        }

        btnRegistrar.setOnClickListener {
            goToRegister()
        }

        btnContacto.setOnClickListener {
            goToContact()
        }
    }

    private fun validateAndLogin(
        tilEmail: TextInputLayout,
        tilPassword: TextInputLayout,
        etEmail: TextInputEditText,
        etPassword: TextInputEditText,
        chkRemember: CheckBox
    ): Boolean {

        var isValid = true

        // Obtener valores
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()

        // Limpiar errores previos
        tilEmail.error = null
        tilPassword.error = null

        // Validar email
        if (email.isEmpty()) {
            tilEmail.error = "El correo electrónico es obligatorio"
            isValid = false
        } else if (!emailPattern.matcher(email).matches()) {
            tilEmail.error = "Ingrese un correo electrónico válido"
            isValid = false
        }

        // Validar contraseña
        if (password.isEmpty()) {
            tilPassword.error = "La contraseña es obligatoria"
            isValid = false
        }

        // Si las validaciones básicas pasan, intentar autenticar
        if (isValid) {
            val usuario = UsuariosManager.autenticarUsuario(email, password)

            if (usuario != null) {
                // Login exitoso
                Toast.makeText(
                    this,
                    "¡Bienvenido, ${usuario.nombres}!",
                    Toast.LENGTH_SHORT
                ).show()

                // Guardar el usuario logueado para usar en otras actividades si es necesario
                saveCurrentUser(usuario)

                return true
            } else {
                // Verificar si el email existe pero la contraseña es incorrecta
                if (UsuariosManager.emailYaExiste(email)) {
                    tilPassword.error = "Contraseña incorrecta"
                    Toast.makeText(
                        this,
                        "Contraseña incorrecta. Intente nuevamente.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    tilEmail.error = "Este correo no está registrado"
                    Toast.makeText(
                        this,
                        "Usuario no encontrado. ¿Desea registrarse?",
                        Toast.LENGTH_LONG
                    ).show()
                }
                isValid = false
            }
        }

        return isValid
    }

    private fun loadRememberedCredentials() {
        val rememberedEmail = sharedPreferences.getString(PREF_EMAIL, "")
        val rememberMe = sharedPreferences.getBoolean(PREF_REMEMBER, false)

        if (rememberMe && !rememberedEmail.isNullOrEmpty()) {
            val etEmail = findViewById<TextInputEditText>(R.id.caja_username)
            val chkRemember = findViewById<CheckBox>(R.id.chk_remember)

            etEmail.setText(rememberedEmail)
            chkRemember.isChecked = true
        }
    }

    private fun saveRememberCredentials(email: String, remember: Boolean) {
        val editor = sharedPreferences.edit()

        if (remember) {
            editor.putString(PREF_EMAIL, email)
            editor.putBoolean(PREF_REMEMBER, true)
        } else {
            editor.remove(PREF_EMAIL)
            editor.putBoolean(PREF_REMEMBER, false)
        }

        editor.apply()
    }

    private fun saveCurrentUser(usuario: Usuario) {
        // Guardar información del usuario logueado para usar en otras actividades
        val editor = sharedPreferences.edit()
        editor.putString("current_user_email", usuario.email)
        editor.putString("current_user_name", usuario.getNombreCompleto())
        editor.apply()
    }

    private fun goToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun goToCatalog() {
        val intent = Intent(this, MainActivityCatalogo::class.java)
        startActivity(intent)
        // Opcional: finish() si no quieres que el usuario regrese al login con el botón atrás
        finish()
    }

    private fun goToContact() {
        val intent = Intent(this, MainActivityContacto::class.java)
        startActivity(intent)
    }

    // Método estático para obtener el usuario actual desde otras actividades
    companion object {
        fun getCurrentUserEmail(context: android.content.Context): String? {
            val prefs = context.getSharedPreferences("TractoresLoginPrefs", MODE_PRIVATE)
            return prefs.getString("current_user_email", null)
        }

        fun getCurrentUserName(context: android.content.Context): String? {
            val prefs = context.getSharedPreferences("TractoresLoginPrefs", MODE_PRIVATE)
            return prefs.getString("current_user_name", null)
        }

        fun logout(context: android.content.Context) {
            val prefs = context.getSharedPreferences("TractoresLoginPrefs", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.remove("current_user_email")
            editor.remove("current_user_name")
            editor.apply()
        }
    }
}