package com.example.tiendatractores
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Product
import com.example.tiendatractores.R

class ProductoDetalle : AppCompatActivity() {
    var carrito = Carrito.CarritoVer.obtenerProductos()
    private var variable: Boolean = true

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)
        val intent = intent
        val nombre = intent.getStringExtra("nombre")
        val modelo = intent.getStringExtra("modelo")
        val marca = intent.getStringExtra("marca")
        val descripcion = intent.getStringExtra("descripcion")
        val precio = intent.getStringExtra("precio")
        val urlImagen = intent.getStringExtra("urlImagen")
        val producto = Product(nombre.toString().toString(), precio!!.toDouble(),
            modelo.toString(), marca.toString(), descripcion.toString(), urlImagen.toString()
        )

        val imageViewProduct1: ImageView = findViewById(R.id.imageViewProduct1)
        val textViewProductName1: TextView = findViewById(R.id.textViewProductName1)
        val textViewModel1: TextView = findViewById(R.id.textViewModel1)
        val textViewBrand1: TextView = findViewById(R.id.textViewBrand1)
        val textViewDescription1: TextView = findViewById(R.id.textViewDescription1)
        val textViewPrice1: TextView = findViewById(R.id.textViewPrice1)

        val imageView: ImageView = findViewById(R.id.imageViewProduct1)
        textViewProductName1.text = nombre
        textViewModel1.text = modelo
        textViewBrand1.text = marca
        textViewDescription1.text = descripcion
        textViewPrice1.text = precio

        when (urlImagen) {
            "1" -> imageView.setImageResource(R.drawable.tractor_rojo1)
            "2" -> imageView.setImageResource(R.drawable.tractor_verde2)
            "3" -> imageView.setImageResource(R.drawable.tractor_azul3)
            "4" -> imageView.setImageResource(R.drawable.tractor_4)
            "5" -> imageView.setImageResource(R.drawable.tractor_5)
            "6" -> imageView.setImageResource(R.drawable.tractor_6)
            "7" -> imageView.setImageResource(R.drawable.tractor_7)
            "8" -> imageView.setImageResource(R.drawable.tractor_8)
            "9" -> imageView.setImageResource(R.drawable.tractor_9)
            "10" -> imageView.setImageResource(R.drawable.tractor_10)
            "11" -> imageView.setImageResource(R.drawable.tractor_11)
            "12" -> imageView.setImageResource(R.drawable.tractor_12)
            "13" -> imageView.setImageResource(R.drawable.tractor_13)
        }

        // Configurar el OnClickListener para el botón "Agregar al Carrito"
        val buttonAddToCart: Button = findViewById(R.id.buttonAddToCart)
        buttonAddToCart.setOnClickListener {
            variable = false
            agregarAlCarrito(producto)
        }

        val btnRegresar: Button = findViewById(R.id.regresar)
        btnRegresar.setOnClickListener {
            val intent = Intent(this@ProductoDetalle, MainActivityCatalogo::class.java)
            println("Hola")
            if (variable == false || carrito.isNotEmpty()) {
                intent.putExtra("carro_compras", carrito)
                startActivity(intent)
            } else {
                intent.putExtra("nombre", 2)
                startActivity(intent)
            }
        }
    }

    private fun agregarAlCarrito(producto: Product) {
        carrito.add(producto)
        Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
    }


}
