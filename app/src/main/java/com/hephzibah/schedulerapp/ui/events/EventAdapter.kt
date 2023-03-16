package com.hephzibah.schedulerapp.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hephzibah.schedulerapp.data.model.Event
import com.hephzibah.schedulerapp.databinding.ItemEventBinding

class EventAdapter(private val onItemClick: (Event?) -> Unit) :
    ListAdapter<Event, EventViewHolder>(EventComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding =
            ItemEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return EventViewHolder(binding) {
            onItemClick(getItem(it))
        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        getItem(position)?.let { item -> holder.bind(item) }
    }

    object EventComparator : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(
            oldItem: Event,
            newItem: Event
        ): Boolean {
            return oldItem.client.id == newItem.client.id
        }
        override fun areContentsTheSame(
            oldItem: Event,
            newItem: Event
        ): Boolean {
            return oldItem == newItem
        }
    }

}