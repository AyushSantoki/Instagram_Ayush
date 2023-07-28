package com.example.instaapp.Api

import com.example.instaapp.Response.myResponse
import com.example.instaapp.Utils.END_URL
import com.example.instaapp.Utils.PROFILE_END_URL
import retrofit2.Response
import retrofit2.http.GET

interface ApiServer {
    @GET(END_URL)
    suspend fun getData():Response<myResponse>

    @GET(PROFILE_END_URL)
    suspend fun getProfile():Response<myResponse>
}