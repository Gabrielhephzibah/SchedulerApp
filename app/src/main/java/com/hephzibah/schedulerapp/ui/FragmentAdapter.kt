package com.hephzibah.schedulerapp.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hephzibah.schedulerapp.ui.clients.ClientFragment
import com.hephzibah.schedulerapp.ui.events.EventFragment

class FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
       return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 -> EventFragment()
           1 -> ClientFragment()
           else -> throw RuntimeException("Invalid position : $position")
       }
    }

}