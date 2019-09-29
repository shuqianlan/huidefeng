package com.xihu.huidefeng.ui.activity

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController

import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
	private var currentNavController: LiveData<NavController>? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		if (savedInstanceState == null) {
			setupBottomNavigationBar()
		}
	}
	
	override fun layoutId(): Int = R.layout.activity_main
	
	override fun initView() {
		bottom_nav.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
	}
	
	override fun initData() {}
	
	private fun setupBottomNavigationBar() {
		val navGraphIds = listOf(
				R.navigation.bottom_nav_home,
				R.navigation.bottom_nav_money,
				R.navigation.bottom_nav_group,
				R.navigation.bottom_nav_user)
		
		val controller = bottom_nav.setupWithNavController(
				navGraphIds=navGraphIds,
				fragmentManager = supportFragmentManager,
				containerId = R.id.nav_host_container,
				intent = intent)
		
		controller.observe(this, Observer { navController ->
			setupActionBarWithNavController(navController) // 改变不同的MenuItem则刷新ActionBar的内容和图标.
		})
		
		currentNavController = controller
	}
	
	override fun onSupportNavigateUp(): Boolean {
		return currentNavController?.value?.navigateUp() ?: false
	}
}
