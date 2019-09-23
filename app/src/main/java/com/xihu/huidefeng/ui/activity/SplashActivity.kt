package com.xihu.huidefeng.ui.activity

import android.content.Intent
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
	
	override fun layoutId(): Int = R.layout.activity_splash
	
	override fun initView() {}

	override fun initData() {
		val i = Intent(this, NavigationActivity::class.java).apply {
			addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
		}
		startActivity(i)
		finish()
	}
	
	override fun finish() {
		super.finish()
		overridePendingTransition(0, 0)
	}
}
