package com.example.tiendatractores

import com.example.Product

class Carrito {


    object CarritoVer{
        var carrito = ArrayList<Product>()
         fun obtenerProductos(): ArrayList<Product> {
            return carrito;
        }

        fun eliminarProducto(index : Int) {

            carrito.removeAt(index)
        }
    }



}