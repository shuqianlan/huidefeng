package com.xihu.huidefeng.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseActivity: AppCompatActivity(), CoroutineScope by MainScope() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(layoutId())
		initView()
		initData()
	}
	
	override fun onDestroy() {
		super.onDestroy()
		cancel()
	}
	
	abstract fun layoutId():Int
	abstract fun initView()
	abstract fun initData()

	inline fun <reified T:AppCompatActivity> Activity.startActivity() {
		startActivity(Intent(this, T::class.java))
	}
	
	fun Activity.toast(msg:String, duration:Int=Toast.LENGTH_SHORT) {
		if (msg.isNotEmpty()) {
			Toast.makeText(this, msg, duration).show()
		}
	}
}