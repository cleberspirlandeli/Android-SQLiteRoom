package com.example.beta.service.repository

import androidx.room.*
import com.example.beta.service.model.Model

@Dao
interface ModelDAO {

    @Insert
    fun Inserir(dto: Model): Long

    @Update
    fun Editar(dto: Model): Int

    @Delete
    fun Remover(dto: Model)

    @Query("SELECT * FROM model")
    fun BuscarTodos(): List<Model>

    @Query("SELECT * FROM model WHERE presenca = 1")
    fun BuscarConfirmados(): List<Model>

    @Query("SELECT * FROM model WHERE presenca = 0")
    fun BuscarAusentes(): List<Model>

    @Query("SELECT * FROM model WHERE id = :id")
    fun BuscarPorId(id: Int): Model?
}