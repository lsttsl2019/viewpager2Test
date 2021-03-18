package com.example.fragmenttest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


enum class FragmentType {
    Downloading,
    Downloaded


}

class FragmentViewpagerAdapter(
    fm: FragmentManager,
    lifeCycle: Lifecycle,
    private var mainActivity: MainActivity
) : FragmentStateAdapter(fm, lifeCycle) {
    override fun getItemCount(): Int {
        return FragmentType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            FragmentType.Downloading.ordinal -> DownloadingFragment.newFragment()
            FragmentType.Downloaded.ordinal -> DownloadedFragment.newFragment()
            else -> Fragment()
        }
    }
}