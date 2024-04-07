package com.example.tranunitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tranunitapp.compose.keypad.Content
import com.example.tranunitapp.compose.keypad.KeyPad
import com.example.tranunitapp.ui.theme.TranUnitAppTheme
import com.example.tranunitapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranUnitAppTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main(mainViewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Content(
            input = mainViewModel.input,
            output = mainViewModel.output
        )
        KeyPad(mainViewModel.input)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TranUnitAppTheme {
        Main()
    }
}