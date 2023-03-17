package com.hephzibah.schedulerapp.ui.eventDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.hephzibah.schedulerapp.R
import com.hephzibah.schedulerapp.databinding.FragmentEventDetailsBinding


class EventDetailsFragment : Fragment() {
    private var _binding: FragmentEventDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: EventDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackClick()
        getEventDetails()
    }

    private fun getEventDetails() {
        val details = args.event
        binding.name.text = getString(R.string.name, details?.client?.name)
        binding.gender.text = getString(R.string.gender, details?.client?.gender)
        binding.age.text = getString(R.string.age, details?.client?.age)
        binding.email.text = getString(R.string.email, details?.client?.email)
        binding.date.text = details?.date
        binding.startDate.text = details?.startTime
        binding.endDate.text = details?.endTime
        binding.note.text = details?.note
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