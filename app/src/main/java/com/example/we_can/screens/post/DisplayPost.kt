package com.example.we_can.screens.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.we_can.navigation.BottomNavigationBar

//@Composable
//fun DisplayPostsScreen(viewModel: PostViewModel, navController: NavController) {
//    val posts by viewModel.posts.collectAsState(initial = emptyList())
//
//    LazyColumn(
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(posts) { post ->
//            PostItem(post)
//        }
//    }
//}
//
//@Composable
//fun PostItem(post: Post) {
//    Card (
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ){
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Box (
//                modifier = Modifier.padding(16.dp)
//            ){
//                Image(
//                    painter = rememberImagePainter(post.imageUrl),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .height(200.dp)
//                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(8.dp)),
//                    contentScale = ContentScale.Crop
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//                post.message?.let {
//                    Text(text = it,
//                        style = MaterialTheme.typography.bodyLarge,
//                        modifier = Modifier.padding(bottom = 8.dp)
//                    )
//
//                }
//            }
//
//        }
//
//    }
//
//}
//@Preview
//@Composable
//fun PostItemPreview() {
//    PostItem(Post("Hello, World!", "https://example.com/image.jpg"))
//}
//@Preview
//@Composable
//fun DisplayPostsScreenPreview() {
//    DisplayPostsScreen(viewModel = PostViewModel(), rememberNavController())
//}
//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayPostsScreen(viewModel: PostViewModel, navController: NavController) {
    val posts by viewModel.posts.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Posts") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer, titleContentColor = Color.White
                )
            )
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(posts) { post ->
                PostItem(post)
            }
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            if (post.imageUrl != null) {
                Image(
                    painter = rememberImagePainter(post.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Gray.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Image Placeholder",
                        tint = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            post.message?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PostItemPreview() {
    PostItem(Post("Hello, World!", "https://example.com/image.jpg"))
}

@Preview
@Composable
fun DisplayPostsScreenPreview() {
    DisplayPostsScreen(viewModel = PostViewModel(), rememberNavController())
}
