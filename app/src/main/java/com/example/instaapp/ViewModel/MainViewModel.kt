package com.example.instaapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.instaapp.Response.myResponse
import com.example.instaapp.Repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository):ViewModel() {
     fun getItems(){
         CoroutineScope(IO).launch{
             repository.getAllData()
         }
    }
    val data:LiveData<myResponse>
    get() = repository.data
}