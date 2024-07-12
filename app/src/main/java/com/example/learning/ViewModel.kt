package com.example.learning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//here we write all the business logic and persistence of data which is lost  --> MVVM(life without Design pattern)
//here imp is mutable live data

//its data is viewed by the fragments with help of [by activityviewmodel] or [by viewmodel]

class ViewModel:ViewModel() {

    private var dataareviewed = MutableLiveData<Int>()//we are here mutating the live data

    //since its a private object so use getter and setter
    fun getdataareviewed():LiveData<Int>{
        return dataareviewed//we are returning here livedata
    }

    init {
        //same as constructor  --> whenever a viewModel object is created we have initialize a constructor and we do it using
        dataareviewed.value=0 //so for live data((manipulating) data) we have to use .value
    }

    fun increament(){
        dataareviewed.value=dataareviewed.value!!+1 //i'm marking it that the value will never be null
    }

    fun decreament(){
        dataareviewed.value=dataareviewed.value!!-1 //i'm marking it that the value will never be null
    }

}