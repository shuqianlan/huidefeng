package com.xihu.huidefeng.ui.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class BaseFragment: Fragment(), CoroutineScope by MainScope() {
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(layoutId(), container, false)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		initView()
	}
	
	abstract fun layoutId():Int
	abstract fun initView()
	
	open fun alterDialog(okStrId:Int, cancelStrId:Int, block: (() -> Unit)?=null) {
		AlertDialog.Builder(activity!!).apply {
			setTitle("是否退出App?")
			setMessage("退出将不会收到实时消息提示!")
			setNegativeButton(cancelStrId) { dialogInterface: DialogInterface, i: Int ->
				dialogInterface.dismiss()
			}
			
			setPositiveButton(okStrId) {dialogInterface, i ->
				println("成功退出:")
				dialogInterface.dismiss()
				block?.invoke()
			}
		}.show()
	}
}