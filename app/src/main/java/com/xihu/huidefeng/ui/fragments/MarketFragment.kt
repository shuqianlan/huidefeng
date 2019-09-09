package com.xihu.huidefeng.ui.fragments


import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.xihu.huidefeng.R


/**
 * A simple [Fragment] subclass.
 */
class MarketFragment : Fragment() {


	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_market, container, false)
	}

}// Required empty public constructor
