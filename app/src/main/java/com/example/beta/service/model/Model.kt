package com.example.beta.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "model")
class Model {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int = 0

    @ColumnInfo(name = "nome")
    var Nome: String = ""

    @ColumnInfo(name = "presenca")
    var Presenca: Boolean = true
}