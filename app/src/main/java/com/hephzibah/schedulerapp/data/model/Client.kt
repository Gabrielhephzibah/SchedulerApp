package com.hephzibah.schedulerapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Client(
    val id : String?,
    val name: String?,
    val location: String?,
    val gender: String?,
    val occupation: String?, // TODO: change text to profession
    val age: String?,
    val email: String?,
): Parcelable