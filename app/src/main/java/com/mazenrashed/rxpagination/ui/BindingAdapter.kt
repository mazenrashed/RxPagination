package com.mazenrashed.rxpagination.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.CircleCropTransformation


@BindingAdapter("app:src")
fun loadUrlToImageView(imageView: ImageView, url : String) {
    imageView.load(url) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
}