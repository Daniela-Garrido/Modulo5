package com.aumentarte.modulo5.viewModel


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.aumentarte.modulo5.R
import com.aumentarte.modulo5.databinding.ItemlistBinding
import com.aumentarte.modulo5.modelo.local.Entidades.TransaccionLocal
import com.bumptech.glide.Glide


class Adapter : RecyclerView.Adapter<Adapter.ListaTransaccionesViewHolder>() {
    private var listaTransaccion = listOf<TransaccionLocal>()
    private val transaccionSelect = MutableLiveData<TransaccionLocal>()

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ListaTransaccionesViewHolder {
        return ListaTransaccionesViewHolder(ItemlistBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount()= listaTransaccion.size


    override fun onBindViewHolder(holder: ListaTransaccionesViewHolder, position: Int) {
        val transaccion = listaTransaccion[position]
        holder.bind(transaccion)
    }

    fun actualizar(transaccion: List<TransaccionLocal>){
        listaTransaccion = transaccion
        notifyDataSetChanged()
    }


    inner class ListaTransaccionesViewHolder(private val binding: ItemlistBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        fun bind(transaccion: TransaccionLocal) {
            Glide.with(binding.imgUsuario).load(R.drawable.ic_launcher_background).centerCrop().into(binding.imgUsuario)
            binding.nombreUsuario.text = transaccion.concept
            binding.fecha.text = transaccion.createdAt
            binding.monto.text = transaccion.amount
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            transaccionSelect.value = listaTransaccion[adapterPosition]
        }


    }

}
