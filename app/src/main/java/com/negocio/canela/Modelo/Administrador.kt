package com.negocio.canela.Modelo

/**
 * Representa un administrador con permisos especiales en la aplicación.
 * @param id Identificador único del administrador.
 * @param nombre Nombre del administrador (puede cambiar).
 * @param apellido Apellido del administrador (puede cambiar).
 * @param cedula Número de cédula (fijo en la mayoría de casos).
 * @param celular Número de contacto (puede cambiar).
 * @param email Correo electrónico (puede cambiar).
 * @param contrasenia Contraseña (puede cambiar).
 */
data class Administrador(
    val id: String = "",
    var nombre: String = "",
    var apellido: String = "",
    val cedula: String = "", // Suele ser fija
    var celular: String = "",
    var email: String = "",
    var contrasenia: String = ""
)