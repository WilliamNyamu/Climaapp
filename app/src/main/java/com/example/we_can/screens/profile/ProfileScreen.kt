package com.example.we_can.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.we_can.navigation.BottomNavigationBar

//@Composable
//fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController) {
//    val userProfile = viewModel.userProfile.collectAsState().value
//
//    Scaffold(
//        bottomBar = { BottomNavigationBar(navController = navController) },
//        containerColor = Color.DarkGray
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues = it),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            if (userProfile.profilePictureUrl.isNotEmpty()) {
//                Image(
//                    painter = rememberImagePainter(userProfile.profilePictureUrl),
//                    contentDescription = "Profile Picture",
//                    modifier = Modifier.size(128.dp).clip(CircleShape),
//                    contentScale = ContentScale.Crop
//                )
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(
//                text = "Name: ${userProfile.name}",
//                style = MaterialTheme.typography.titleSmall,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.Monospace,
//                modifier = Modifier.padding(16.dp)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(
//                text = "Email: ${userProfile.email}",
//                style = MaterialTheme.typography.bodyLarge,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.Monospace,
//                modifier = Modifier.padding(16.dp)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(
//                text = "Phone: ${userProfile.phone}",
//                style = MaterialTheme.typography.bodyLarge,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.Monospace,
//                modifier = Modifier.padding(16.dp)
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun ProfileScreenPreview() {
//    ProfileScreen(viewModel = ProfileViewModel(),rememberNavController())
//}
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import com.example.we_can.navigation.ROUTE_PROFILE_PAGE

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController) {
    val userProfile = viewModel.userProfile.collectAsState().value

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        containerColor = Color.DarkGray // Setting background color to dark grey
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray) // Ensure the background color covers the entire screen
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Position profile picture at the top
        ) {
            if (userProfile.profilePictureUrl.isNotEmpty()) {
                Image(
                    painter = rememberImagePainter(userProfile.profilePictureUrl),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(150.dp) // Increase the size of the profile picture
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            userProfile.name?.let {
                ProfileItem(
                    icon = Icons.Default.Person, // Replace with actual icon resource
                    text = it
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            userProfile.email?.let {
                ProfileItem(
                    icon = Icons.Default.Email, // Replace with actual icon resource
                    text = it
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            userProfile.phone?.let {
                ProfileItem(
                    icon = Icons.Default.Call, // Replace with actual icon resource
                    text = it
                )
            }
            Button(
                onClick = { navController.navigate(ROUTE_PROFILE_PAGE) },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(width = 200.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Green)

            ) {
                Text(text = "Edit Profile")
            }
        }
    }
}

@Composable
fun ProfileItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            ),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(viewModel = ProfileViewModel(), rememberNavController())
}
