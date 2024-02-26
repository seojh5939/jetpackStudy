package com.jh.databindingstudy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class MainViewModelFactory(private val _counter: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(_counter) as T
        }
        return super.create(modelClass, extras)
    }
}

class MainViewModel(private val _counter: Int): ViewModel() {
    private var _liveData = MutableLiveData<Int>(_counter)
    val liveData get() = _liveData
    val hasChecked = MutableLiveData<Boolean>(false)

    fun increment() {
        _liveData.value = liveData.value?.plus(10)
    }

    fun getCountData(): String {
        return liveData.value.toString()
    }
}