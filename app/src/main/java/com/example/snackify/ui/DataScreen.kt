package com.example.snackify.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.snackify.model.DataViewModel

@Composable
fun DataScreen(
    dataViewModel: DataViewModel
){
    val getData = dataViewModel.state.value
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = getData.name)
        Text(text = getData.name)
        Text(text = getData.name)
        Text(text = getData.name)



    }

}