package com.xihu.huidefeng.ui

import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import androidx.annotation.IntegerRes
import androidx.databinding.BindingAdapter

@BindingAdapter("imageDrawable")
fun bindImageViewDrawable(view:ImageView, drawable:Drawable) {
	view.setImageDrawable(drawable)
}

@BindingAdapter("isGone")
fun bindIsGone(view:View, isGone:Boolean) {
	view.visibility = if (isGone) {
		View.GONE
	} else {
		View.VISIBLE
	}
}

