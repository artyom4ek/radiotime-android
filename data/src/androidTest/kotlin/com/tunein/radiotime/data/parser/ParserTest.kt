package com.tunein.radiotime.data.parser

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.entity.ItemDto

/**
 * [ParserTest] represents unit tests for the [ParserImpl] class.
 */
@RunWith(MockitoJUnitRunner::class)
internal class ParserTest {

    @Mock
    private lateinit var json: Json

    @InjectMocks
    private lateinit var parser: ParserImpl

    @OptIn(ExperimentalSerializationApi::class)
    @Before
    fun setup() {
        json = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }

    @Test(expected = NullPointerException::class)
    fun test_checkIfChildrenExists_with_null_list() {
        parser.checkIfChildrenExists(null)
    }

    @Test
    fun test_checkIfChildrenExists_with_empty_list() {
        val result = parser.checkIfChildrenExists(emptyList())

        assertEquals(false, result)
    }

    @Test
    fun test_checkIfChildrenExists_with_list_containing_children_element() {
        val bodyDto = json.decodeFromString<ResponseDto>(jsonWithChildrenElements).body
        val result = parser.checkIfChildrenExists(bodyDto)

        assertEquals(true, result)
    }

    @Test
    fun test_checkIfChildrenExists_with_list_not_containing_children_element() {
        val bodyDto = json.decodeFromString<ResponseDto>(jsonWithoutChildrenElements).body
        val result = parser.checkIfChildrenExists(bodyDto)

        assertEquals(false, result)
    }

    @Test
    fun test_itemAnalysis_with_CategoryList_type() {
        val bodyDto = json.decodeFromString<ResponseDto>(jsonWithoutChildrenElements).body
        val itemDtoList = bodyDto!!.map { json.decodeFromJsonElement<ItemDto>(it.jsonObject) }
        val itemDtoForTest = itemDtoList[0]
        val result = parser.itemAnalysis(itemDtoForTest)

        assertEquals(ContentType.CategoryList, result)
    }
}