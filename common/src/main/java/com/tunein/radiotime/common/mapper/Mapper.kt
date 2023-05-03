package com.tunein.radiotime.common.mapper

/**
 * Mapper interface
 */
interface Mapper<I, O> {

    fun from(i: I?): O

    fun to(o: O?): I

    fun fromList(list: List<I>?): List<O> {
        return list?.mapNotNull { from(it) } ?: emptyList()
    }

    fun toList(list: List<O>?): List<I> {
        return list?.mapNotNull { to(it) } ?: emptyList()
    }
}