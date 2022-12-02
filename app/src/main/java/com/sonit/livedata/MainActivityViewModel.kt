package com.sonit.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
    private var total = 0

    private var total_ld =  MutableLiveData<Int>()
    val total_ld_secure : LiveData<Int>
        get() = total_ld


    private var newCounterValue = MutableLiveData<Int>()
    val _newCounterValue:LiveData<Int>
    get() = newCounterValue



    init {
        total_ld.value = startingTotal // setting to Livedata Value
        total = startingTotal// setting to private variable

        newCounterValue.value = 0
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

    fun triggerCounter(){
    newCounterValue.value = newCounterValue.value?.plus(1)
    }
}