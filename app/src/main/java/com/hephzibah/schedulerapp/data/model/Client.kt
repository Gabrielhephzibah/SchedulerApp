package com.hephzibah.schedulerapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Client(
    val id : String?,
    val name: String?,
    val gender: String?,
    val age: String?,
    val email: String?,
): Parcelable