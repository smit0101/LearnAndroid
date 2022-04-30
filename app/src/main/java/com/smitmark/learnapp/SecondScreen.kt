package com.smitmark.learnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smitmark.learnapp.ui.theme.LearnAppTheme

class SecondScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Test()
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
        items(4) {
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

@Preview
@Composable
fun TestTwo(){
    Column(
        Modifier
            .size(300.dp)
            .drawBehind {
                drawArc(
                    color = Color.Black,
                    sweepAngle = 260f,
                    startAngle = -90f,
                    useCenter = false,
                    style = Stroke(width = 20f, cap = StrokeCap.Round),
                    size = size / 1.25f,
                )
            }, verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Test()

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LearnAppTheme {
         TestTwo()
    }
}