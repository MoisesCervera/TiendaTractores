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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_catalogo)
        val producto1 = Product("RedBarrel", 479.00, "TR100X", "IronSprout", "Motor diésel de 4.2L con 4 cilindros en línea, entrega 95 hp a 2200 rpm.\nIdeal para transporte de carga ligera y media con tráiler trasero integrado.", "1")
        val producto2 = Product("NightSprout", 459.00, "TR220V", "MiniTorque", "Motor diésel de 4.5L con 4 cilindros en línea, entrega 102 hp a 2100 rpm.\nModelo versátil diseñado para labores generales de campo y cultivos.", "2")
        val producto3 = Product("ClawMarine", 499.00, "TR310C", "TractoKing", "Motor diésel de 4.0L con 4 cilindros en línea, entrega 90 hp a 2300 rpm.\nIncluye garra frontal para manipulación de troncos, pacas y materiales rústicos.", "3")
        val producto4 = Product("OrangeStorm", 489.20, "TR400B", "PlayAgro", "Motor diésel de 4.6L con 4 cilindros turboalimentado, entrega 108 hp a 2200 rpm.\nEquipado con soplador frontal para limpieza de caminos y cultivos.", "4")
        val producto5 = Product("JungleGripper", 529.00, "TR370G", "TinyHarvest", "Motor diésel de 4.3L con 4 cilindros en línea, entrega 97 hp a 2150 rpm.\nDiseño robusto con garra hidráulica para trabajos forestales y agrícolas.", "5")
        val producto6 = Product("SunCrusher", 509.00, "TR550R", "FerroKid", "Motor diésel de 5.0L con 4 cilindros turbo, entrega 115 hp a 2000 rpm.\nIncluye rodillo frontal para compactación de suelos y aplanado de terrenos.", "6")
        val producto7 = Product("BlazeBucket", 469.50, "TR600L", "GreenPiston", "Motor diésel de 4.4L con 4 cilindros en línea, entrega 100 hp a 2250 rpm.\nVersión cargadora rápida con pala frontal reforzada para movimiento de materiales.", "7")
        val producto8 = Product("HydroPod", 519.30, "TR480T", "MechaFarm", "Motor diésel de 4.1L con 4 cilindros, entrega 92 hp a 2100 rpm.\nCon tanque trasero para aplicaciones de riego, fumigación o fertilización.Ideal en cualquier aplicación, ya sea para sus propios campos, así como servicios de maquila", "8")
        val producto9 = Product("VioletCruze", 549.20, "TR530S", "TractoFun", "Motor diésel de 4.2L con 4 cilindros, entrega 95 hp a 2200 rpm.\nEdición especial con acabado exclusivo y configuración estándar de campo.", "9")
        val producto10 = Product("SwampLoader", 529.59, "TR520L", "RuralBot", "Motor diésel de 4.3L con 4 cilindros en línea, entrega 98 hp a 2150 rpm.\nEquipo equilibrado para carga frontal y soporte en tareas múltiples.", "10")
        val producto11 = Product("SolarClamp", 579.45, "TR570C", "Farmodrive", "Motor diésel de 4.6L con 4 cilindros turboalimentado, entrega 110 hp a 2200 rpm.\nCon garra hidráulica de alto alcance, ideal para desmonte y construcción ligera.", "11")
        val producto12 = Product("IronDump", 439.40, "TR680D", "KiddoTrak", "Motor diésel de 5.2L con 4 cilindros, entrega 118 hp a 2050 rpm.\nCaja de carga trasera volquete con alta capacidad para materiales pesados.", "12")
        val producto13 = Product("FangForge", 449.50, "TR750F", "SteelSeed", "Motor diésel de 4.8L con 4 cilindros turbo, entrega 112 hp a 2100 rpm.\nProtección frontal de jaula, óptimo para zonas forestales o terrenos con obstáculos.", "13")

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


        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarro)
        btnVerCarrito.setOnClickListener {
            val intent = Intent(this@MainActivityCatalogo, CarroComprasActivity::class.java)
            startActivity(intent)
        }


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

}