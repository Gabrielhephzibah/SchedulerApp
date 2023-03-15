package com.hephzibah.schedulerapp.data.repository

import com.hephzibah.schedulerapp.data.model.Client

object ClientRepository {
    private val clients = listOf(
        Client("1","Kennet Mangodo", "USA", "Female", "Lawyer", "32", "tolu@gmail.com"),
        Client("2","Joy Stephen", "Brazil", "Male", "Engineer", "39", "titi@gmail.com"),
        Client("3","Mark Zukerberg", "Ireland", "Male", "Project Manager", "40", "john@gmail.com")
    )

    fun getClients(): List<Client>{
      return  clients
    }

}