package com.aerc.kotlinexpert

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.aerc.kotlinexpert.ui.App


fun main() {
    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}
