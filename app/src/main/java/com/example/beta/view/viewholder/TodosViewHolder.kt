package com.example.beta.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beta.R
import com.example.beta.service.model.Model
import com.example.beta.view.listener.ModelListener

class TodosViewHolder(itemView: View, private val listener: ModelListener) : RecyclerView.ViewHolder(itemView) {

    fun Bind(model: Model) {
        val textName = itemView.findViewById<TextView>(R.id.text_nome)
        textName.text = model.Nome

        textName.setOnClickListener {
            listener.OnClick(model.Id)
        }

        textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.OnRemove(model)
                }
                .setNegativeButton(R.string.cancelar, null)
                .show()

            true
        }
    }
}