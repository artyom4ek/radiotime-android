package com.tunein.radiotime.data.parser

enum class BodyFieldTypes(val typeName: String) {
    LINK("link"),
    TOPICS("topics"),
    TOPIC("topic"),
    SHOW("show"),
    SHOWS("shows"),
    AUDIO("audio"),
    STATIONS("stations"),
    STATION("station"),
    RELATED("related"),
    LOCAL("local"),
    TEXT("text"),
    PIVOT_GENRE("pivotGenre"),
    NEXT_SHOWS("nextShows"),
    NEXT_STATIONS("nextStations")
}