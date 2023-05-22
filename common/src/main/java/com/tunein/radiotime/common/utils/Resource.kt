package com.tunein.radiotime.common.utils

/**
 * A generic class that holds a value with its loading status
 **/
sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    object Empty : Resource<Nothing>()
    class Success<T>(val data: T) : Resource<T>()
    class Error(val message: String) : Resource<Nothing>()
}