package com.abunayem.roomcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.abunayem.roomcmp.di.desktopDatabaseModule
import com.abunayem.roomcmp.di.sharedModule
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(desktopDatabaseModule, sharedModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Room CMP",
    ) {
        App()
    }
}