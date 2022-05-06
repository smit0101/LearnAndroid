package com.smitmark.learnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smitmark.learnapp.ui.theme.LearnAppTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

class SecondScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                var value by remember{
                    mutableStateOf(0f)
                }
                TestTwo(value)
                Button(onClick = {
                    if(value > 360f || value < -360f ){ value = 0f}

                    value += 10f


                }) {
                    Text(text = "Plus",
                        color = Color.Red,
                        fontFamily = FontFamily.Default,
                        fontSize = 25.sp,)
                }
                Button(onClick = {

                    if(value > 360f || value < -360f ){ value = 0f}
                    value -= 10f}) {
                    Text(text = "Minus",
                        color = Color.Red,
                        fontFamily = FontFamily.Default,
                        fontSize = 25.sp,)
                }
            }
            }

    }
}


@Composable
fun Test(){
    LazyRow(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(2) {
            Box(
                Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(Color.Black)
            )
            // Spacer(modifier = Modifier.size(20.dp))

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TestTwo(value:Float){
    Column(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Black)
            ,verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally) {


            androidx.compose.foundation.Canvas(modifier = Modifier
                .size(200.dp), contentDescription = ""){

                drawArc(
                    color = Color.White,
                    sweepAngle = value,
                    startAngle = -90f,
                    useCenter = false,
                    style = Stroke(width = 100f, cap = StrokeCap.Round)
                )

            }
    }
}


@Preview
@Composable
fun TestThree(){
    Column(
        Modifier
            .size(200.dp)
            .drawBehind {
                drawArc(
                    color = Color.Black,
                    sweepAngle = 290f,
                    startAngle = -90f,
                    useCenter = false,
                    style = Stroke(width = 100f, cap = StrokeCap.Round),
                    size = size / 1.25f,
                )
            }, verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Black))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LearnAppTheme {
         TestTwo(260f)
    }
}

