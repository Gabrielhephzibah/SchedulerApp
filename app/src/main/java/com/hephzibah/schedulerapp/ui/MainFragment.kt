package com.hephzibah.schedulerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import com.google.android.material.tabs.TabLayoutMediator
import com.hephzibah.schedulerapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpFragmentAdapter()
    }

    private  fun setUpFragmentAdapter(){
        binding.viewPager.adapter = FragmentAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
           when(position){
               0 -> tab.text = "Events"
               1 -> tab.text = "Clients"
           }
        }.attach()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}