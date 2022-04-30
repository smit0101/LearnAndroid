package com.smitmark.learnapp

import android.content.Intent
import com.smitmark.learnapp.ui.theme.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smitmark.learnapp.model.Product
import com.smitmark.learnapp.ui.theme.LearnAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){

    var value by remember {
        mutableStateOf("")
    }
    val listOFText = listOf("All", "Shoes", "Bag","Clothing","Cap","Pants","Blazer")
    val products = listOf(
        Product(R.drawable.one,"Nike Air Pegaus", secondTitle = "Your workhorse with wing returns", byCompany = "by Nike", price = 180),
        Product(R.drawable.two,"Nike ZoomX", secondTitle = "The Nike zoomX veporfly next clears", byCompany = "by Nike", price = 320),
        Product(R.drawable.one,"Nike Air Pegaus", secondTitle = "Your feet is jet", byCompany = "by Nike", price = 590),
    )               
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.horizontalGradient(
                listOf(JordiBlue, Cerulea)),
        shape = RoundedCornerShape(10.dp),
        alpha = 1.0F
    )
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Nike Collections", 
            color = Color.Black, 
            fontFamily = FontFamily.Default,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "The best of the nike, all in one place",
            color = Color.Gray,
            fontFamily = FontFamily.Default,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.size(15.dp))
        Row (Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp)){
            Box(modifier = Modifier
                .height(50.dp)
                .weight(1.0f)
                .shadow(elevation = 10.dp, clip = true, shape = RoundedCornerShape(10.dp))
                .clip(shape = RoundedCornerShape(6.dp))
                .background(BlueishWhite),
                contentAlignment = Alignment.CenterStart) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 10.dp)
                    )

                    TextField(value = value, onValueChange = {value=it},modifier = Modifier
                        .fillMaxSize(),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Gray,
                            disabledTextColor = Color.Transparent,
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                    textStyle = TextStyle(Color.Gray, fontFamily = FontFamily.Default,
                        fontSize = 20.sp),
                    )

                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Box(modifier = Modifier
                .height(50.dp)
                .weight(0.2f)
                .shadow(elevation = 10.dp, clip = true, shape = RoundedCornerShape(10.dp))
                .clip(shape = RoundedCornerShape(6.dp))
                .background(BlueishWhite),
                contentAlignment = Alignment.Center
                            ){
                Image(painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Search",
                    modifier = Modifier.size(30.dp))
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        if(value.isNotEmpty()){
            LazyRow(contentPadding = PaddingValues(10.dp)){
                items(value.length){
                    Box(modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .shadow(elevation = 10.dp, clip = true, shape = RoundedCornerShape(50.dp))
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Color.Black), contentAlignment = Alignment.Center){}
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyRow(modifier = Modifier.padding(20.dp)){
            items(items = listOFText){
                var enable by remember {mutableStateOf(false)}
                val textColor by animateColorAsState(targetValue = if(enable) Color.Black else Color.Gray)
                    Text(text = it,
                        color = textColor,
                        fontFamily = FontFamily.Default,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .graphicsLayer(alpha = 1.0f)
                            .clickable { enable = !enable },
                        )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn(Modifier.padding(10.dp)){
            items(products){
                var like by remember { mutableStateOf(false) }
                val likeImage by animateIntAsState(targetValue = if(like) R.drawable.heart else R.drawable.love)
                Card(elevation = 10.dp, modifier = Modifier.padding(bottom = 20.dp)){
                    Row(modifier = Modifier.padding(20.dp)){
                        Column(modifier = Modifier.weight(0.5f)
                            ) {
                            LikeButton(likeImage = likeImage) {
                                like = !like
                            }
                            Box(contentAlignment = Alignment.Center) {
                                Image(
                                    painter = painterResource(id = it.id),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(width = 200.dp, height = 100.dp)
                                        .background(Color.White)
                                )
                            }
                        }

                        Column(modifier= Modifier.weight(0.5f),

                            ) {
                            Text(text = it.mainTitle,
                                color = Color.Black,
                                fontFamily = FontFamily.Default,
                                fontSize = 20.sp,)
                            Text(text = it.byCompany,
                                color = Color.Gray,
                                fontFamily = FontFamily.Default,
                                fontSize = 12.sp,)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = it.secondTitle,
                                color = Color.Gray,
                                fontFamily = FontFamily.Default,
                                fontSize = 15.sp,)
                            Spacer(modifier = Modifier.size(20.dp))
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center) {
                                val context = LocalContext.current
                                Text(text = it.price.toString(),
                                    color = Color.Gray,
                                    fontFamily = FontFamily.Default,
                                    fontSize = 20.sp,)
                                Spacer(modifier = Modifier.size(20.dp))
                                Box(modifier = Modifier
                                    .shadow(
                                        elevation = 10.dp,
                                        clip = true,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(6.dp))
                                    .size(width = 90.dp, height = 40.dp)
                                    .background(Color.Black)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                SecondScreen::class.java
                                            )
                                        )
                                    },
                                    contentAlignment = Alignment.Center
                                    ) {
                                   Text(text = " Buy ",
                                       color = Color.White,
                                       fontFamily = FontFamily.Default,
                                       fontSize = 25.sp,)
                                }
                            }
                        }
                    }

                }
            }
        }

    }
       
}


@Composable
fun LikeButton(likeImage:Int,onClick:()->Unit){
    Box(modifier = Modifier
        .size(width = 50.dp, height = 50.dp)
        .clip(shape = RoundedCornerShape(50.dp))
        .clickable(onClick = onClick),
        contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = likeImage ) , contentDescription = "",
            modifier = Modifier
                .size(30.dp)
                .background(Color.White))
    }
}










@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnAppTheme {

    }
}