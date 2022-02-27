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
import androidx.compose.ui.graphics.Color
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
            .background(Color.Blue),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LearnAppTheme {

    }
}