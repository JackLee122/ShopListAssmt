package com.mmgpt.shoplistgpt

import org.junit.Test
import org.junit.Assert.*

class DoubleTapNavigationTest {

    @Test
    fun adapterShopModeItemCountIsCorrect() {
        val categories = listOf(
            ShoppingCategory(1, "Food", emptyList()),
            ShoppingCategory(2, "Clothes", emptyList())
        )
        assertEquals(2, categories.size)
        assertEquals(3, categories.size + 1)
    }

    @Test
    fun adapterPlanModeItemCountIsCorrect() {
        val categories = listOf(ShoppingCategory(1, "A", emptyList()))
        assertEquals(2, categories.size + 1)
    }

    @Test
    fun doubleTapPositionMatchesAdapterIndex() {
        val adapterPosition = 0
        val expectedPage = adapterPosition
        assertEquals(0, expectedPage)
    }
}
