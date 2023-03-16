package com.hephzibah.schedulerapp.ui.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hephzibah.schedulerapp.databinding.FragmentClientBinding
import com.hephzibah.schedulerapp.ui.main.MainFragmentDirections


class ClientFragment : Fragment() {
    private var _binding: FragmentClientBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClientViewModel by viewModels()
    private var adapter: ClientAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        setClient()
    }

    private fun setUpAdapter() {
        adapter = ClientAdapter {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToClientDetailFragment(it))
        }
        binding.recyclerView.adapter = adapter
    }

    private  fun setClient(){
        val item = viewModel.getClient()
        adapter?.submitList(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}