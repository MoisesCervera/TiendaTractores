package com.example.tiendatractores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Product
import com.example.tiendatractores.R

class AdaptadorCarroCompras(
    var tvTotal: TextView,
    var carroCompras: ArrayList<Product>
) : RecyclerView.Adapter<AdaptadorCarroCompras.ViewHolder>() {

    var total: Double = 0.0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomProducto = itemView.findViewById(R.id.textViewProductName0) as TextView
        val tvPrecio = itemView.findViewById(R.id.textViewPrice0) as TextView
        val detalle = itemView.findViewById(R.id.textViewDescription0) as TextView
        val modelo = itemView.findViewById(R.id.textViewModel0) as TextView
        val marca = itemView.findViewById(R.id.textViewBrand0) as TextView
        val url = itemView.findViewById(R.id.imageViewProduct0) as ImageView
        val btneliminar = itemView.findViewById(R.id.eliminarProducto) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv_carro_compras, parent, false)

        calcularTotal()
        actualizarTotalUI()

        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = carroCompras[position]

        holder.tvNomProducto.text = producto.nombre
        holder.modelo.text = producto.modelo
        holder.marca.text = producto.marca
        holder.detalle.text = producto.descripcion
        holder.tvPrecio.text = "$${producto.precio}"
        when (producto.urlImagen) {
            "1" -> holder.url.setImageResource(R.drawable.tractor_rojo1)
            "2" -> holder.url.setImageResource(R.drawable.tractor_verde2)
            "3" -> holder.url.setImageResource(R.drawable.tractor_azul3)
            "4" -> holder.url.setImageResource(R.drawable.tractor_4)
            "5" -> holder.url.setImageResource(R.drawable.tractor_5)
            "6" -> holder.url.setImageResource(R.drawable.tractor_6)
            "7" -> holder.url.setImageResource(R.drawable.tractor_7)
            "8" -> holder.url.setImageResource(R.drawable.tractor_8)
            "9" -> holder.url.setImageResource(R.drawable.tractor_9)
            "10" -> holder.url.setImageResource(R.drawable.tractor_10)
            "11" -> holder.url.setImageResource(R.drawable.tractor_11)
            "12" -> holder.url.setImageResource(R.drawable.tractor_12)
            "13" -> holder.url.setImageResource(R.drawable.tractor_13)
        }

        holder.btneliminar.setOnClickListener {
            eliminarProducto(position)
        }
    }

    override fun getItemCount(): Int {
        return carroCompras.size
    }

    private fun eliminarProducto(position: Int) {
        // Eliminar el producto del carrito
        carroCompras.removeAt(position)
        // Notificar al adaptador que el item fue eliminado
        notifyItemRemoved(position)
        // Recalcular el total
        calcularTotal()
        actualizarTotalUI()
    }

    private fun calcularTotal() {
        total = carroCompras.sumOf { it.precio }
    }

    private fun actualizarTotalUI() {
        tvTotal.text = "Total: $$total"
    }
}
