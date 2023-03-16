package com.hephzibah.schedulerapp.data.repository

import com.hephzibah.schedulerapp.data.model.Client

object ClientRepository {

    private val clients = listOf(
        Client("1","Kennet Mangodo", "Female", "32", "tolu@gmail.com"),
        Client("2","Joy Stephen",  "Male",  "39", "titi@gmail.com"),
        Client("3","Mark Zukerberg",  "Male", "40", "john@gmail.com")
    )

    fun getClients(): List<Client>{
      return  clients
    }

}