package com.tunein.radiotime.data.parser

/**
 * [ResponseFields] holds the name of fields for raw objects.
 */
sealed class ResponseFields(val name: String) {
    object CHILDREN : ResponseFields("children")
}