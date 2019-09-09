package com.xihu.huidefeng.ui.fragments


import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilifesmart.weatherdemoapi.adapters.KotlinDataAdapter

import com.xihu.huidefeng.R
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {
	
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_user, container, false)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//		user_items.adapter = KotlinDataAdapter.Builder()
	}
	
}
