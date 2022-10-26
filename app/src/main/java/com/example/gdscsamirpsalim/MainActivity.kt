package com.example.gdscsamirpsalim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gdscsamirpsalim.ui.theme.GDSCSAMIRPSALIMTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDSCSAMIRPSALIMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(){
    DiceWithButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Preview
@Composable
fun DiceWithButton(modifier : Modifier = Modifier) {
    var count by remember { mutableStateOf(1) }
    var image= painterResource(id = R.drawable.dice_1)
    when (count)
    {1 -> image = painterResource(id = R.drawable.dice_1)
     2 -> image = painterResource(id = R.drawable.dice_2)
     3 -> image = painterResource(id = R.drawable.dice_3)
     4 -> image = painterResource(id = R.drawable.dice_4)
     5 -> image = painterResource(id = R.drawable.dice_5)
     6 -> image = painterResource(id = R.drawable.dice_6)
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, contentDescription ="1" )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count=roll() },
            contentPadding = PaddingValues(
                start = 30.dp,
                top = 12.dp,
                end = 30.dp,
                bottom = 12.dp
            )
        ) {
            Text(text = "ROLL")
        }
    }

}

fun roll() :Int{
    return (1..6).random()

}
