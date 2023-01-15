package com.example.newsin.Component

import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsin.Navigation.Screen
import com.example.newsin.model.Article
import com.example.newsin.viewmodel.NewsViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsCard(article : Article, navController: NavController) {
    var expandedState by remember {
        mutableStateOf(false)
    }

    var liked by remember {
        mutableStateOf(false)
    }

    var viewmodel  = NewsViewModel()

    viewmodel.url = article.url




    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .animateContentSize(
            animationSpec = tween(
                200,
                easing = LinearOutSlowInEasing
            )
        ),

    shape = RoundedCornerShape(15.dp),
        onClick = {expandedState = !expandedState}
        ) {
        Column(modifier = Modifier
            .fillMaxWidth()
//            .padding(16.dp)

            ) {

            Box(modifier = Modifier.height(220.dp)){

                AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(article.urlToImage).crossfade(true).build(),
                    contentDescription = "news image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray),
                )
                if (!expandedState){

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable { !expandedState }
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color.Transparent, Color.Black)
                            )
                        ),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Box(
                            modifier = Modifier.clickable { expandedState = !expandedState }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable { expandedState = !expandedState },
                                horizontalAlignment = Alignment.Start

                            ) {
                                Text(text = "${article.title}" ,
                                    style = TextStyle(fontWeight = FontWeight.SemiBold , fontSize = 20.sp),

                                    )
                                Row(modifier = Modifier
                                    .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                    Text(text = "${article.source.name}" )

                                    Row(modifier = Modifier.width(100.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly) {
                                        if(!liked) {


                                            Icon(painter = painterResource(id = com.example.newsin.R.drawable.favorite_border),
                                                contentDescription = "outlined favourite",
                                                modifier = Modifier.clickable {liked = !liked })
                                        }else{
                                            Icon(painter = painterResource(id = com.example.newsin.R.drawable.favorite),
                                                contentDescription = "outlined favourite",
                                                modifier = Modifier.clickable {liked = !liked })
                                        }

                                        Icon(painter = painterResource(id = com.example.newsin.R.drawable.share),
                                            contentDescription = "outlined favourite")
                                        Icon(painter = painterResource(id = com.example.newsin.R.drawable.arrowout),
                                            contentDescription = "outlined favourite",
                                            modifier = Modifier.clickable { viewmodel.url = article.url })

                                    }

                                }
                            }

                        }

                    }
                }
            }


            if(expandedState){
                Box(
                    modifier = Modifier.clickable { expandedState = !expandedState }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { expandedState = !expandedState },
                        horizontalAlignment = Alignment.Start

                    ) {
                        Text(text = "${article.title}" ,
                            style = TextStyle(fontWeight = FontWeight.SemiBold , fontSize = 20.sp),

                            )
                        Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "${article.source.name}" )

                            Row(modifier = Modifier.width(100.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly) {
                                if(!liked) {


                                    Icon(painter = painterResource(id = com.example.newsin.R.drawable.favorite_border),
                                        contentDescription = "outlined favourite",
                                        modifier = Modifier.clickable {liked = !liked })
                                }else{
                                    Icon(painter = painterResource(id = com.example.newsin.R.drawable.favorite),
                                        contentDescription = "outlined favourite",
                                        modifier = Modifier.clickable {liked = !liked })
                                }

                                Icon(painter = painterResource(id = com.example.newsin.R.drawable.share),
                                    contentDescription = "outlined favourite")
                                Icon(painter = painterResource(id = com.example.newsin.R.drawable.arrowout),
                                    contentDescription = "outlined favourite",
                                    modifier = Modifier.clickable { navController.navigate(Screen.WebView.witharg(article.url)) })

                            }

                        }
                    }

                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "${article.description}" )




                }

            }

//
//
//            Spacer(modifier = Modifier.height(10.dp))
        }


    }
}


@Preview
@Composable
fun newsitemprev() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Icons.Outlined.Favorite
        Icons.Default.Share
        Icons.Default.MailOutline

    }
}