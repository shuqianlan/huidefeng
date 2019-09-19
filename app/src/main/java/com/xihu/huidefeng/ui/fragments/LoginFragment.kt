package com.xihu.huidefeng.ui.fragments

import androidx.navigation.Navigation
import com.xihu.huidefeng.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: BaseFragment() {
	override fun layoutId() = R.layout.fragment_login
	
	override fun initView() {
		login_cont.setOnClickListener {
			Navigation.findNavController(login_cont).navigate(R.id.action_loginFragment_to_registerFragment)
		}
	}
	
}