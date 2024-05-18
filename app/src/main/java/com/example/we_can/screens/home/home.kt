package com.example.we_can.screens.home



import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.we_can.R
import com.example.we_can.navigation.NavigationItem
import kotlinx.coroutines.delay
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import kotlinx.coroutines.delay

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Home(navController: NavController) {
//    val scrollState = rememberScrollState()
//    val text = "\uD83D\uDC4B Hello, Hero"
//    var visible by remember { mutableStateOf(true) }
//    var textLength by remember { mutableStateOf(0) }
//
//    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan)
//    var currentColorIndex by remember { mutableStateOf(0) }
//
//    // Animate color changes
//    val animatedColor by animateColorAsState(
//        targetValue = colors[currentColorIndex],
//        animationSpec = tween(durationMillis = 1000)
//    )
//
//    val animatedTextLength by animateIntAsState(
//        targetValue = textLength,
//        animationSpec = tween(durationMillis = 1000)
//    )
//
//    LaunchedEffect(Unit) {
//        delay(1000) // Delay before starting the animation
//        visible = false
//        delay(500) // Wait until the image fades out
//        textLength = text.length // Start writing the text
//    }
//
//    fun cycleColor() {
//        currentColorIndex = (currentColorIndex + 1) % colors.size
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Home") },
//                navigationIcon = {
//                    IconButton(onClick = { cycleColor() }) {
//                        androidx.compose.material3.Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { cycleColor() }) {
//                        androidx.compose.material3.Icon(imageVector = Icons.Filled.Search, contentDescription = null)
//                    }
//                }
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { cycleColor() }) {
//                androidx.compose.material3.Icon(imageVector = Icons.Filled.Create, contentDescription = null)
//            }
//        }
//    ) { paddingValues ->
//        Surface(color = animatedColor) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//                    .verticalScroll(scrollState)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.home_back) ,
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxSize()
//                )
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .scrollable(
//                            state = scrollState,
//                            enabled = true,
//                            orientation = Orientation.Vertical
//                        )
//                        .padding(16.dp)
//                ) {
//                    Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
//                        Text(
//                            text = text.substring(0, animatedTextLength),
//                            color = Color.Green,
//                            maxLines = 1,
//                            fontFamily = FontFamily.Monospace,
//                            fontStyle = FontStyle.Normal,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .background(
//                                    Color.White.copy(alpha = 0.8f),
//                                    shape = RoundedCornerShape(8.dp)
//                                )
//                                .padding(8.dp),
//                            textAlign = TextAlign.Center,
//                        )
//                    }
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 16.dp)
//                    ) {
//                        androidx.compose.animation.AnimatedVisibility(
//                            visible = visible,
//                            exit = fadeOut(animationSpec = tween(durationMillis = 1000))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.wecan),
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(10.dp))
//                            )
//                        }
//                    }
//                    Card(
//                        modifier = Modifier.fillMaxWidth(),
//                        elevation = CardDefaults.cardElevation(10.dp),
//                        colors = CardDefaults.cardColors(Color(0xFF7D5260)),
//                        shape = RoundedCornerShape(10.dp),
//                    ) {
//                        Column(
//                            modifier = Modifier.padding(16.dp)
//                        ) {
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalAlignment = Alignment.CenterVertically
//                            )
//                            //androidx.compose.material3.Text
//                            {
//                                Text(
//                                    text = "Try these steps next!",
//                                    fontStyle = FontStyle.Normal,
//                                    fontFamily = FontFamily.Monospace,
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier.weight(1f)
//                                )
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(
//                                        imageVector = Icons.Filled.ArrowForward,
//                                        contentDescription = null
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(16.dp))
//                            ListItem("Mark actions you already done")
//                            ListItem("Refine emission inputs")
//                            ListItem("Add new actions")
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(30.dp))
//                    ImageCard(R.drawable.nature, "✅ ACTIONS ACHIEVED")
//                    Spacer(modifier = Modifier.height(16.dp))
//                    ImageCard(R.drawable.emissions, "\uD83D\uDCF6 EMISSIONS SAVED!!")
//                    Spacer(modifier = Modifier.height(30.dp))
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(
//                                Color.Gray.copy(alpha = 0.2f),
//                                shape = RoundedCornerShape(10.dp)
//                            )
//                            .padding(16.dp)
//                    ) {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                text = "Become an Earth Hero by planting a tree",
//                                overflow = TextOverflow.Ellipsis,
//                                fontFamily = FontFamily.Monospace,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.weight(1f)
//                            )
//                            Image(
//                                painter = painterResource(id = R.drawable.earthhero),
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .size(100.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ListItem(text: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = text,
//            modifier = Modifier.weight(1f),
//            color = Color.White,
//            fontFamily = FontFamily.Monospace,
//        )
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Filled.ArrowForward,
//                contentDescription = null
//            )
//        }
//    }
//}
//
//@Composable
//fun ImageCard(imageResId: Int, text: String) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(Color.Gray.copy(alpha = 0.2f))
//    ) {
//        Image(
//            painter = painterResource(id = imageResId),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1.5f)
//                .clip(RoundedCornerShape(10.dp))
//        )
//        Text(
//            text = text,
//            color = Color.White,
//            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily.Monospace,
//            modifier = Modifier
//                .align(Alignment.Center)
//                .padding(16.dp)
//                .background(Color.Black.copy(alpha = 0.7f), shape = RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//    }
//}
//








@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val text = "\uD83D\uDC4B Hello, Hero"
    var visible by remember { mutableStateOf(true) }
    var textLength by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        delay(1000) // Delay before starting the animation
        visible = false
        delay(500) // Wait until the image fades out
        textLength = text.length // Start writing the text
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ }) {
                Icon(imageVector = Icons.Filled.Create, contentDescription = null)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.home_back),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp)
            ) {
                // Title
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Welcome Text
                Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(
                        text = text.substring(0, textLength),
                        color = Color.Green,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                            .background(
                                Color.White.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Animated Image
                Column(modifier = Modifier.fillMaxWidth()) {
                    AnimatedVisibility(
                        visible = visible,
                        exit = fadeOut(animationSpec = tween(durationMillis = 1000))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.wecan),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Action Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 10.dp,
                    backgroundColor = Color(0xFF7D5260),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Try these steps next!",
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { /* TODO */ }) {
                                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        ListItem("Mark actions you already done")
                        ListItem("Refine emission inputs")
                        ListItem("Add new actions")
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Achievements Cards
                ImageCard(R.drawable.nature, "✅ ACTIONS ACHIEVED")
                Spacer(modifier = Modifier.height(16.dp))
                ImageCard(R.drawable.emissions, "\uD83D\uDCF6 EMISSIONS SAVED!!")

                Spacer(modifier = Modifier.height(30.dp))

                // Promotion Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Become an Earth Hero by planting a tree",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.earthhero),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            color = Color.White,
            fontFamily = FontFamily.Monospace
        )
        IconButton(onClick = { /* TODO */ }) {
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
        }
    }
}

@Composable
fun ImageCard(imageResId: Int, text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray.copy(alpha = 0.2f))
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .background(Color.Black.copy(alpha = 0.7f), shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        )
    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
