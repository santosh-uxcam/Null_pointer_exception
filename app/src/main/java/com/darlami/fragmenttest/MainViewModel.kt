package com.darlami.fragmenttest

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val startClickEvent = SingleLiveEvent<Void>()

    fun onStartClick() {
        startClickEvent.call()
    }
}