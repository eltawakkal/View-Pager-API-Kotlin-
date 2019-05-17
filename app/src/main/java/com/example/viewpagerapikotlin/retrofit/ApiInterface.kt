package com.example.viewpagerapikotlin.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("rpld/xample-img.php")
    fun getImages() : Call<List<ImgModel>>

}