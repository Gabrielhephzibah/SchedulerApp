package com.hephzibah.schedulerapp.ui.clients

import androidx.lifecycle.ViewModel
import com.hephzibah.schedulerapp.data.repository.ClientRepository

class ClientViewModel: ViewModel() {
    fun getClient() = ClientRepository.getClients()
}