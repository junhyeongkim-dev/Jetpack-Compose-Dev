package com.example.tranunitapp.component.keypad.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class KeyPadButton(
    open val color: Color,
    open val onClick: () -> Unit
) {
    data class TextButton(
        val text: String,
        override val color: Color = Color.White,
        override val onClick: () -> Unit
    ): KeyPadButton(color, onClick)

    data class ImageButton(
        val image: ImageVector,
        val desc: String,
        override val color: Color,
        override val onClick: () -> Unit
    ): KeyPadButton(color, onClick)
}

