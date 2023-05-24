package com.tunein.radiotime.common.utils

/**
 * [ContentType] class defines several subclasses representing different content types.
 */
sealed class ContentType {
    object Empty : ContentType()
    object CategoryGrid : ContentType()
    object CategoryList : ContentType()
    object AudioList : ContentType()
}