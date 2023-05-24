package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.repository.DetailsRepository

/**
 * [DetailsUseCase] provides methods for retrieving details data.
 *
 * @param ioDispatcher The CoroutineDispatcher for performing IO operations.
 * @param detailsRepository The repository interface for accessing details repository data.
 */
class DetailsUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val detailsRepository: DetailsRepository
) {

    suspend fun getDetailsData(url: String): Flow<Resource<List<CategoryType>>> {
        return detailsRepository.getDetailsData(url).flowOn(ioDispatcher)
    }
}
