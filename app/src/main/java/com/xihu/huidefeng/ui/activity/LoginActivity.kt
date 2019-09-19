package com.xihu.huidefeng.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.xihu.huidefeng.R

class LoginActivity : BaseActivity() {
	
	override fun layoutId() = R.layout.activity_login

	override fun initView() {
	
	}
	
	override fun initData() {
	
	}
	
	// 单Activity的可行性探究.
	override fun onNavigateUp(): Boolean {
		val rtn = super.onNavigateUp()
		println("onNavigateUp .... $rtn")
		return rtn
	}
	
	override fun onBackPressed() {
//		println("onbackPressed ... ${onSupportNavigateUp()}")
		
		val fragment = supportFragmentManager.findFragmentById(R.id.fragment)
		val destination = NavHostFragment.findNavController(fragment!!).currentDestination?.navigatorName
		println("destination: $destination")
		if (destination == null) {
			return
		}
		
		
		super.onBackPressed()
	}
	
	override fun onSupportNavigateUp(): Boolean {
		val fragment = supportFragmentManager.findFragmentById(R.id.fragment)
		val rtn = NavHostFragment.findNavController(fragment!!).navigateUp()
		
		println("onSupportNavigateUp: $rtn")
		return rtn
	}
	
	override fun onDestroy() {
		super.onDestroy()
	}
	
}
