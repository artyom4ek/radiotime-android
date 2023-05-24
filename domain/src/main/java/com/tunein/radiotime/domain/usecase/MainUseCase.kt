package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

/**
 * [MainUseCase] provides methods for retrieving initial data.
 *
 * @param ioDispatcher The CoroutineDispatcher for performing IO operations.
 * @param mainRepository The repository interface for accessing main repository data.
 */
class MainUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val mainRepository: MainRepository
) {

    suspend fun getInitialData(): Flow<Resource<InitialData>> {
        return mainRepository.getInitialData().flowOn(ioDispatcher)
    }
}
