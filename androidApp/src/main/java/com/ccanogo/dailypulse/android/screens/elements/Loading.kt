package com.ccanogo.dailypulse.android.screens.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun Loading() {
    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        // verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator()
    }
}