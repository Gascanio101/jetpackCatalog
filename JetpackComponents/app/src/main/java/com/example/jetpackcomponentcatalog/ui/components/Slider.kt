package com.example.jetpackcomponentcatalog.ui.components

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicSlider() {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(sliderPosition.toString())
    }
}

@Composable
fun MyAdvancedSlider() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        var completedPosition by rememberSaveable { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completedPosition = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9,
            enabled = true
        )
        Text(completedPosition)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by rememberSaveable { mutableStateOf(0f..5f) }
//    RangeSlider(values = currentRange, onValueChange = { currentRange = it })
}