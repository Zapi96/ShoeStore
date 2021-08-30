package com.udacity.shoestore

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var _buttonRegister = MutableLiveData<Boolean>()
    val buttonRegister : LiveData<Boolean>
        get() = _buttonRegister

    init {
        Timber.i("Created")
        _buttonRegister.value = false
    }


    fun onInstructions(){
        Timber.i("onInstructions")
        _buttonRegister.value = true
    }

    fun onInstructionsComplete(){
        Timber.i("onInstructions")
        _buttonRegister.value = false
    }
}