package com.xihu.huidefeng.ui.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

	override fun layoutId(): Int = R.layout.fragment_home
	
	override fun initView(v:View) {
		
		cardview.setOnClickListener {
			(activity as BaseActivity).showTopLoading(true)
		}
	}
}
