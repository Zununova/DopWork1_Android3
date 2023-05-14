package com.example.dopwork1_android3.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var number : Int = 0
    private var _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    private val _changeColor = MutableLiveData<Boolean>()
    val changeColor: LiveData<Boolean> = Transformations.map(_count) { count ->
        count == 10 || count == -10
    }

    init {
        _changeColor.value = false
    }

    fun plus() {
        number ++
        _count.value = number
    }

    fun minus() {
        number --
        _count.value = number
    }
}
