package com.example.instaapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instaapp.Api.ApiServer
import com.example.instaapp.Response.myResponse

class MainRepository(private val apiServer: ApiServer) {
    val dataLiveData= MutableLiveData<myResponse>()
    val data:LiveData<myResponse>
    get() = dataLiveData
    suspend fun getAllData(){
        val result=apiServer.getData()
        if(result.body()!=null && result.isSuccessful){
            dataLiveData.postValue(result.body())
        }
    }
}