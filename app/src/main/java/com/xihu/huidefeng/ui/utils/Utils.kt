package com.xihu.huidefeng.ui.utils

class Utils {
	
	companion object {
		var isLogin:Boolean = false
			set(value:Boolean) {
				println("wtf: $value")
				field = value
			}
	}
}