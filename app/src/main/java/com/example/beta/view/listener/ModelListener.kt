package com.example.beta.view.listener

import com.example.beta.service.model.Model

interface ModelListener {
    fun OnClick(id: Int)
    fun OnRemove(dto: Model)
}