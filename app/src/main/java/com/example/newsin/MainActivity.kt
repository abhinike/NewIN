package com.example.newsin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsin.Component.NewsList
import com.example.newsin.Component.NewsWebView
import com.example.newsin.Navigation.Navigation
import com.example.newsin.model.topBar
import com.example.newsin.network.getNews
import com.example.newsin.ui.theme.NewsINTheme
import com.example.newsin.viewmodel.NewsViewModel
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsINTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
//                        topBar()
//                        NewsList()
//                        viewModel.getNews(viewModel.queryForSearch)
                        
                        Navigation(viewModel = viewModel)
//                        NewsWebView(url = "https://boingboing.net/2022/12/28/right-wing-dating-app-a-flop.html")
                    }



//                    NewsWebView(url = "https://boingboing.net/2022/12/28/right-wing-dating-app-a-flop.html")



                }
            }
        }

        

//viewModel.getNews("in")


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {


}