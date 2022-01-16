package com.example.beta.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.beta.viewmodel.FormViewModel
import com.example.beta.R
import com.example.beta.service.constants.ModelConstants
import com.example.beta.service.model.Model
import com.example.beta.service.repository.Repository
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _viewModel: FormViewModel
    private var _id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        _viewModel = ViewModelProvider(this).get(FormViewModel::class.java)

        setListeners()
        observe()
        buscarPorId()
    }

    private fun buscarPorId() {
        val bundle = intent.extras
        if (bundle != null) {
            _id = bundle.getInt(ModelConstants.MODEL_ID)
            _viewModel.BuscarPorId(_id)
        }
    }

    private fun observe() {
        _viewModel.sucesso.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        _viewModel.model.observe(this, Observer {
            edit_nome.setText(it.Nome)
            if (it.Presenca) {
                radio_presente.isChecked = true
                radio_ausente.isChecked = false
            } else {
                radio_presente.isChecked = false
                radio_ausente.isChecked = true
            }


        })
    }

    private fun setListeners() {
        button_salvar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button_salvar) {
            val nome = edit_nome.text.toString()
            val presenca = radio_presente.isChecked
            val dto = Model().apply {
                this.Id = _id
                this.Nome = nome
                this.Presenca = presenca
            }
            _viewModel.Salvar(dto)
        }
    }
}