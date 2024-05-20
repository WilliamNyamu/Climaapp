package com.example.we_can.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.we_can.navigation.NavigationItem

@Composable
fun ProfilePage(viewModel: ProfileViewModel, navController: NavController) {
    val userProfile by viewModel.userProfile.collectAsState()

    var name by remember { mutableStateOf(userProfile.name) }
    var email by remember { mutableStateOf(userProfile.email) }
    var phone by remember { mutableStateOf(userProfile.phone) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? -> imageUri = uri }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        name?.let {
            OutlinedTextField(
                value = it,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        email?.let {
            OutlinedTextField(
                value = it,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )
        }
        phone?.let {
            OutlinedTextField(
                value = it,
                onValueChange = { phone = it },
                label = { Text("Phone") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(onClick = { launcher.launch("image/*") }) {
            Text("Select Profile Picture")
        }
        imageUri?.let {
            Image(
                painter = rememberImagePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        } ?: userProfile.profilePictureUrl.takeIf { it.isNotEmpty() }?.let {
            Image(
                painter = rememberImagePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        Button(
            onClick = {
                name?.let {
                    email?.let { it1 ->
                        phone?.let { it2 ->
                            viewModel.saveProfile(it, it1, it2, imageUri) {
                                navController.navigate(NavigationItem.Profile.route) // Navigate back to the previous screen
                            }
                        }
                    }
                }
            },
            enabled =
            name?.isNotEmpty() ?: false &&
                    email?.isNotEmpty() ?: false && phone?.isNotEmpty() ?: false
        ) {
            Text("Save Profile")
        }
    }
}

@Preview
@Composable
fun ProfilePagePreview() {
    val navController = rememberNavController() // This is just for the preview
    ProfilePage(ProfileViewModel(), navController)
}
