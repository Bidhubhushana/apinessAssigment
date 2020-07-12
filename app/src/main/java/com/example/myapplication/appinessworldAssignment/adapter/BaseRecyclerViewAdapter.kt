package com.example.myapplication.appinessworldAssignment.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter: RecyclerView.Adapter<BaseViewHolder>() {

    protected var listener: RecyclerItemClickListener? = null

    abstract fun addItems(items: List<Any>?)

    interface RecyclerItemClickListener {
        fun onItemClick(item: Any?, position: Int, totalItem: Int?)
    }

}