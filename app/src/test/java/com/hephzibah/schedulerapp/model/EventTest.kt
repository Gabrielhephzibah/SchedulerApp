package com.hephzibah.schedulerapp.model

import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.data.model.Event

object EventTest {
    val firstEvent = Event(
        Client(
        "1",
        "Sarah Stone",
        "Female",
        "12",
        "sarah@gmail.com"),"First note","12:00","1:00","Monday")
    val secondEvent = Event(
        Client(
        "2",
        "John Doe",
        "Male",
        "67",
        "john@gmail.com"),"Second note","16:00","17:00","Tuesday")
}