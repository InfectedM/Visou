package com.example.visou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RegistroAdapter : RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder>() {

    private val registros = mutableListOf<Registro>()

    inner class RegistroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtObra: TextView = itemView.findViewById(R.id.txtObra)
        private val txtDonoObra: TextView = itemView.findViewById(R.id.txtDonoObra)
        private val txtEntidadeExecutante: TextView = itemView.findViewById(R.id.txtEntidadeExecutante)

        fun bind(registro: Registro) {
            txtObra.text = registro.obra
            txtDonoObra.text = registro.donoObra
            txtEntidadeExecutante.text = registro.entidadeExecutante
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_registro, parent, false)
        return RegistroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RegistroViewHolder, position: Int) {
        val registro = registros[position]
        holder.bind(registro)
    }

    override fun getItemCount(): Int {
        return registros.size
    }

    fun addRegistro(registro: Registro) {
        registros.add(registro)
        notifyDataSetChanged()
    }
}
