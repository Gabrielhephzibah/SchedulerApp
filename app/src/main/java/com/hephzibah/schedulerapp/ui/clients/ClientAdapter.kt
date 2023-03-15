package com.hephzibah.schedulerapp.ui.clients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.databinding.ItemClientBinding


class ClientAdapter(private val onItemClick: (Client?) -> Unit) :
    ListAdapter<Client, ClientViewHolder>(ClientComparator)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val binding =
            ItemClientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ClientViewHolder(binding) {
            onItemClick(getItem(it))
        }
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        getItem(position)?.let { item -> holder.bind(item) }
    }

    object ClientComparator : DiffUtil.ItemCallback<Client>() {
        override fun areItemsTheSame(
            oldItem: Client,
            newItem: Client
        ): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(
            oldItem: Client,
            newItem: Client
        ): Boolean {
            return oldItem == newItem
        }
    }

}