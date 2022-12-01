package com.sonit.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
    private var total = 0
    private var total_ld =  MutableLiveData<Int>()

    val total_ld_secure : LiveData<Int>
    get() = total_ld

    init {
        total_ld.value = startingTotal // setting to Livedata Value
        total = startingTotal// setting to private variable
    }

    fun getTotal():Int{
        return total
    }

    fun setTotal(input:Int){
        total +=input
    }

    fun setTotalUsingLivedata(input:Int){
        total_ld.value = (total_ld.value)?.plus(input)
    }
}