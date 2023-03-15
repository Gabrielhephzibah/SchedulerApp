package com.hephzibah.schedulerapp.ui.clients

import androidx.recyclerview.widget.RecyclerView

import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.databinding.ItemClientBinding


class ClientViewHolder(
    private val binding: ItemClientBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }
    fun bind(item: Client) {
        binding.clientName.text = item.name
    }
}