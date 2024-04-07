package com.example.tranunitapp.component.keypad

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tranunitapp.R
import com.example.tranunitapp.ui.theme.TranUnitAppTheme
import com.example.tranunitapp.viewmodel.IMainActivityInput
import com.example.tranunitapp.viewmodel.IMainActivityOutput
import com.example.tranunitapp.types.UnitType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.Content(
    output: IMainActivityOutput,
    input: IMainActivityInput
) {
    val inputUnitType by output.inputUnitType.observeAsState()
    val outputUnitType by output.outputUnitType.observeAsState()
    val inputValue by output.inputValue.observeAsState("0")
    val outputValue by output.outputValue.observeAsState("0")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.dp)
            .weight(1f)
    ){
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    modifier = Modifier
                        .width(240.dp)
                        .background(Color.White),
                    readOnly = true,
                    value = inputValue,
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = "${getUnit(outputUnitType!!)} 값을 입력해주세요.",
                            color = Color.Green,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.size(10.dp))

                UnitText(getUnit(inputUnitType!!))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Card(
                    modifier = Modifier
                        .size(50.dp),
                    onClick = {
                        input.changeUnit()
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RectangleShape)
                            .background(Color.White),
                        painter = painterResource(id = R.drawable.change),
                        contentDescription = "Change Image",
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = getDecimalFormat(outputValue),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )

                UnitText(getUnit(outputUnitType!!))
            }
        }
    }
}

fun getDecimalFormat(value: String) : String {
    return if(value.toFloat() == 0f) {
        "0.0"
    }else if(value.toFloat() < 1){
        value
    } else{
        if(value.contains(".")) {
            val integerTemp = value.split(".")[0]
            val decimalTemp = value.split(".")[1]

            DecimalFormat("#,###").format(integerTemp.toLong()) + "." + decimalTemp
        }else {
            DecimalFormat("#,###").format(value)
        }
    }
}

fun getUnit(unitType: UnitType) : String {
    return when(unitType) {
        UnitType.CM -> "cm"
        UnitType.M -> "m"
    }
}


@Composable
fun UnitText(
    text: String
) {
    Text(
        modifier = Modifier.padding(
            start = 10.dp
        ),
        text = text,
        color = Color.Gray,
        fontSize = 15.sp
    )
}

@Preview
@Composable
fun ContentPreview() {
    TranUnitAppTheme {
        Column {
//            Content()
        }
    }
}