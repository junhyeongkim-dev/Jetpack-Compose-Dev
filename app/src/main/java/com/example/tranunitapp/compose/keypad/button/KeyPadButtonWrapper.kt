package com.example.tranunitapp.compose.keypad.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.tranunitapp.compose.keypad.model.KeyPadButton
import com.example.tranunitapp.ui.theme.TranUnitAppTheme


@Composable
fun RowScope.KeyPadButtonWrapper(
    keyPadButton: KeyPadButton
) {
    when(keyPadButton) {
        is KeyPadButton.ImageButton -> {
            ImageButton(
                image = keyPadButton.image,
                desc = keyPadButton.desc,
                color = keyPadButton.color,
                onclick = keyPadButton.onClick)
        }
        is KeyPadButton.TextButton -> {
            TextButton(
                text = keyPadButton.text,
                color = keyPadButton.color,
                onclick = keyPadButton.onClick
            )
        }
    }
}

@Composable
fun RowScope.CommonButton(
    color: Color,
    onclick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = Modifier
            .width(0.dp)
            .height(50.dp)
            .weight(1f),
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        content()
    }
}
@Composable
fun RowScope.TextButton(
    text: String,
    color: Color,
    onclick: () -> Unit
) {
    CommonButton(
        color,
        onclick
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            color = Color.Black,
            style = LocalTextStyle.current.copy(
                lineHeight = 2.5.em,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}

@Composable
fun RowScope.ImageButton(
    image: ImageVector,
    desc: String,
    color: Color,
    onclick: () -> Unit
) {
    CommonButton(
        color,
        onclick
    ) {
        Icon(
            imageVector = image,
            contentDescription = desc,
            tint = Color.Black
        )
    }
}

@Preview
@Composable
fun TextButtonPreview() {
    TranUnitAppTheme {
        Row {
            TextButton(text = "1", Color.White, {})
        }
    }
}

@Preview
@Composable
fun ImageButtonPreview() {
    TranUnitAppTheme {
        Row {
            ImageButton(Icons.Filled.ArrowBack, "뒤로가기", Color.Magenta, {})
        }
    }
}