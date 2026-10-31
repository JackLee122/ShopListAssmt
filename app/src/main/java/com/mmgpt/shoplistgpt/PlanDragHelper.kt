package com.mmgpt.shoplistgpt

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.mmgpt.shoplistgpt.adapter.ItemAdapter

/**
 * Shared drag helper for Plan mode fragments.
 * Eliminates duplication between PlanCategoriesFragment and PlanCategoryFragment.
 */
class PlanDragHelper(
    private val adapter: ItemAdapter,
    private val onMove: (from: Int, to: Int) -> Boolean
) : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val from = viewHolder.adapterPosition
        val to = target.adapterPosition
        val itemFrom = adapter.currentList.getOrNull(from)
        val itemTo = adapter.currentList.getOrNull(to)
        if (itemFrom?.isPlaceholder == true || itemTo?.isPlaceholder == true) return false
        val result = onMove(from, to)
        if (result) adapter.moveItem(from, to)
        return result
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

    override fun isLongPressDragEnabled(): Boolean = false
}
