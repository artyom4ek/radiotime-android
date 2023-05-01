package com.tunein.radiotime.domain.repository

interface MainRepository {

    fun prepareAndGetInitData(): Map<String, Any>
}