package com.example.viewpagerapikotlin.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.viewpagerapikotlin.retrofit.ImgModel
import com.squareup.picasso.Picasso

class VPagerAdapter(val listImg: List<ImgModel>?, val context: Context) : PagerAdapter() {

    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun getCount(): Int {
        return listImg!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imgView = ImageView(context)

        Picasso
            .get()
            .load(listImg?.get(position)?.img)
            .fit()
            .centerCrop()
            .into(imgView)

        container.addView(imgView)

        return imgView
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as View)
    }
}