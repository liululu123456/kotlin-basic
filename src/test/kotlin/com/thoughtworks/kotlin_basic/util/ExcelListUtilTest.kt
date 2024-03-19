package com.thoughtworks.kotlin_basic.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable


class ExcelListUtilTest {
    @Test
    fun `when input (26,3) return Z, AA, AB`() {
        val excelListUtil = ExcelListUtil()
        Assertions.assertEquals(listOf("Z", "AA", "AB"), excelListUtil.characterList(26,3))
    }

    @Test
    fun `when input (26,18278) throw exception`() {
        val excelListUtil = ExcelListUtil()
        val thrown: Exception = Assertions.assertThrows(Exception::class.java, Executable {
            excelListUtil.characterList(26,18278)
        })
        Assertions.assertEquals("Exceed the max number of column!", thrown.message)
    }
}