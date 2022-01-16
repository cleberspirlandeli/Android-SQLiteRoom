package com.example.beta.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beta.service.model.Model
import com.example.beta.service.repository.Repository

class FormViewModel(aplication: Application): AndroidViewModel(aplication) {

    private val _context = aplication.applicationContext
    private var _repository: Repository = Repository(_context)

    private var _sucesso = MutableLiveData<Boolean>()
    val sucesso: LiveData<Boolean> = _sucesso

    private val _model = MutableLiveData<Model>()
    val model: LiveData<Model> = _model

    fun Salvar (dto: Model): Unit {
        if (dto.Id == 0) {
            _sucesso.value = _repository.Inserir(dto)
        } else {
            _sucesso.value = _repository.Editar(dto)
        }
    }

    fun BuscarPorId(id: Int) {
        _model.value = _repository.BuscarPorId(id)
    }
}