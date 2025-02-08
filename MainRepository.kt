package com.example.smartscale.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository {
    fun getWeight(): Flow<String> = flow {
        // شبیه‌سازی دریافت وزن از سرور
        emit("0.00")
    }
}