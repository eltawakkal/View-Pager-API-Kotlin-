package com.example.viewpagerapikotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.Toast
import com.example.viewpagerapikotlin.adapter.VPagerAdapter
import com.example.viewpagerapikotlin.retrofit.ApiClient
import com.example.viewpagerapikotlin.retrofit.ApiInterface
import com.example.viewpagerapikotlin.retrofit.ImgModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var pagerImg: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerImg = findViewById(R.id.pager_img)

        val apiInterface = ApiClient.getRetrofit?.create(ApiInterface::class.java)

        val callImg = apiInterface?.getImages()
        callImg?.enqueue (object : Callback<List<ImgModel>> {
            override fun onFailure(call: Call<List<ImgModel>>, t: Throwable) {
                Log.d("kesalahan", "Error: ${t.toString()}")
            }

            override fun onResponse(call: Call<List<ImgModel>>, response: Response<List<ImgModel>>) {
                val listImage = response.body()

                Log.d("oke", "response: ${listImage?.get(0)?.title}")

                setViewPagerItems(listImage)
            }

        })



    }

    private fun setViewPagerItems(listImage: List<ImgModel>?) {
        val adapter = VPagerAdapter(listImage, this)
        pagerImg.adapter = adapter
    }
}
