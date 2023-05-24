package com.tunein.radiotime.data.parser

/**
 * [ResponseKeys] holds the keys of raw objects.
 */
sealed class ResponseKeys(val key: String) {
    object MUSIC : ResponseKeys("music")
    object TALK : ResponseKeys("talk")
    object SPORTS : ResponseKeys("sports")
    object LOCATION : ResponseKeys("location")
    object LANGUAGE : ResponseKeys("language")
    object LOCAL : ResponseKeys("local")
    object PODCAST : ResponseKeys("podcast")
    object LINK : ResponseKeys("link")
    object TEXT : ResponseKeys("text")
    object AUDIO : ResponseKeys("audio")
    object STATION : ResponseKeys("station")
    object SHOW : ResponseKeys("show")
}