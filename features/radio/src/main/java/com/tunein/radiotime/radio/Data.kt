package com.tunein.radiotime.radio

import com.tunein.radiotime.domain.model.RadioStation

fun prepareStationList() = listOf(
    RadioStation(
        type = "audio",
        url = "http://opml.radiotime.com/Tune.ashx?id=s219332",
        title = "Fresh FM Ukraine (Dance & Electronic)",
        subTitle = "Твій ковток свіжості!",
        cover = "http://cdn-radiotime-logos.tunein.com/s219332q.png)"
    ),
    RadioStation(
        type = "audio",
        url = "http://opml.radiotime.com/Tune.ashx?id=s218179",
        title = "Melodia FM Ukraine 100.9 (Standards)",
        subTitle = "Радіо для гарного настрою!",
        cover = "http://cdn-profiles.tunein.com/s112679/images/logoq.png?t=158327"
    )
)