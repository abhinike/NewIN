package com.example.newsin.model

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
//import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
//import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsin.R
import com.example.newsin.viewmodel.NewsViewModel

@Composable
fun topBar() {
    var text by remember{
        mutableStateOf("")
    }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = true
    val colors = TextFieldDefaults.outlinedTextFieldColors()
    val viewmodel = NewsViewModel()


    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            TextField(value = text,

                onValueChange = {text = it
                                } ,
                placeholder = { Icon(painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "icon")},
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
//

                singleLine = true,
                interactionSource = interactionSource,
                enabled = enabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
//                       text = "hello fool stop searching"

                    }
                )



            )




        }

//        Row() {
//            Button(onClick = { viewmodel.getNews(viewmodel.queryForSearch)}) {
//                Icons.Default.Search
//            }
//
//        }






    }
}

@Preview
@Composable
fun top() {
    topBar()
}