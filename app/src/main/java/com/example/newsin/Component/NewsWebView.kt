package com.example.newsin.Component

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.newsin.viewmodel.NewsViewModel

@Composable
fun NewsWebView() {
    var viewmodel = NewsViewModel()
   var  url = viewmodel.url

    if (url != null) {

        AndroidView(factory = {


            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT

                )

                webViewClient = WebViewClient()
                loadUrl(url)
            }
        },
            update = {
                it.loadUrl(url)
            }
        )
    }else{
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "ERROR 404")
        }
    }
}