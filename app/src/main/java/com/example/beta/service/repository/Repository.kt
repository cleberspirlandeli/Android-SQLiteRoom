package com.example.beta.service.repository

import android.content.ContentValues
import android.content.Context
import com.example.beta.service.constants.DataBaseConstants
import com.example.beta.service.model.Model
import java.lang.Exception

class Repository (ctx: Context){

    private val _dataBase = ModelDataBase.GetDataBase(ctx).GetModelDAO()


    fun BuscarTodos(): List<Model> {
        return _dataBase.BuscarTodos()
    }

    fun BuscarConfirmados(): List<Model> {
        return _dataBase.BuscarConfirmados()
    }

    fun BuscarAusentes(): List<Model> {
        return _dataBase.BuscarAusentes()
    }

    fun BuscarPorId(id: Int): Model? {
       return _dataBase.BuscarPorId(id)
    }

    fun Inserir(dto: Model): Boolean {
        return _dataBase.Inserir(dto) > 0
    }

    fun Editar(dto: Model): Boolean {
        return _dataBase.Editar(dto) > 0
    }

    fun Remover(dto: Model) {
        return _dataBase.Remover(dto)
    }
}