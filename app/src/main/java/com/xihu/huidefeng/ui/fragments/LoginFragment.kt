package com.xihu.huidefeng.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: BaseFragment() {
	override fun layoutId() = R.layout.fragment_login
	
	override fun initView(v: View) {
		goto_register.setOnClickListener {
			navigationPopUpTo(v, null, R.id.action_loginFragment_to_registerFragment, false)
		}
		
		goto_login.setOnClickListener {
			Utils.isLogin = true
			navigationPopUpTo(v, null, R.id.action_loginFragment_to_mainActivity, true)
		}
	}
	
}