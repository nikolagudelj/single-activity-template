package com.nikola.singleactivitytemplate.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikola.singleactivitytemplate.R

class MyAdapter(private var itemList : MutableList<Any>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Inflate views from itemView
        //var someView = itemView.findViewById(R.id.someViewID) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val chat = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_list_member, parent, false)
        return ViewHolder(chat)
    }

    override fun getItemViewType(position: Int): Int {
        // If using different layouts for different list elements, check it here
        // Eg.
        // if (itemList[position].someField == someValue) return 1
        return 0
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set ViewHolder views' values
        // someView.setText(itemList[position].someField)
    }
}