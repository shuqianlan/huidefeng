package com.xihu.huidefeng.ui.fragments

import android.os.Bundle
import android.view.View
import com.airbnb.lottie.utils.Utils
import com.xihu.huidefeng.R
import kotlinx.android.synthetic.main.fragment_login.*

class RegisterFragment: BaseFragment() {
	override fun layoutId() = R.layout.fragment_register
	
	override fun initView(v: View) {
		goto_register.setOnClickListener {
			com.xihu.huidefeng.ui.utils.Utils.isLogin = true
			navigationPopUpTo(v, null, R.id.action_registerFragment_to_mainActivity, true)
		}
	}
}