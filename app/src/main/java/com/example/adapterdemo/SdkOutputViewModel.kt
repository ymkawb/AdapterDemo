package com.example.adapterdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class SdkOutputViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val mutableLiveData =  MutableLiveData<String>()

    val stringsData : LiveData<String> = mutableLiveData

    init {
        viewModelScope.launch {
            SdkOutput.instance.output.runningFold("") {acc,v ->
                "$acc\r\n$v"
            }.collect {
                mutableLiveData.postValue(it)
            }
        }
    }
}