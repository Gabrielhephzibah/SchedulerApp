package com.hephzibah.schedulerapp.ui.clientDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.data.model.Event

import com.hephzibah.schedulerapp.ui.events.EventViewModel
import com.hephzibah.schedulerapp.utils.extensions.displayDatePicker
import com.hephzibah.schedulerapp.utils.extensions.displayTimePicker
import com.hephzibah.schedulerapp.utils.extensions.displayToast
import com.google.android.material.textfield.TextInputEditText
import com.hephzibah.schedulerapp.R
import com.hephzibah.schedulerapp.databinding.FragmentClientDetailBinding


class ClientDetailFragment : Fragment() {
    private var _binding: FragmentClientDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ClientDetailFragmentArgs by navArgs()
    private lateinit var viewModel: EventViewModel
    private var date: String? = null
    private var startTime: String? = null
    private var endTime: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[EventViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackClick()
        getClientDetails()
        selectDate()
        selectStartTime()
        selectEndTime()
        scheduleEvent()
    }

    private fun getClientDetails() {
        val details = args.client
        binding.name.text = details?.name
        binding.gender.text = details?.gender
        binding.age.text = getString(R.string.age, details?.age)
        binding.email.text = details?.email
    }

    private fun selectDate() {
        binding.pickDate.setOnClickListener {
            displayDatePicker(it as TextInputEditText) { input ->
                date = input
            }
        }
    }

    private fun selectStartTime() {
        binding.startTime.setOnClickListener {
            displayTimePicker(it as TextInputEditText) { input ->
                startTime = input
            }
        }
    }

    private fun selectEndTime() {
        binding.endTime.setOnClickListener {
            displayTimePicker(it as TextInputEditText) { input ->
                endTime = input
            }
        }
    }

    private fun scheduleEvent() {
        binding.scheduleBtn.setOnClickListener {
            val note = binding.note.text.toString()
            if (!date.isNullOrEmpty() && !startTime.isNullOrEmpty() && !endTime.isNullOrEmpty() && !note.isNullOrEmpty()) {
                val newEvent = Event(Client(
                        args.client?.id, args.client?.name,
                        args.client?.gender, args.client?.age, args.client?.email), note, startTime, endTime, date)
                viewModel.addNewEvent(newEvent)
                findNavController().popBackStack()
            } else {
                requireContext().displayToast(getString(R.string.required))
            }
        }
    }

    private fun onBackClick() {
        binding.backArrow.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}