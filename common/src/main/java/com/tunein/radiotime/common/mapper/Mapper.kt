package com.tunein.radiotime.common.mapper

/**
 * Mapper interface
 */
interface Mapper<I, O> {

    fun from(i: I?): O
}