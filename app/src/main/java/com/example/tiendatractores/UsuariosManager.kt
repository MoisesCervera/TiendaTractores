package com.example.tiendatractores

object UsuariosManager {
    
    // Lista estática de usuarios registrados
    private val usuariosRegistrados = mutableListOf<Usuario>(
        Usuario(
            email = "admin@tractores.com",
            nombres = "Juan Carlos",
            apellidoPaterno = "García",
            apellidoMaterno = "López",
            password = "admin123"
        ),
        Usuario(
            email = "maria@prueba.com",
            nombres = "María Elena",
            apellidoPaterno = "Rodríguez",
            apellidoMaterno = "Martínez",
            password = "maria456"
        ),
        Usuario(
            email = "pedro@test.com",
            nombres = "Pedro",
            apellidoPaterno = "Sánchez",
            apellidoMaterno = "Herrera",
            password = "pedro789"
        )
    )
    
    // Método para registrar un nuevo usuario
    fun registrarUsuario(usuario: Usuario): Boolean {
        // Verificar si el email ya existe
        if (emailYaExiste(usuario.email)) {
            return false
        }
        
        usuariosRegistrados.add(usuario)
        return true
    }
    
    // Método para verificar si un email ya está registrado
    fun emailYaExiste(email: String): Boolean {
        return usuariosRegistrados.any { it.email.lowercase() == email.lowercase() }
    }
    
    // Método para autenticar usuario (para login)
    fun autenticarUsuario(email: String, password: String): Usuario? {
        return usuariosRegistrados.find { 
            it.email.lowercase() == email.lowercase() && it.verificarPassword(password) 
        }
    }
    
    // Método para obtener todos los usuarios (para debugging)
    fun obtenerTodosLosUsuarios(): List<Usuario> {
        return usuariosRegistrados.toList()
    }
    
    // Método para obtener usuario por email
    fun obtenerUsuarioPorEmail(email: String): Usuario? {
        return usuariosRegistrados.find { it.email.lowercase() == email.lowercase() }
    }
}