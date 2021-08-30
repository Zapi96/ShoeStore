package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class InstructionsViewModel : ViewModel() {
    private var _buttonShoeList = MutableLiveData<Boolean>()
    val buttonShoeList : LiveData<Boolean>
        get() = _buttonShoeList

    init {
        Timber.i("Created")
        _buttonShoeList.value = false
    }

    fun onShoeList(){
        Timber.i("onShoeList")
        _buttonShoeList.value = true
    }
}