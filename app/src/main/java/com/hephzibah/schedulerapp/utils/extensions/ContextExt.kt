package com.hephzibah.schedulerapp.utils.extensions

import android.content.Context
import android.widget.Toast

fun Context.displayToast(toastMessage: String){
  Toast.makeText(this, toastMessage, Toast.LENGTH_LONG ).show()
}