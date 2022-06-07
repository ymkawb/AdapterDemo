package com.example.adapterdemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adapterdemo.databinding.SdkOutputFragmentBinding

class SdkOutputFragment : Fragment() {

    companion object {
        fun newInstance() = SdkOutputFragment()
    }

    private lateinit var viewModel: SdkOutputViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sdk_output_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SdkOutputViewModel::class.java]
        val bind = SdkOutputFragmentBinding.bind(view)
        bind.viewModel = viewModel
        bind.lifecycleOwner = viewLifecycleOwner
    }
}