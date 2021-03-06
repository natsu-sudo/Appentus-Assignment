package com.assignment.appentus.network

import com.assignment.appentus.util.Constants
import com.assignment.appentus.pojo.ImageURL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {
    companion object{


        private val retrofitService by lazy {

            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        fun getInstance():ApiService= retrofitService
    }

    @GET(Constants.LIST + "?")
    suspend fun getImageList(@Query(Constants.PAGE)pageNumber:Int): Response<List<ImageURL>>


}