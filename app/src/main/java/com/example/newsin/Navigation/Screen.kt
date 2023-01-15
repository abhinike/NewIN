package com.example.newsin.Navigation

sealed class Screen(val route : String){
    object MainScreen : Screen("main_screen")
    object WebView : Screen("webview")

    fun witharg(vararg arg : String): String {
       return  buildString {
           append(route)
           forEach { arg
             append("/$arg")
           }
       }

    }

}

