package com.example.smartscale.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartscale.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _weight = MutableStateFlow("0.00")
    val weight: StateFlow<String> = _weight

    private val _unitPrice = MutableStateFlow("0")
    val unitPrice: StateFlow<String> = _unitPrice

    private val _totalPrice = MutableStateFlow("0")
    val totalPrice: StateFlow<String> = _totalPrice

    init {
        viewModelScope.launch {
            repository.getWeight().collect { weight ->
                _weight.value = weight
                calculateTotalPrice()
            }
        }
    }

    private fun calculateTotalPrice() {
        val weightValue = _weight.value.toDoubleOrNull() ?: 0.0
        val unitPriceValue = _unitPrice.value.toIntOrNull() ?: 0
        _totalPrice.value = (weightValue * unitPriceValue).toString()
    }

    fun navigateToMenu() {
        // Navigate to menu screen
    }
}