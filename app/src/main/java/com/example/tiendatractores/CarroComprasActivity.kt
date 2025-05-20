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

        val btnRegresar: Button = findViewById(R.id.btnregresar)
        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivityCatalogo::class.java)

            startActivity(intent)
        }
        pagarButton.setOnClickListener {
            startActivity(intent)
        }
    }

    fun setupRecyclerView() {
        binding.rvListaCarro.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorCarroCompras(binding.tvTotal, carrito)
        binding.rvListaCarro.adapter = adapter
    }



}
