package com.example.newsin.Navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsin.Component.MainScreen
import com.example.newsin.Component.NewsWebView
import com.example.newsin.viewmodel.NewsViewModel

@Composable
fun Navigation(viewModel: NewsViewModel) {
    var navcontroller = rememberNavController()
    
    
    NavHost(navController = navcontroller, startDestination = Screen.MainScreen.route ){
        
        composable(route = Screen.MainScreen.route){
            MainScreen(viewModel = viewModel, navcontroller )
        }
        
        composable(route = Screen.WebView.route + "/{url}",
                arguments = listOf(
                    navArgument("url" ){
                        type = NavType.StringType
                        defaultValue = "https://boingboing.net/2022/12/28/right-wing-dating-app-a-flop.html"
                    }
                )
            ){entry ->
//            NewsWebView(url =  entry.arguments?.getString("url"))
            Text(text = "hello")
        }
        
        
    }
    
}