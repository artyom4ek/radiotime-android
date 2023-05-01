package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor() : MainRepository {
    override fun prepareAndGetInitData(): Map<String, Any> {
        return emptyMap()
    }
}