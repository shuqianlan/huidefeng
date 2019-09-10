package com.xihu.huidefeng.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xihu.huidefeng.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
	
	override fun layoutId(): Int = R.layout.activity_splash
	
	override fun initView() {}

	override fun initData() {
		launch {
			delay(1000)
			
			Intent(this@SplashActivity, MainActivity::class.java).also {
				it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
				startActivity(it)
			}
			finish()
		}
	}
}
