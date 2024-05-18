package com.example.we_can

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.we_can.navigation.AppNavHost
import com.example.we_can.navigation.BottomNavigationBar
import com.example.we_can.screens.actions.TopicList
import com.example.we_can.screens.actions.sampleTopics
import com.example.we_can.ui.theme.WE_CANTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WE_CANTheme {
                    MainScreen()
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    Scaffold (
        bottomBar = { BottomNavigationBar(rememberNavController()) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {

            }
        },
        containerColor = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WE_CANTheme {
        MainScreen()

    }
}