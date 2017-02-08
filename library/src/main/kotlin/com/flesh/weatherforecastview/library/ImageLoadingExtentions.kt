package com.flesh.weatherforecastview.library

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

/**
 * Created by afleshner on 1/26/2017.
 * Simple wrapper class that allows you to choose which library you want to use.
 */

enum class IMAGE_LIB {
    PIC, GLIDE,
}

fun ImageView.loadImage(context: Context, url: String, lib: IMAGE_LIB) {
    when (lib) {
        IMAGE_LIB.PIC -> {
            this.UsePicasso(context, url)
        }
        IMAGE_LIB.GLIDE -> {
            this.UseGlide(context, url)
        }
        else -> {
            throw UnsupportedOperationException("IMAGE_LIB not selected use either ${IMAGE_LIB.PIC} or ${IMAGE_LIB.GLIDE}") //To change body of created functions use File | Settings | File Templates.
        }
    }
}


private fun ImageView.UsePicasso(context: Context, url: String) {
    val pic = Picasso.with(context.applicationContext)
    pic.load(url).into(this)
}
private fun ImageView.UsePicasso(context: Context, drawableInt: Int) {
    val pic = Picasso.with(context.applicationContext)
    pic.load(drawableInt).into(this)
}

private fun ImageView.UseGlide(context: Context, url: Any) {
    val glide = Glide.with(context.applicationContext)
    glide.load(url).into(this)
}


fun ImageView.loadLocalImage(context: Context, drawableInt: Int ) {
    this.UsePicasso(context,drawableInt)
}