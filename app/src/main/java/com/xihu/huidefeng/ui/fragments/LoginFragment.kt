package com.xihu.huidefeng.ui.fragments

import android.net.Network
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.activity.toast
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*
import kotlin.reflect.KProperty

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
		
		arrayOf(1,2,3,4,5,6)
	}
	
	init {
		Derived(BaseImpl(100)).print()
	}
	
	interface Base {
		fun print()
	}
	
	class BaseImpl(val x:Int) : Base {
		override fun print() {
			println("tt: $x")
		}
	}
	
	class Derived(b:Base) : Base by b
	
}