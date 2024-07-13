package com.example.two.trees

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"
private const val PRICE_PER_CAN_OF_OLIVES = 5

class MainViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity

    private val _totalAmount = MutableStateFlow(0)
    val totalAmount: StateFlow<Int> = _totalAmount

    init {
        Log.i(TAG, "initialized")
    }

    fun increaseQuantity() {
        _quantity.value += 1
    }

    fun decreaseQuantity() {
        if (_quantity.value > 0) _quantity.value -= 1
    }

    fun checkout() {
        _totalAmount.value = _quantity.value * PRICE_PER_CAN_OF_OLIVES
    }

}
