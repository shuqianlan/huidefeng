package com.xihu.huidefeng.models

import androidx.lifecycle.MutableLiveData

class LoginStatus :MutableLiveData<Boolean>() {
	val loginStatus = MutableLiveData(true)
	
	fun isLogin() = loginStatus.value
	
	fun setStatus(isLogin:Boolean) {
		loginStatus.value = isLogin
	}
}