package com.example.beta.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beta.R
import com.example.beta.service.model.Model
import com.example.beta.view.listener.ModelListener
import com.example.beta.view.viewholder.TodosViewHolder

class TodosAdapter: RecyclerView.Adapter<TodosViewHolder>() {

    private var _listaTodos: List<Model> = arrayListOf()
    private lateinit var _listener: ModelListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_grid_todos, parent, false)
        return TodosViewHolder(itemView, _listener)
    }

    override fun onBindViewHolder(holder: TodosViewHolder, position: Int) {
        holder.Bind(_listaTodos[position])
    }

    override fun getItemCount(): Int {
        return _listaTodos.count()
    }

    fun AtualizarLista(lista: List<Model>) {
        _listaTodos = lista
        notifyDataSetChanged()
    }

    fun AtribuirListener(listener: ModelListener) {
        _listener = listener
    }

}