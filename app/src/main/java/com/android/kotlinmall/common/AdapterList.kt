package com.android.kotlinmall.common

import android.support.v7.widget.RecyclerView

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-01
 **
 ** Description is
 **/



class AdapterList<T>(val adapter: RecyclerView.Adapter<*>): ArrayList<T>(){
    override fun removeAt(index: Int): T {
        return super.removeAt(index).apply { adapter.notifyItemRemoved(index) }
    }

    override fun remove(element: T): Boolean {
        val index = indexOf(element)
        return super.remove(element).apply { adapter.notifyItemRemoved(index) }
    }

    override fun removeRange(fromIndex: Int, toIndex: Int) {
        super.removeRange(fromIndex, toIndex).apply { adapter.notifyItemRangeRemoved(fromIndex, toIndex) }
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return super.removeAll(elements).apply { adapter.notifyDataSetChanged() }
    }

    override fun add(index: Int, element: T) {
        super.add(index, element)
        adapter.notifyItemInserted(index)
    }

    override fun add(element: T): Boolean {
        return super.add(element).apply {
            adapter.notifyItemInserted(size - 1)
        }
    }

    override fun addAll(elements: Collection<T>): Boolean {
        return super.addAll(elements).apply { adapter.notifyDataSetChanged() }
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        return super.addAll(index, elements).apply { adapter.notifyDataSetChanged() }
    }

    fun update(elements: Collection<T>){
        super.clear()
        super.addAll(elements)
        adapter.notifyDataSetChanged()
    }

    override fun set(index: Int, element: T): T {
        return super.set(index, element).also {
            adapter.notifyDataSetChanged()
        }
    }

    override fun clear() {
        super.clear()
        adapter.notifyDataSetChanged()
    }
}