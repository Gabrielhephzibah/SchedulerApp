package com.hephzibah.schedulerapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val client: Client,
    val note: String?,
    val startTime: String?,
    val endTime: String?,
    val date: String?
): Parcelable