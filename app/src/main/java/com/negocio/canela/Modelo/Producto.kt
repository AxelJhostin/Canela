package com.negocio.canela.Modelo

import com.negocio.canela.R

/**
 * Representa un producto disponible para la venta en la aplicación.
 * @param id Identificador único del producto.
 * @param producto Nombre del producto.
 * @param detalle Descripción del producto.
 * @param costo Precio del producto.
 * @param imagen ID del recurso de imagen (R.drawable).
 */
data class Producto(
    val id: String = "",
    var producto: String = "",
    var detalle: String = "",
    var costo: Double = 0.0,
    var imagen: Int = R.drawable.postre // Ahora acepta directamente un recurso de imagen
)

/**
 * Lista de productos disponibles en la aplicación.
 */
val listaProductos = listOf(
    Producto(
        id = "1",
        producto = "Pastel de Chocolate",
        detalle = "Delicioso pastel de chocolate con cobertura de ganache.",
        costo = 15.50,
        imagen = R.drawable.postre
    ),
    Producto(
        id = "2",
        producto = "Cheesecake de Fresa",
        detalle = "Suave cheesecake con base de galleta y fresas frescas.",
        costo = 18.00,
        imagen = R.drawable.chess
    ),
    Producto(
        id = "3",
        producto = "Brownies Clásicos",
        detalle = "Brownies de chocolate con nueces y textura fudgy.",
        costo = 12.00,
        imagen = R.drawable.cupcakes
    ),
    Producto(
        id = "4",
        producto = "Tiramisú Italiano",
        detalle = "Postre italiano con capas de mascarpone y café.",
        costo = 20.00,
        imagen = R.drawable.cupcakes2
    ),
    Producto(
        id = "5",
        producto = "Macarons Franceses",
        detalle = "Dulces franceses en varios sabores: vainilla, frambuesa y chocolate.",
        costo = 10.00,
        imagen = R.drawable.cupcakes
    ),
    Producto(
        id = "6",
        producto = "Donas Glaseadas",
        detalle = "Donas frescas con cobertura de azúcar glaseada.",
        costo = 8.50,
        imagen = R.drawable.postre
    ),
    Producto(
        id = "7",
        producto = "Galletas ChocoChip",
        detalle = "Galletas crujientes con chispas de chocolate.",
        costo = 6.00,
        imagen = R.drawable.chess
    ),
    Producto(
        id = "8",
        producto = "Flan Napolitano",
        detalle = "Postre cremoso con caramelo y textura suave.",
        costo = 9.00,
        imagen = R.drawable.chess
    ),
    Producto(
        id = "9",
        producto = "Churros con Chocolate",
        detalle = "Churros crujientes con chocolate caliente.",
        costo = 11.00,
        imagen = R.drawable.postre
    ),
    Producto(
        id = "10",
        producto = "Tres Leches",
        detalle = "Pastel húmedo bañado en tres tipos de leche.",
        costo = 14.00,
        imagen = R.drawable.cupcakes2
    ),
    Producto(
        id = "11",
        producto = "Muffins de Arándanos",
        detalle = "Muffins esponjosos con arándanos frescos.",
        costo = 7.50,
        imagen = R.drawable.cupcakes
    ),
    Producto(
        id = "12",
        producto = "Pie de Limón",
        detalle = "Tarta de limón con base de galleta y merengue.",
        costo = 13.50,
        imagen = R.drawable.postre
    ),
    Producto(
        id = "13",
        producto = "Rollos de Canela",
        detalle = "Rollos suaves con canela y glaseado dulce.",
        costo = 10.50,
        imagen = R.drawable.chess
    ),
    Producto(
        id = "14",
        producto = "Helado Artesanal",
        detalle = "Helado casero en sabores de vainilla, chocolate y fresa.",
        costo = 6.50,
        imagen = R.drawable.chess
    ),
    Producto(
        id = "15",
        producto = "Pavlova de Frutas",
        detalle = "Postre crujiente con crema y frutas frescas.",
        costo = 17.00,
        imagen = R.drawable.postre
    ),
    Producto(
        id = "16",
        producto = "Tarta de Manzana",
        detalle = "Tarta casera con manzanas caramelizadas y canela.",
        costo = 16.00,
        imagen = R.drawable.cupcakes
    ),
    Producto(
        id = "17",
        producto = "Cupcakes Variados",
        detalle = "Cupcakes de chocolate, vainilla y red velvet.",
        costo = 9.50,
        imagen = R.drawable.cupcakes
    ),
    Producto(
        id = "18",
        producto = "Profiteroles con Crema",
        detalle = "Profiteroles rellenos de crema pastelera y chocolate.",
        costo = 14.50,
        imagen = R.drawable.chess
    ),
    Producto(
        id = "19",
        producto = "Mousse de Maracuyá",
        detalle = "Mousse suave con sabor tropical a maracuyá.",
        costo = 15.00,
        imagen = R.drawable.postre
    ),
    Producto(
        id = "20",
        producto = "Alfajores de Dulce de Leche",
        detalle = "Galletas rellenas de dulce de leche con coco rallado.",
        costo = 8.00,
        imagen = R.drawable.cupcakes2
    )
)
