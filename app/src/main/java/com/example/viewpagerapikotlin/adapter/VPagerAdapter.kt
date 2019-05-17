package com.example.viewpagerapikotlin.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.viewpagerapikotlin.R
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

        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.pager_view, container, false)

        val imgView = view.findViewById<ImageView>(R.id.img_view)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)

        Picasso
            .get()
            .load(listImg?.get(position)?.img)
            .fit()
            .centerCrop()
            .into(imgView)

        tvTitle.text = listImg?.get(position)?.title

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as View)
    }
}