package com.tunein.radiotime.common.utils

sealed class ContentType {
    object Empty : ContentType()
    object CategoryGrid : ContentType()
    object CategoryList : ContentType()
    object AudioList : ContentType()
}