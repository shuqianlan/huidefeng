package com.xihu.huidefeng.models

import android.app.Activity
import com.xihu.huidefeng.net.base.BaseViewModelActivity
import kotlin.reflect.KProperty

/** 委托属性-代理实现(DEBUG) */
class Delegate {
	operator fun getValue(thisRef:Any?, property: KProperty<*>): String {
		return "$thisRef, thank you for delegating '${property.name}' to me!"
	}
	
	operator fun setValue(thisRef:Any?, property: KProperty<*>, value:String) {
		println("$value has been assigned to '${property.name}' in $thisRef.")
	}
}