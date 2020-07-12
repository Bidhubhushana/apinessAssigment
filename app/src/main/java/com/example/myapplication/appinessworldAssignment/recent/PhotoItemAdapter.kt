package com.example.myapplication.appinessworldAssignment.recent

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.appinessworldAssignment.adapter.BaseRecyclerViewAdapter
import com.example.myapplication.appinessworldAssignment.adapter.BaseViewHolder
import com.example.myapplication.databinding.PhotoBinding
import com.example.myapplication.query.Photo

class PhotoItemAdapter(val context:Context):BaseRecyclerViewAdapter(){

    private var list:MutableList<PhotoViewModel> =ArrayList()

    override fun addItems(items: List<Any>?) {
        if(items!![0] is Photo){
            list.clear()
            list.addAll(items as List<PhotoViewModel>)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val liveDataViewBinding = PhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PhotoItemViewModel(liveDataViewBinding)
    }

    override fun getItemCount(): Int {
      return list?.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder as PhotoItemViewModel
        holder.view.viewModel=list.get(position)
        holder.view.executePendingBindings()
    }

    inner class PhotoItemViewModel(val view: PhotoBinding) : BaseViewHolder(view.root)
}