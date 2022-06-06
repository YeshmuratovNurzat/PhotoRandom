package com.etoolkit.photoapi.model

class Photo(
    val description: String,
    val id: String,
    val location: Location,
    val urls: Urls,
    val user: User,
) {}