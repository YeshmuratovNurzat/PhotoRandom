package com.etoolkit.photoapi.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.photoapi.api.PhotoRetrofitCreate
import com.etoolkit.photoapi.model.Photo
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel(){

    val liveDataRandomPhoto = MutableLiveData<Photo>()

    fun fetchRandomPhoto() : LiveData<Photo>{
        viewModelScope.launch {
            val randomPhoto = PhotoRetrofitCreate.create().photoRandom()
            liveDataRandomPhoto.value = randomPhoto
        }

        return liveDataRandomPhoto
    }


}