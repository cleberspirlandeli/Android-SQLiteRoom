package com.example.beta.viewmodel

import android.app.Application
import android.graphics.ColorSpace
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beta.service.constants.ModelConstants
import com.example.beta.service.model.Model
import com.example.beta.service.repository.Repository

class TodosViewModel(application: Application) : AndroidViewModel(application) {

    private val _repository = Repository(application.applicationContext)

    private var _sucesso = MutableLiveData<Boolean>()
    val sucesso: LiveData<Boolean> = _sucesso

    private val _todos = MutableLiveData<List<Model>>()
    val todos: LiveData<List<Model>> = _todos

    fun BuscarTodos(filter: Int) {
        if (filter == ModelConstants.FILTER.TODOS) {
            _todos.value = _repository.BuscarTodos()
        } else if (filter == ModelConstants.FILTER.CONFIRMADOS) {
            _todos.value = _repository.BuscarConfirmados()
        } else {
            _todos.value = _repository.BuscarAusentes()
        }
    }

    fun Remover(dto: Model) {
        _repository.Remover(dto)
    }

}