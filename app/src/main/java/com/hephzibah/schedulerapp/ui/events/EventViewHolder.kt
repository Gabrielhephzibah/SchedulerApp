package com.hephzibah.schedulerapp.ui.events

import androidx.recyclerview.widget.RecyclerView
import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.data.model.Event
import com.hephzibah.schedulerapp.databinding.ItemClientBinding
import com.hephzibah.schedulerapp.databinding.ItemEventBinding

class EventViewHolder(
    private val binding: ItemEventBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bind(item: Event) {
        binding.date.text = item.date
    }
}