package com.darlami.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        // Observe the event
        viewModel.startClickEvent.observe(viewLifecycleOwner) { event ->
            Timber.d("Event observed")
            performAction()
        }

        // Simulate button click
        viewModel.onStartClick()
    }

    private fun performAction() {
        Timber.d("Performing action after event")
    }
}