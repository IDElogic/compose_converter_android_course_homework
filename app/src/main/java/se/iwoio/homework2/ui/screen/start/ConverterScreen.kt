package se.iwoio.homework2.ui.screen.start

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.iwoio.homework2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen() {

    val context = LocalContext.current

    var numberText by rememberSaveable {
        mutableStateOf("1")
    }
    var textResult by rememberSaveable {
        mutableStateOf("0")
    }
    var inputErrorState by rememberSaveable {
        mutableStateOf(false)
    }

    fun validate(text: String) {
        val allDigit = text.all { char -> char.isDigit() }

        textResult = context.getString(R.string.error_empty)
        inputErrorState = !allDigit
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable{ },

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .padding(50.dp, 20.dp, 45.dp, 20.dp,),
                text = "Lenght Converter",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,

                )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                value = numberText,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                onValueChange = {
                    numberText = it
                    validate(numberText)
                },
                isError = inputErrorState,
                trailingIcon = {
                    if (inputErrorState)
                        Icon(
                            Icons.Filled.Warning,
                            "error", tint = MaterialTheme.colorScheme.error
                        )
                }
            )

            Column {
                Button(onClick = {
                    val kmValue = numberText.toFloat()
                    textResult = (kmValue * 0.621).toString()
                }) {
                    Text(text = "km -> miles")
                }
                Button(onClick = {
                    val milesValue = numberText.toFloat()
                    textResult = (milesValue * 0.621).toString()
                }) {
                    Text(text = "miles -> km")
                }

            }

            Text(
                text = textResult,
                modifier = Modifier
                    .padding(20.dp,),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary

            )

        }
    }
}




