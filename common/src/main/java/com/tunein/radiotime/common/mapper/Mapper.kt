package com.tunein.radiotime.common.mapper

/**
 * Mapper interface
 */
interface Mapper<I, O> {

    fun to(o: O?): I

    fun toList(list: List<O>?): List<I> {
        return list?.mapNotNull { to(it) } ?: emptyList()
    }
}