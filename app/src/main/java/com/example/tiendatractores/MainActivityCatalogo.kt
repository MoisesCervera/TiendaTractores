package com.example.tiendatractores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.Product
import com.example.tiendatractores.R

class MainActivityCatalogo: AppCompatActivity() {

    var listaProductos = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_catalogo)
        val producto1 = Product("Tractor Agrícola", 719.0, "TR285A", "MASSEY FERGUSSON", "Motor agrícola de 4,5L y 4 cilindros de 110hp.", "1")
        val producto2 = Product("Tractor Agrícola", 497.44, "TR2800B", "JOHN DEERE", "Ideal para trabajar en los espacios más reducidos de los invernaderos y cultivos", "2")
        val producto3 = Product("Tractor Agrícola", 562.43, "TR6780C", "NEW HOLLAND", "Cuentan con el mejor confort y cuidado para los huertos y viñedos anchos", "3")
        val producto4 = Product("Tractor Agrícola", 502.54, "TR1989D", "CASE", "Ideal para la preparación de suelo hasta la cosecha", "4")
        val producto5 = Product("Tractor Agrícola", 477.52, "TR2000E", "FENDT", "Se caracteriza por su durabilidad, flexibilidad y versatilidad para un óptimo desempeño", "5")
        val producto6 = Product("Tractor Agrícola", 1200.0, "TR1234F", "NEW HOLLAND", "Ofrece mayor potencia debajo de su cofre con diseño vanguardista y moderno completamente abatible", "6")
        val producto7 = Product("Tractor Agrícola", 471.36, "TR7788G", "ZOOMLION", "Ofrece a los agricultores mexicanos gran tecnología y confort al momento de su operación", "7")
        val producto8 = Product("Tractor Agrícola", 3001.39, "TR9900H", "NORTEZAC", "Ideal en cualquier aplicación, ya sea para sus propios campos, así como servicios de maquila", "8")
        val producto9 = Product("Tractor Agrícola", 533.95, "TR3456I", "JOHN DEERE", "Basado en un diseño completamente nuevo y adaptando los últimos avances en ingeniería", "9")
        val producto10 = Product("Tractor Agrícola", 144.82, "TR2789J", "VALTRA", "Ofrece tecnología y confort al momento de su operación, así como un aspecto moderno, atractivo y vistoso", "10")
        val producto11 = Product("Tractor Agrícola", 390.38, "TR2100K", "NEW HOLLAND", "ofrece potencia, tecnología y alto rendimiento asi como un inigualable confort", "11")
        val producto12 = Product("Tractor Agrícola", 865.36, "TR2001L", "MASSEY FERGUSON", "Dotado con potencia, velocidad, capacidad de elevación y fuerza de tracción excepcionales", "12")
        val producto13 = Product("Tractor Agrícola", 69.40, "TR1984M", "MASSEY FERGUSON", "Perfectos para pequeños agricultores o como tractores utilitarios", "13")

        val cartex1 = findViewById<LinearLayout>(R.id.cartex1)
        cartex1.setOnClickListener {
            navigateToProductoDetalle(producto1)
        }
        val cartex2 = findViewById<LinearLayout>(R.id.cartex2)
        cartex2.setOnClickListener {
            navigateToProductoDetalle(producto2)
        }
        val cartex3 = findViewById<LinearLayout>(R.id.cartex3)
        cartex3.setOnClickListener {
            navigateToProductoDetalle(producto3)
        }
        val cartex4 = findViewById<LinearLayout>(R.id.cartex4)
        cartex4.setOnClickListener {
            navigateToProductoDetalle(producto4)
        }
        val cartex5 = findViewById<LinearLayout>(R.id.cartex5)
        cartex5.setOnClickListener {
            navigateToProductoDetalle(producto5)
        }
        val cartex6 = findViewById<LinearLayout>(R.id.cartex6)
        cartex6.setOnClickListener {
            navigateToProductoDetalle(producto6)
        }
        val cartex7 = findViewById<LinearLayout>(R.id.cartex7)
        cartex7.setOnClickListener {
            navigateToProductoDetalle(producto7)
        }
        val cartex8 = findViewById<LinearLayout>(R.id.cartex8)
        cartex8.setOnClickListener {
            navigateToProductoDetalle(producto8)
        }
        val cartex9 = findViewById<LinearLayout>(R.id.cartex9)
        cartex9.setOnClickListener {
            navigateToProductoDetalle(producto9)
        }
        val cartex10 = findViewById<LinearLayout>(R.id.cartex10)
        cartex10.setOnClickListener {
            navigateToProductoDetalle(producto10)
        }
        val cartex11 = findViewById<LinearLayout>(R.id.cartex11)
        cartex11.setOnClickListener {
            navigateToProductoDetalle(producto11)
        }
        val cartex12 = findViewById<LinearLayout>(R.id.cartex12)
        cartex12.setOnClickListener {
            navigateToProductoDetalle(producto12)
        }
        val cartex13 = findViewById<LinearLayout>(R.id.cartex13)
        cartex13.setOnClickListener {
            navigateToProductoDetalle(producto13)
        }


        // Similarmente, define los listeners para los botones restantes btn3 hasta btn13.

        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarro)
        btnVerCarrito.setOnClickListener {
            val intent = Intent(this@MainActivityCatalogo, CarroComprasActivity::class.java)
            startActivity(intent)
        }
        agregarProductos()


        //Ir a la activity de contacto
        val btnEtiContac = findViewById<TextView>(R.id.eti_contacto)

        btnEtiContac.setOnClickListener{
            goToContact()
        }

    }


    private fun goToContact(){
        val irACont = Intent(this, MainActivityContacto::class.java)
        startActivity(irACont)
    }


    private fun navigateToProductoDetalle(producto: Product) {
        val intent = Intent(this@MainActivityCatalogo, ProductoDetalle::class.java)
        intent.putExtra("nombre", producto.nombre)
        intent.putExtra("modelo", producto.modelo)
        intent.putExtra("marca", producto.marca)
        intent.putExtra("descripcion", producto.descripcion)
        intent.putExtra("precio", producto.precio.toString())
        intent.putExtra("urlImagen", producto.urlImagen)
        startActivity(intent)
    }


    fun agregarProductos() {
        val producto1 = Product("AmercianFutBoll", 250.0, "AF500BJ", "KIPSTA", "Balón de fútbol americano niños color marrón", "1")
        val producto2 = Product("AmericanFutBoll", 250.0, "AF100B", "KIPSTA", "Balón de fútbol americano niños color negro", "2")
        val producto3 = Product("AmercianFutBoll", 280.0, "VOITPRO7", "VOIT", "Balón Futbol Americano Voit Pro No.7", "3")
        val producto4 = Product("AmercianFutBoll", 400.0, "WTF1895XB", "WILSON", "Balón americano Wilson No.7", "4")
        val producto5 = Product("Basquetbol", 500.0, "BKWNBL7", "WILSON", "Balón NBA DRV Pro Drip Wilson No.7", "5")
        val producto6 = Product("Basquetbol", 240.0, "BKSPLO7", "SPALDING", "Balón de Básquetbol Spalding No 7", "6")
        val producto7 = Product("Basquetbol", 150.0, "BKGLYJ6", "GOLTY", "Balón de baloncesto para niños GOLTY junior No.6", "7")
        val producto8 = Product("Basquetbol", 160.0, "BKMTOJ6", "METEOR", "Balón de Baloncesto Meteor para los niños y jouvenes No.6", "8")
        val producto9 = Product("Soccer", 425.0, "BSML754", "MOLTEN", "Balón de fútbol MOLTEN PF-751 No.4", "9")
        val producto10 = Product("Soccer", 360.0, "BSVTVC5", "VOIT", "Balón de fútbol varios colores No 5", "10")
        val producto11 = Product("Soccer", 650.0, "BSADFC5", "ADIDAS", "Balón de fútbol UEFA Finale Champions League 2017 No.5", "11")
        val producto12 = Product("Soccer", 200.0, "BSAGKJ3", "ANGGREK", "Balón de fútbol para Entrenamiento Y Competencia No.3", "12")
        val producto13 = Product("Soccer", 1400.0, "OVTRC3", "VERMONT", "Pelota de Tenis 3 Tubos 4 c/u Resistente Clasica", "13")
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
        listaProductos.add(producto5);
        listaProductos.add(producto6);
        listaProductos.add(producto7);
        listaProductos.add(producto8);
        listaProductos.add(producto9);
        listaProductos.add(producto10);
        listaProductos.add(producto11);
        listaProductos.add(producto12);
        listaProductos.add(producto13);

    }
}