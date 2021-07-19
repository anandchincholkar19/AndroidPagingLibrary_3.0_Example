package com.example.androidpaginglibrary_30_example.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

const val BASE_URL = "https://api.instantwebtools.net/v1/"

 fun View.visible(isVisible:Boolean) {
   visibility = if (isVisible) View.VISIBLE else View.GONE
 }

 fun ImageView.loadImage(url:String?) {
   Glide.with(this).load(url).into(this)
 }