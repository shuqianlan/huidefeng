package com.xihu.huidefeng.ui.fragments

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.xihu.huidefeng.R
import com.xihu.huidefeng.net.base.BaseViewModelFragment
import com.xihu.huidefeng.net.jetpack.LoginViewModel
import com.xihu.huidefeng.net.repository.RemoteRepository
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment: BaseViewModelFragment<LoginViewModel>() {
	
	override fun layoutId() = R.layout.fragment_login
	var isPassword = true
	
	override fun providerVMClass()=LoginViewModel::class.java
	
	override fun initViewModel(context: AppCompatActivity): LoginViewModel {
		return super.initViewModel(context).apply {
			loginStatus.observe(activity!!, Observer {
				if (it != null) {
//					Utils.isLogin = true
//					navigationPopUpTo(goto_login, null, R.id.action_loginFragment_to_mainActivity, true)
				}
			})
		}
	}

	override fun initView(v: View) {
		goto_register.setOnClickListener {
			navigationPopUpTo(v, null, R.id.action_loginFragment_to_registerFragment, false)
		}
		
		goto_login.setOnClickListener {
			viewModel.login()
		}

		login_password_cont.endIconImageButton.setOnClickListener {
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