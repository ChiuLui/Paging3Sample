package com.chiului.paging3sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


/**
 * MainAdapter$
 * @author    神经大条蕾弟
 * @date      2020/09/15 14:12
 */
class MainAdapter: PagingDataAdapter<User, MainAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) };
    }

    class ViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        var text: TextView = view.findViewById<TextView>(R.id.text);

        fun bind(user: User){
            text.text = user.name
            view.setOnClickListener {
                Toast.makeText(view.context, user.name, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private class DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}