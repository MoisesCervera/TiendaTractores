package com.example.tiendatractores

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendatractores.databinding.ActivityCarroComprasBinding

class CarroComprasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarroComprasBinding
    private lateinit var adapter: AdaptadorCarroCompras

     var carrito = Carrito.CarritoVer.obtenerProductos()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarroComprasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()


        //Boton pagar
        val pagarButton: Button = findViewById(R.id.btnPagar)

        pagarButton.setOnClickListener {
            val url = "https://paypal.me/WackyLeo?country.x=MX&locale.x=es_XC"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    fun setupRecyclerView() {
        binding.rvListaCarro.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorCarroCompras(binding.tvTotal, carrito)
        binding.rvListaCarro.adapter = adapter
    }



}
