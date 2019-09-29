package com.xihu.huidefeng.net.jetpack

import androidx.lifecycle.MutableLiveData
import com.xihu.huidefeng.net.base.BaseViewModel
import com.xihu.huidefeng.net.beans.LoginResponse
import com.xihu.huidefeng.net.repository.RemoteRepository

class RegisterViewModel : BaseViewModel() {
	
	// 在Activity或Fragment中onCreate监听的时候开始调用，在生命周期在OnResume的时候触发UI刷新.
	private val response: MutableLiveData<LoginResponse> by lazy {
		MutableLiveData<LoginResponse>().also {
			loadDatas()
		}
	}
	
	fun loadDatas() = launchUI {
		val result = RemoteRepository.getInstance().login()
		response.value = result.data
	}
}