package com.negocio.canela.Modelo

import java.util.Date

/**
 * Representa un pedido realizado por un usuario.
 * @param id Identificador único del pedido (no cambia).
 * @param idUsuario ID del usuario que realizó el pedido (no cambia).
 * @param listaProductos Lista de productos dentro del pedido (puede cambiar).
 * @param estado Estado del pedido (puede cambiar: "Por atender", "En proceso", "Entregado", etc.).
 * @param fechaPedido Fecha en la que se realizó el pedido (se mantiene fija, por compatibilidad con Firebase es un String).
 * @param costoTotal Costo total del pedido (puede cambiar si se agregan productos).
 * @param direccionPedido Dirección donde debe entregarse el pedido (puede cambiar).
 */
data class Pedido(
    val id: String = "",
    val idUsuario: String = "",
    var listaProductos: List<Producto> = emptyList(), // Puede actualizarse
    var estado: String = "Por atender", // Puede cambiar según el estado del pedido
    val fechaPedido: String = "", // Se mantiene fija
    var costoTotal: Double = 0.0, // Puede cambiar si el pedido se modifica
    var direccionPedido: String = "" // Puede actualizarse
)