package com.tunein.radiotime.data.parser

/**
 * [ResponseKeys] holds the keys that are in the response schema from the server.
 */
enum class ResponseKeys(val key: String) {
    MUSIC("music"),
    TALK("talk"),
    SPORTS("sports"),
    LOCATION("location"),
    LANGUAGE("language"),
    LOCAL("local"),
    PODCAST("podcast"),
    LINK("link"),
    TEXT("text"),
    AUDIO("audio"),
    STATION("station"),
    SHOW("show"),
}