package com.example.snackify.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlin.math.log

class DataViewModel:ViewModel() {

    val state = mutableStateOf(About())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFirestore()
        }
    }

}


suspend fun getDataFromFirestore() : About{
    val db = FirebaseFirestore.getInstance()
    var about = About()

    try{
        db.collection("about").get().await().map {
            val result = it.toObject(About::class.java)
            about = result;




        }

    }catch (e:FirebaseFirestoreException){
        Log.d("error","get data from firestore : $e")
    }
    return about;
}