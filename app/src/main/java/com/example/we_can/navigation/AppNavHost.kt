package com.example.we_can.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.we_can.SplashScreen
import com.example.we_can.authentication.LoginScreen
import com.example.we_can.authentication.RegisterScreen
import com.example.we_can.screens.actions.TopicList
import com.example.we_can.screens.actions.sampleTopics
import com.example.we_can.screens.data.DataScreen
import com.example.we_can.screens.home.HomeScreen
import com.example.we_can.screens.post.CreatePostScreen
import com.example.we_can.screens.post.DisplayPostsScreen
import com.example.we_can.screens.post.PostViewModel
import com.example.we_can.screens.profile.ProfilePage
import com.example.we_can.screens.profile.ProfileScreen
import com.example.we_can.screens.profile.ProfileViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String= ROUTE_REGISTER
) {
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route){ HomeScreen(navController) }
        composable(NavigationItem.Action.route){ TopicList(topic = sampleTopics, navController) }
        composable(NavigationItem.Data.route){ DataScreen(navController) }
        composable(NavigationItem.Profile.route){ ProfileScreen(viewModel = ProfileViewModel(), navController) }
//        composable(ROUTE_DATA){ Data()},
//        composable(ROUTE_PROFILE){ Profile()}
        composable(ROUTE_REGISTER){ RegisterScreen(navController)}
        composable(ROUTE_LOGIN){ LoginScreen(navController)}
        composable(ROUTE_SPLASH){ SplashScreen(navController)}
        composable(ROUTE_POST){CreatePostScreen(viewModel = PostViewModel(),navController)}
        composable(ROUTE_DISPLAY_POST){DisplayPostsScreen(viewModel = PostViewModel(),navController)}
        composable(ROUTE_PROFILE_PAGE){ProfilePage(viewModel = ProfileViewModel(),navController)}

    }
}



