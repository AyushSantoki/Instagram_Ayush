package com.example.instaapp.Api

import com.example.instaapp.Utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstence {
    companion object{
        private val retrofit= Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitServer:ApiServer by lazy {
            retrofit.create(ApiServer::class.java)
        }
    }
}