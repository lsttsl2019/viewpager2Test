package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenttest.databinding.DownloadFragmentItem01Binding
import com.example.fragmenttest.databinding.DownloadFragmentItem02Binding

class DownloadingFragment : Fragment() {


    private var binding: DownloadFragmentItem01Binding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DownloadFragmentItem01Binding.inflate(
            inflater,
            container, false
        )
        return binding?.root
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    companion object {

        fun newFragment() = DownloadingFragment()

    }
}