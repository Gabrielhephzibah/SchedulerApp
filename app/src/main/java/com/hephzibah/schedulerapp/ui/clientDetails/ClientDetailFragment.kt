package com.hephzibah.schedulerapp.ui.clientDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hephzibah.schedulerapp.R
import com.hephzibah.schedulerapp.data.model.Client
import com.hephzibah.schedulerapp.data.model.Event
import com.hephzibah.schedulerapp.databinding.FragmentClientDetailBinding
import com.hephzibah.schedulerapp.ui.events.EventViewModel
import com.hephzibah.schedulerapp.utils.extensions.displayTimePicker
import com.hephzibah.schedulerapp.utils.extensions.displayToast


class ClientDetailFragment : Fragment() {
    private var _binding: FragmentClientDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ClientDetailFragmentArgs by navArgs()
    private lateinit var viewModel: EventViewModel
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
        setUpDropDownAdapter()
        selectStartTime()
        selectEndTime()
        scheduleEvent()
    }

    private fun getClientDetails() {
        val details = args.client
        binding.name.text = details?.name
        binding.gender.text = details?.gender
        binding.age.text = getString(R.string.years, details?.age)
        binding.email.text = details?.email
    }

    private fun selectStartTime() {
        binding.startTime.setOnClickListener {
            displayTimePicker(it as EditText) { input ->
                startTime = input
            }
        }
    }

    private fun selectEndTime() {
        binding.endTime.setOnClickListener {
            displayTimePicker(it as EditText) { input ->
                endTime = input
            }
        }
    }

    private fun setUpDropDownAdapter() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.days_of_the_week))
        binding.pickDay.setAdapter(adapter)
    }

    private fun scheduleEvent() {
        binding.scheduleBtn.setOnClickListener {
            val note = binding.addNote.text.toString()
            val day = binding.pickDay.text.toString()
            if (day.isNotEmpty() && !startTime.isNullOrEmpty() && !endTime.isNullOrEmpty() && note.isNotEmpty()) {
                val newEvent = Event(Client(
                        args.client?.id, args.client?.name,
                        args.client?.gender, args.client?.age, args.client?.email), note, startTime, endTime,day)
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