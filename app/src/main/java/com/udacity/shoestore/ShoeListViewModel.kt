package com.udacity.shoestore

import android.text.Editable
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    // TODO: Implement the ViewModel



    private var _buttonDetails = MutableLiveData<Boolean>()
    val buttonDetails : LiveData<Boolean>
        get() = _buttonDetails

    private var _buttonCancel = MutableLiveData<Boolean>()
    val buttonCancel : LiveData<Boolean>
        get() = _buttonCancel

    private var _buttonSave = MutableLiveData<Boolean>()
    val buttonSave : LiveData<Boolean>
        get() = _buttonSave

    private var _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private var _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private var _size = MutableLiveData<Float>()
    val size: LiveData<Float>
        get() = _size

    private var _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    private var _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe>
        get() = _newShoe

    private val shoelst =  mutableListOf<Shoe>()

    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList : LiveData<List<Shoe>>
        get() = _shoeList

//    init {
//        Timber.i("ShoelistCreated")
//
//        _buttonCancel.value = false
//        _buttonSave.value = false
//        _buttonDetails.value = false
//        _name.value = ""
//        _description.value = ""
//        _company.value = ""
//
//    }

    fun onCancel(){
        _buttonCancel.value = true
    }

    fun onCancelComplete(){
        _buttonCancel.value = false
    }

    fun onSave(){
        _buttonSave.value = true
        newShoe()
    }

    fun onSaveComplete(){
        _buttonSave.value = false
    }

    fun setName(s: Editable){
        _name.value = s.toString()
    }

    fun setDescription(s: Editable){
        _description.value = s.toString()
    }

    fun setCompany(s: Editable){
        _company.value = s.toString()
    }

    private fun newShoe(){
        shoelst += Shoe(_name.value.toString(),0.0,_company.value.toString(),_description.value.toString())
        _shoeList.value = shoelst
    }

    fun onDetails(){
        Timber.i("onShoeList")
        _buttonDetails.value = true
    }

    fun onDetailsComplete(){
        Timber.i("onShoeList")
        _buttonDetails.value = false
    }




}