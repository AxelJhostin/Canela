package com.negocio.canela.Modelo

/**
 * Representa un usuario normal en la aplicación.
 * @param id Identificador único del usuario (no cambia).
 * @param nombre Nombre del usuario (puede cambiar).
 * @param apellido Apellido del usuario (puede cambiar).
 * @param email Correo electrónico del usuario (puede cambiar).
 * @param contrasenia Contraseña del usuario (puede cambiar).
 * @param cedula Número de cédula del usuario (normalmente no cambia).
 * @param celular Número de contacto del usuario (puede cambiar).
 * @param fotoUsuario URL de la imagen de perfil del usuario (puede cambiar).
 */
data class Usuario(
    val id: String = "", // No debe cambiar
    var nombre: String = "",
    var apellido: String = "",
    var email: String = "",
    var contrasenia: String = "",
    val cedula: String = "", // En muchos casos, la cédula es fija
    var celular: String = "",
    var fotoUsuario: String = ""
)