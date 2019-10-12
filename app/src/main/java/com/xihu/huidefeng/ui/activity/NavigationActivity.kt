package com.xihu.huidefeng.ui.activity

import android.content.Intent
import android.view.WindowManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NavigationActivity : BaseActivity() {
	
	override fun layoutId() = R.layout.activity_navigations

	override fun initView() {
		window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
	}
	
	override fun initData() {}
	
	override fun onBackPressed() {
		val fragment = supportFragmentManager.primaryNavigationFragment

		// popupto暂无效，手动设置.
		if (fragment is NavHostFragment) {
			when(fragment.navController.currentDestination?.id) {
				R.id.loginFragment -> finish()
				R.id.registerFragment -> fragment.navController.navigate(R.id.action_registerFragment_to_loginFragment)
			}
		}
	}

	override fun onSupportNavigateUp()=Navigation.findNavController(this, R.id.fragment).navigateUp()
}
