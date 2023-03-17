package com.hephzibah.schedulerapp.utils.extensions

import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.hephzibah.schedulerapp.utils.AppConstants


fun Fragment.displayTimePicker(editText: EditText, timeSelected: (String) -> Unit) {
    val timePicker = MaterialTimePicker.Builder()
        .setTitleText(AppConstants.SELECT_TIME)
        .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
        .setTimeFormat(TimeFormat.CLOCK_24H)
        .setHour(12)
        .setMinute(10)
        .build()
    timePicker.show(this.parentFragmentManager, AppConstants.TIME_PICKER)
    timePicker.addOnPositiveButtonClickListener {
        val time = "${timePicker.hour}:${timePicker.minute}"
        editText.setText(time)
        timeSelected(time)
    }

}





