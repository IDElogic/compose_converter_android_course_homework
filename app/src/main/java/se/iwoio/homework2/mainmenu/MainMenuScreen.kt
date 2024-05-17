package se.iwoio.homework2.mainmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainMenuScreen(
    onNavigateToGame: () -> Unit,
    onNavigateToHelp: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable{ },

        ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .padding(50.dp, 20.dp, 45.dp, 20.dp,),
                text = "Compose Converters",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,

                )

            Spacer(
                modifier = modifier.height(20.dp)
            )

            OutlinedButton(
                modifier = Modifier.requiredWidth(200.dp),
                onClick = onNavigateToGame
            ) {
                Text("lenght")
            }
            OutlinedButton(
                modifier = Modifier.requiredWidth(200.dp),
                onClick = {
                    navController.navigate("aboutscreen")
                }
            ) {
                Text("weight")
            }
            OutlinedButton(
                modifier = Modifier.requiredWidth(200.dp),
                onClick = {
                    onNavigateToHelp()
                }
            ) {
                Text("temperature")
            }
        }
    }
}
