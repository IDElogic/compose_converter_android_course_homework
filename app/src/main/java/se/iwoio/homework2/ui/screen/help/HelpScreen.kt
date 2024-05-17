package se.iwoio.homework2.ui.screen.help

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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

@Composable
fun HelpScreen() {

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
                text = "Temperature Converter",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,

                )

            Spacer(
                modifier = Modifier.height(20.dp))

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

            Column()  {
                Button(onClick = {
                    val celsiusValue = numberText.toFloat()
                    textResult = (celsiusValue * 33.8).toString()
                }) {
                    Text(text = "Celsius -> Fahrenheit")
                }
                Button(onClick = {
                    val fahrenheitValue = numberText.toFloat()
                    textResult = (fahrenheitValue * -17.22).toString()
                }) {
                    Text(text = "Fahrenheit -> Celsius")
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




