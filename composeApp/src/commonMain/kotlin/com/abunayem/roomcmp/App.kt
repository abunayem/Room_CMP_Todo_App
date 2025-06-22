package com.abunayem.roomcmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.abunayem.roomcmp.ui.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}