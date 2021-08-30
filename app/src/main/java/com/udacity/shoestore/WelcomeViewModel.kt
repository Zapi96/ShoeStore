package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class WelcomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var _buttonInstructions = MutableLiveData<Boolean>()
    val buttonInstructions : LiveData<Boolean>
        get() = _buttonInstructions

    init {
        Timber.i("Created")
        _buttonInstructions.value = false
    }

    fun onShoeList(){
        Timber.i("onShoeList")
        _buttonInstructions.value = true
    }
}