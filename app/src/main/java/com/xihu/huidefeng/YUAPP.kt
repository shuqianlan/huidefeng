package com.xihu.huidefeng

import android.app.Application
import android.content.Context
import com.xihu.huidefeng.ui.utils.initialize

class YUAPP : Application() {

	companion object {
		lateinit var context:Context
	}
	override fun onCreate() {
		super.onCreate()
		
		context = applicationContext
		initialize()
	}
}
