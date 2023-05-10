package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.ItemKeys
import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.data.entity.categoryDetails.BodyDto
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.CategoryItem

class CategoryDetailsDomainMapper @Inject constructor() :
    Mapper<Category, BodyDto> {

    override fun from(i: Category?): BodyDto {
        TODO("Not yet implemented")
    }

    override fun to(o: BodyDto?): Category {
        val category = Category(
            title = o?.text ?: "",
            key = o?.key
        )
        val items = mutableListOf<CategoryItem>()
        when (o?.key) {
            ResponseKeys.LOCAL.key, ResponseKeys.STATIONS.key -> {
                items.addAll(o.children?.filter {
                    it.item == ItemKeys.STATION.key
                }?.map {
                    CategoryItem(
                        title = it.text ?: "",
                        subTitle = it.subtext,
                        url = it.url,
                        cover = it.image,
                        // For the Radio station, the Playing parameter is used
                        currentTrack = it.playing
                    )
                } ?: emptyList())
            }

            ResponseKeys.SHOWS.key -> {
                items.addAll(o.children?.filter {
                    it.item == ItemKeys.SHOW.key
                }?.map {
                    CategoryItem(
                        title = it.text ?: "",
                        subTitle = it.subtext,
                        url = it.url,
                        cover = it.image,
                        // For the Radio station, the currentTrack parameter is used
                        currentTrack = it.currentTrack
                    )
                } ?: emptyList())
            }

            ResponseKeys.RELATED.key -> {
                items.addAll(o.children?.filter {
                    // Items to display in the Related category don't use keys
                    it.key.isNullOrEmpty()
                }?.map {
                    CategoryItem(
                        title = it.text ?: "",
                        url = it.url,
                    )
                } ?: emptyList())
            }
        }

        return category.copy(items = category.items + items)
    }
}