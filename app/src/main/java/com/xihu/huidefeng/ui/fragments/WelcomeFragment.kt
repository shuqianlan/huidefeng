package com.xihu.huidefeng.ui.fragments

import android.os.Bundle
import android.view.View
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeFragment:BaseFragment() {
	
	override fun layoutId() = R.layout.fragment_welcome
	
	override fun initView(v:View) {
		launch {
			delay(1000)
			if (Utils.isLogin) {
				navigationPopUpTo(v, null, R.id.action_welcomeFragment_to_mainActivity, true)
			} else {
				navigationPopUpTo(v, null, R.id.action_welcomeFragment_to_loginFragment, false)
			}
		}
	}
	
}