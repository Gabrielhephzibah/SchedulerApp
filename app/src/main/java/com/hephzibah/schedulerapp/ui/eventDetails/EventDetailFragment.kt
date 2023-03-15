package com.hephzibah.schedulerapp.ui.eventDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.hephzibah.schedulerapp.databinding.FragmentEventDetailBinding


class EventDetailFragment : Fragment() {
    private var _binding: FragmentEventDetailBinding? = null
    private val binding get() = _binding!!
    private val args: EventDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackClick()
        getEventDetails()
    }

    private fun getEventDetails() {
        val details = args.event
        binding.name.text = details?.client?.name
        binding.gender.text = details?.client?.gender
        binding.age.text = details?.client?.age
        binding.profession.text = details?.client?.occupation
        binding.date.text = details?.date
        binding.time.text = details?.startTime
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