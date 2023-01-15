package com.example.newsin.Component

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsin.Navigation.Screen
import com.example.newsin.model.topBar
import com.example.newsin.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(viewModel: NewsViewModel, navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        

        BottomSheetScaffold(sheetContent = {
            NewsWebView()
        }) {
            Column() {
                topBar()
                NewsList(Articles = viewModel.NewsListResponse, navController = navController )
                viewModel.getNews(viewModel.queryForSearch)
            }
            
        }
        
      
    }

}