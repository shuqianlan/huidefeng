package com.xihu.huidefeng.ui.activity

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController

import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private var currentNavController: LiveData<NavController>? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		bottom_nav.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

		if (savedInstanceState == null) {
			setupBottomNavigationBar()
		}
	}

	private fun setupBottomNavigationBar() {
		val navGraphIds = listOf(
				R.navigation.bottom_nav_home,
				R.navigation.bottom_nav_money,
				R.navigation.bottom_nav_market,
				R.navigation.bottom_nav_user)
		
		val controller = bottom_nav.setupWithNavController(
				navGraphIds=navGraphIds,
				fragmentManager = supportFragmentManager,
				containerId = R.id.nav_host_container,
				intent = intent)
		
		controller.observe(this, Observer { navController ->
			setupActionBarWithNavController(navController)
		})
		
		currentNavController = controller
	}
	
	override fun onSupportNavigateUp(): Boolean {
		return currentNavController?.value?.navigateUp() ?: false
	}
}
