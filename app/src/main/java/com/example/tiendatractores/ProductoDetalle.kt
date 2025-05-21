package com.example.tiendatractores

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Product
import com.example.tiendatractores.databinding.ActivityDetalleProductoBinding

class ProductoDetalle : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleProductoBinding
    private val carrito = Carrito.CarritoVer.obtenerProductos()
    private var productoAgregado = false

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalleProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val producto = intent.extras?.let {
            Product(
                nombre = it.getString("nombre").orEmpty(),
                precio = it.getString("precio")?.toDoubleOrNull() ?: 0.0,
                modelo = it.getString("modelo").orEmpty(),
                marca = it.getString("marca").orEmpty(),
                descripcion = it.getString("descripcion").orEmpty(),
                urlImagen = it.getString("urlImagen").orEmpty()
            )
        } ?: run {
            finish()
            return
        }

        distribucionGUI(producto)
        establecerListeners(producto)
    }

    private fun distribucionGUI(producto: Product) {
        with(binding) {
            textoProductoNombre.text = producto.nombre
            textoProductoModelo.text = producto.modelo
            textoProductoMarca.text = producto.marca
            textoProductoDescripcion.text = producto.descripcion
            textoProductoPrecio.text = "$${producto.precio}"

            val imageRes = when (producto.urlImagen) {
                "1" -> R.drawable.tractor_rojo1
                "2" -> R.drawable.tractor_verde2
                "3" -> R.drawable.tractor_azul3
                "4" -> R.drawable.tractor_4
                "5" -> R.drawable.tractor_5
                "6" -> R.drawable.tractor_6
                "7" -> R.drawable.tractor_7
                "8" -> R.drawable.tractor_8
                "9" -> R.drawable.tractor_9
                "10" -> R.drawable.tractor_10
                "11" -> R.drawable.tractor_11
                "12" -> R.drawable.tractor_12
                "13" -> R.drawable.tractor_13
                else -> R.drawable.logotrac
            }
            imagenProducto.setImageResource(imageRes)
        }
    }

    private fun establecerListeners(producto: Product) {
        binding.botonAgregarAlCarrito.setOnClickListener {
            productoAgregado = true
            agregarAlCarrito(producto)
        }

        binding.botonRegresar.setOnClickListener {
            val intent = Intent(this, MainActivityCatalogo::class.java).apply {
                if (productoAgregado || carrito.isNotEmpty()) {
                    putExtra("carro_compras", ArrayList(carrito))
                } else {
                    putExtra("nombre", 2)
                }
            }
            startActivity(intent)
        }


        binding.botonIrACarrito.setOnClickListener {
            val intent = Intent(this@ProductoDetalle, CarroComprasActivity::class.java)
            startActivity(intent)
        }
    }

    private fun agregarAlCarrito(producto: Product) {
        carrito.add(producto)
        Toast.makeText(this, "Modelo ${producto.modelo} agregado al carrito", Toast.LENGTH_SHORT).show()
    }
}