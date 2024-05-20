package com.example.we_can.screens.actions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.we_can.navigation.BottomNavigationBar

@Composable
fun TopicList(topic: List<Topic>, navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState())
        ){
            Box(
                modifier = Modifier.padding(16.dp).padding(top = 36.dp).align(Alignment.CenterHorizontally)
            ) {
                Text(text = "WE CAN \uD83E\uDD32, TAKE ACTION TODAY \uD83D\uDCAA\uD83C\uDFFE")
            }
            topic.forEach { topic ->
                AccordionItem(topic = topic, navController)
            }
        }
    }
}

@Preview
@Composable
fun TopicListPreview() {
    TopicList(sampleTopics, rememberNavController())
}