package com.hephzibah.schedulerapp.data.repository

import com.hephzibah.schedulerapp.data.model.Client

object ClientRepository {

    private val clients = listOf(
        Client("1","Jane Jack", "Female", "32", "jane@gmail.com"),
        Client("2","Joe Phillips",  "Male",  "39", "joe@gmail.com"),
        Client("3","Mark Zain",  "Male", "40", "mark@gmail.com"),
        Client("4", "Sara Stone", "Female", "12", "sarah@gmail.com"),
        Client("5", "John Doe", "Male", "67", "john@gmail.com"))

    fun getClients(): List<Client>{
      return  clients
    }
}