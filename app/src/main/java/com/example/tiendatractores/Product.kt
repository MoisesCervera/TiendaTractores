package com.example

import java.io.Serializable

class Product(
    var nombre: String,
    var precio: Double,
    var modelo: String,
    var marca: String,
    var descripcion: String,
    var urlImagen: String
) : Serializable
