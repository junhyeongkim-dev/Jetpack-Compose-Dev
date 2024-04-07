package com.example.tranunitapp.component.keypad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tranunitapp.KEY_PAD_BACK
import com.example.tranunitapp.component.keypad.button.KeyPadButtonWrapper
import com.example.tranunitapp.component.keypad.model.KeyPadButton
import com.example.tranunitapp.ui.theme.TranUnitAppTheme
import com.example.tranunitapp.viewmodel.IMainActivityInput

@Composable
fun KeyPad(
    input: IMainActivityInput
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(
                start = 5.dp,
                end = 5.dp,
                bottom = 5.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KeyPadRow {
            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("1"){
                    input.inputKeyPadValue("1")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("2"){
                    input.inputKeyPadValue("2")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("3"){
                    input.inputKeyPadValue("3")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.ImageButton(Icons.Filled.Done, "Done", Color.DarkGray){}
            )
        }

        KeyPadRow {
            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton(
                    text = "4"){
                    input.inputKeyPadValue("4")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("5"){
                    input.inputKeyPadValue("5")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("6"){
                    input.inputKeyPadValue("6")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.ImageButton(Icons.Filled.Add, "Add", Color.DarkGray){}
            )
        }

        KeyPadRow {
            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("7"){
                    input.inputKeyPadValue("7")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("8"){
                    input.inputKeyPadValue("8")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("9"){
                    input.inputKeyPadValue("9")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.ImageButton(Icons.Filled.ArrowBack, "ArrowBack", Color.Magenta){
                    input.inputKeyPadValue(KEY_PAD_BACK)
                }
            )
        }

        KeyPadRow{
            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton(","){}
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("0"){
                    input.inputKeyPadValue("0")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.TextButton("."){
                    input.inputKeyPadValue(".")
                }
            )
            Spacer(modifier = Modifier.size(5.dp))

            KeyPadButtonWrapper(
                keyPadButton = KeyPadButton.ImageButton(Icons.Filled.Check, "Check", Color.Blue){}
            )
        }
    }
}

@Composable
fun KeyPadRow(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.padding(
            top = 5.dp
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        content()
    }
}

@Preview
@Composable
fun KeyPadPreview() {
    TranUnitAppTheme {
//        KeyPad()
    }
}