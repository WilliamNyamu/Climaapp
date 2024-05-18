package com.example.we_can.navigation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.we_can.R

@Composable
fun TopApp(){
    TopAppBar(
        backgroundColor = Color.DarkGray,
    ) {

        Image(
            painter = painterResource(id = R.drawable.applogo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(220.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)

            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null, )
        }
    }
}
@Preview
@Composable
fun TopAppPreview(){
    TopApp()
}