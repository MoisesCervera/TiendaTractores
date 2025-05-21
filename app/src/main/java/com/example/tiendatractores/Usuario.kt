package com.example.tiendatractores

data class Usuario(
    val email: String,
    val nombres: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val password: String
) {
    // Método para obtener el nombre completo
    fun getNombreCompleto(): String {
        return "$nombres $apellidoPaterno $apellidoMaterno"
    }
    
    // Método para verificar contraseña
    fun verificarPassword(password: String): Boolean {
        return this.password == password
    }
}