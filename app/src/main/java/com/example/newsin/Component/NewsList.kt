package com.example.newsin.Component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.newsin.model.Article
import com.example.newsin.model.News

@Composable
fun NewsList(Articles:  List<Article>, navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()){
       items(Articles){article->
           NewsCard(article = article, navController )

        }
    }

    
    
}