package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmenttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var downloadViewPagerAdapter: FragmentViewpagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewpagerInit()
        clickEvent()
    }


    private fun viewpagerInit() {

        downloadViewPagerAdapter = FragmentViewpagerAdapter(supportFragmentManager, lifecycle, this@MainActivity)
        binding.mainViewpager.offscreenPageLimit = 2
        binding.mainViewpager.adapter = downloadViewPagerAdapter

        binding.mainViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.mainViewpager.isUserInputEnabled = true
        binding.mainViewpager.currentItem = FragmentType.Downloading.ordinal
    }


    private fun clickEvent() {
        binding.img01.setOnClickListener(onClickListener)
        binding.img02.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            binding.img01.id -> {
                switchMainTab(FragmentType.Downloading)
            }
            binding.img02.id ->{
                switchMainTab(FragmentType.Downloaded)
            }
        }

    }

    private fun switchMainTab(tab: FragmentType) {
        binding.mainViewpager.setCurrentItem(tab.ordinal, true)
    }


}