package com.example.we_can.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.we_can.navigation.BottomNavigationBar

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController) {
    val userProfile = viewModel.userProfile.collectAsState().value

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (userProfile.profilePictureUrl.isNotEmpty()) {
                Image(
                    painter = rememberImagePainter(userProfile.profilePictureUrl),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Name: ${userProfile.name}", style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Email: ${userProfile.email}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Phone: ${userProfile.phone}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(viewModel = ProfileViewModel(),rememberNavController())
}
