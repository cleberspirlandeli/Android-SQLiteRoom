package com.example.beta.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.beta.service.model.Model

@Database(entities = [Model::class], version = 1)
abstract class ModelDataBase: RoomDatabase() {

    abstract fun GetModelDAO(): ModelDAO

    // Singleton
    companion object {
        private lateinit var INSTANCE: ModelDataBase

        fun GetDataBase(context: Context): ModelDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(ModelDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, ModelDataBase::class.java, "ModelDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}