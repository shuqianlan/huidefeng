package com.xihu.huidefeng.ui.fragments

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.navigation.Navigation
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.goto_register
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment: BaseFragment() {
	override fun layoutId() = R.layout.fragment_login

	var isPassword = true
	override fun initView(v: View) {
		goto_register.setOnClickListener {
			navigationPopUpTo(v, null, R.id.action_loginFragment_to_registerFragment, false)
		}
		
		goto_login.setOnClickListener {
			Utils.isLogin = true
			navigationPopUpTo(v, null, R.id.action_loginFragment_to_mainActivity, true)
		}

		login_password_cont.endIconImageButton.setOnClickListener {
			println("isPassword: $isPassword")
			login_password.transformationMethod = if (isPassword) {
				HideReturnsTransformationMethod.getInstance()
			} else {
				PasswordTransformationMethod.getInstance()
			}

			isPassword = !isPassword
			login_password_cont.setEndIcon(if (!isPassword) R.drawable.eye_on else R.drawable.eye_off)
		}

		login_userid_cont.endIconImageButton.setOnClickListener {
			login_userid.setText("")
		}

	}
	
}