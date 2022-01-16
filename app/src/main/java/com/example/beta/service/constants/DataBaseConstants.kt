package com.example.beta.service.constants

class DataBaseConstants private constructor(){
    /**
    * Tabelas disponíveis no banco de dados e suas colunas
    */

    object BETA {
        const val TABLE_NAME = "Beta"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}