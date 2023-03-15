package com.hephzibah.schedulerapp.ui.events

import androidx.lifecycle.ViewModel
import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.data.model.Event
import kotlinx.coroutines.flow.*

class EventViewModel(): ViewModel() {
    private val _getEvents = MutableStateFlow(listOf<Event>())
    val getEvents  = _getEvents.asStateFlow()
   // private val _getEvents = MutableSharedFlow<MutableList<Event>>(replay = 1)
   // private  var getEvents = _getEvents.asSharedFlow()

    fun addNewEvent(event: Event){
        val tempList = _getEvents.value.toMutableList()
        tempList.add(
            Event(
                Client(event.client.id,
            event.client.name,
        event.client.location,
        event.client.gender,
        event.client.occupation,
        event.client.age,
        event.client.email),event.note, event.startTime,event.endTime, event.date
            )
        )
        _getEvents.value = tempList
    }

    fun getAllEvent(): StateFlow<List<Event>> {
        return getEvents
    }

//    fun addNewEvent(event: Event){
//        println("This is called")
//        viewModelScope.launch {
//           _getEvents.emit(mutableListOf(event))
////           _getEvents.flatMapConcat {
////               flow {
////                  emit(it)
////               }
////           }
//
//                //.emit(event)
//        }
//    }

//    map {
//        flow{
//            it.add(Event(
//                Client(event.client.id,event.client.id ,event.client.id,event.client.id,event.client.id,event.client.id,event.client.id),
//                event.client.id,event.client.id,event.client.id,event.client.id))
//            emit(event)
//        }
//    }
//    .map {
//        it.add(Event(
//            Client(event.client.id,event.client.id ,event.client.id,event.client.id,event.client.id,event.client.id,event.client.id),
//            event.client.id,event.client.id,event.client.id,event.client.id))
//
//    }







//    fun addEvent(event: Event){
//        viewModelScope.launch {
//            _sharedFlow.emit(data)
//        }
//    }


}