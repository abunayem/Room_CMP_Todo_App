package com.abunayem.roomcmp

import androidx.compose.ui.window.ComposeUIViewController
import com.abunayem.roomcmp.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}