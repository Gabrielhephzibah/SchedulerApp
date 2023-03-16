package com.hephzibah.schedulerapp.ui.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.data.model.Event
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    private val _getEvents = MutableStateFlow(listOf<Event>())
    val getEvents = _getEvents.asStateFlow()

    fun addNewEvent(event: Event) {
        viewModelScope.launch {
            val tempList = _getEvents.value.toMutableList()
            tempList.add(
                Event(
                    Client(
                        event.client.id,
                        event.client.name,
                        event.client.gender,
                        event.client.age,
                        event.client.email
                    ), event.note, event.startTime, event.endTime, event.date
                )
            )
            _getEvents.value = tempList
        }
    }
}