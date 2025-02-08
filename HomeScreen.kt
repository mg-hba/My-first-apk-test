package com.example.smartscale.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartscale.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val weight by viewModel.weight.collectAsState()
    val unitPrice by viewModel.unitPrice.collectAsState()
    val totalPrice by viewModel.totalPrice.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        // ردیف اول
        Row {
            ValueBox(label = "وزن", value = weight, unit = "kg")
            Spacer(modifier = Modifier.width(16.dp))
            ValueBox(label = "قیمت واحد", value = unitPrice, unit = "Toman")
        }
        
        // ردیف دوم
        Row {
            ValueBox(label = "قیمت کل", value = totalPrice, unit = "Toman")
        }

        // دکمه منو
        IconButton(onClick = { viewModel.navigateToMenu() }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
    }
}

@Composable
fun ValueBox(label: String, value: String, unit: String) {
    Column {
        Text(text = label, style = MaterialTheme.typography.h6)
        Text(text = "$value $unit", style = MaterialTheme.typography.body1)
    }
}