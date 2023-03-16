package com.hephzibah.schedulerapp.utils.extensions

import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.hephzibah.schedulerapp.utils.AppConstants
import java.text.SimpleDateFormat
import java.util.*


fun Fragment.displayDatePicker(editText: TextInputEditText, dateSelected: (String) -> Unit) {
    val constraintsBuilder =
        CalendarConstraints.Builder().setValidator(DateValidatorPointForward.now())
    val picker = MaterialDatePicker.Builder.datePicker()
        .setTitleText(AppConstants.SELECT_DATE)
        .setCalendarConstraints(constraintsBuilder.build())
        .build()
    picker.show(this.parentFragmentManager, AppConstants.DATE_PICKER)
    picker.addOnPositiveButtonClickListener {
        val dateStamp = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = dateStamp.format(it)
        editText.setText(date)
        dateSelected(date)
    }
}

fun Fragment.displayTimePicker(editText: TextInputEditText, timeSelected: (String) -> Unit) {
    val timePicker = MaterialTimePicker.Builder()
        .setTitleText(AppConstants.SELECT_TIME)
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





