package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.radio.RadioItemDto
import com.tunein.radiotime.domain.model.RadioStation

/**
 * Mapper class for convert [RadioItemDto] to [RadioStation] and vice versa
 */
class RadioStationsDomainMapper @Inject constructor() : Mapper<RadioStation, RadioItemDto> {

    override fun from(i: RadioStation?): RadioItemDto {
        return RadioItemDto(
            i?.url,
            i?.title,
            i?.subTitle,
            i?.cover,
            i?.type
        )
    }

    override fun to(o: RadioItemDto?): RadioStation {
        return RadioStation(
            type = o?.type,
            url = o?.url,
            title = o?.text ?: "",
            subTitle = o?.subtext ?: "",
            cover = o?.image,
        )
    }
}