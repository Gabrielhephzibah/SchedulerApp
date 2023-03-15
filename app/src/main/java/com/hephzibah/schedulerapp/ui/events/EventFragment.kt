package com.hephzibah.schedulerapp.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hephzibah.schedulerapp.data.model.Event
import com.hephzibah.schedulerapp.databinding.FragmentEventBinding
import com.hephzibah.schedulerapp.ui.MainFragmentDirections
import com.hephzibah.schedulerapp.utils.extensions.collectLatest


class EventFragment : Fragment() {
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EventViewModel
    private var adapter: EventAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[EventViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        getEvent()

    }

    private fun setUpAdapter() {
        adapter = EventAdapter {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToEventDetailFragment2(it)
            )
        }
        binding.recyclerView.adapter = adapter
    }

    private fun getEvent() {
        viewLifecycleOwner.collectLatest(
            flow = viewModel.getEvents,
            action = ::setEvent
        )
    }

    private fun setEvent(response: List<Event>) {
        if (response.isEmpty()) binding.emptyEvent.visibility = View.VISIBLE else adapter?.submitList(response)

    }

//    private fun getnew() {
//        println("getcalled::::")
//        viewLifecycleOwner.lifecycleScope.launch {
//            println("HERELaunch")
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.getAllEvent().collectLatest {
//                    println("EVENT::::$it")
//                }
//            }
//        }
//    }

//    private fun setEvents(response: Event) {
//        println("EVENT::: $response")
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}