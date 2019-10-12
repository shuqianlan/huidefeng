package com.xihu.huidefeng.ui.views

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView

import com.google.android.material.tabs.TabLayout
import com.xihu.huidefeng.ui.utils.DensityUtils

import java.util.ArrayList
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xihu.huidefeng.R

class PopupLoadingWindow(private val mContext: Context) : PopupWindow(mContext) {

	private val mWindowWidth: Int
	private val mWindowHeight: Int

	init {
		val ret = IntArray(2)
		DensityUtils.getWindowSize(mContext, ret)

		mWindowWidth = ret[0]
		mWindowHeight = ret[1]

		width = (mWindowWidth*0.4).toInt()
		height = (mWindowWidth*0.4).toInt()
		isOutsideTouchable = false
		isFocusable = true
//				setAnimationStyle(R.style.popupRegionAnimation);
		setBackgroundDrawable(ColorDrawable(Color.BLACK))
		val v = LayoutInflater.from(mContext).inflate(R.layout.window_executing_loading, null, false)
		contentView = v

		initialize(mContext)
	}

	private fun initialize(context: Context) {
		setOnDismissListener { darkenBackground(1f) }
	}

	private fun darkenBackground(alpha: Float) {
//		if (alpha < 0.95f)
			(mContext as Activity).window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//		else
//			(mContext as Activity).window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

		val lp = mContext.window.attributes
		lp.alpha = alpha
		mContext.window.attributes = lp
	}
	
	fun show() {
		darkenBackground(0.5f)
		if (mContext is Activity) {
			val group = mContext.findViewById<ViewGroup>(Window.ID_ANDROID_CONTENT)
			showAsDropDown(group, mWindowWidth/2-width/2, (mWindowHeight*0.4).toInt()+height/2, Gravity.START)
//			showAsDropDown(group, 0, -mWindowHeight, Gravity.START)
		}
	}

}
