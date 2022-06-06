package com.etoolkit.photoapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PhotoRetrofitCreate {

    private val BASE_URL = "https://api.unsplash.com"

    fun create() : PhotoApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PhotoApiService::class.java)
    }

}