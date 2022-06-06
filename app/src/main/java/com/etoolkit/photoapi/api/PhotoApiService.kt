package com.etoolkit.photoapi.api

import com.etoolkit.photoapi.model.Photo
import retrofit2.http.GET

interface PhotoApiService {

    @GET("/photos/random/?client_id=QCoDIAXuyLJjINOdz0H86-3H9vwpKR6kFP3NJ2Gti-M")
    suspend fun photoRandom() : Photo

}