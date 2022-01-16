package com.example.beta.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beta.R
import com.example.beta.databinding.FragmentAusenteBinding
import com.example.beta.service.constants.ModelConstants
import com.example.beta.service.model.Model
import com.example.beta.view.adapter.TodosAdapter
import com.example.beta.view.listener.ModelListener
import com.example.beta.viewmodel.TodosViewModel

class AusenteFragment : Fragment() {

    private lateinit var _viewModel: TodosViewModel
    private val _adapter: TodosAdapter = TodosAdapter()
    private lateinit var _listener: ModelListener

    private var _binding: FragmentAusenteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        _viewModel = ViewModelProvider(this).get(TodosViewModel::class.java)

        _binding = FragmentAusenteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /** RecyclerView */
        // 1 - Obter a recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_ausentes)

        // 2 - Definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

        // 3 - Definir um adapter
        //  3.1 - Criar um Adapter
        //  3.2 - Criar um View Holder
        //  3.4 - Criar um Layout
        recycler.adapter = _adapter

        _listener = object : ModelListener {
            override fun OnClick(id: Int) {

                val intent = Intent(context, FormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(ModelConstants.MODEL_ID, id)

                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun OnRemove(dto: Model) {
                _viewModel.Remover(dto)
                _viewModel.BuscarTodos(ModelConstants.FILTER.AUSENTES)
            }

        }

        _adapter.AtribuirListener(_listener)

        observer()

        return root
    }

    private fun observer() {
        _viewModel.todos.observe(viewLifecycleOwner, Observer {
            _adapter.AtualizarLista(it)
        })

        _viewModel.sucesso.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Falha", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        _viewModel.BuscarTodos(ModelConstants.FILTER.AUSENTES)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}