package com.xihu.huidefeng.ui.fragments

import android.content.Intent
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.xihu.huidefeng.R
import kotlinx.android.synthetic.main.fragment_recharge.*

class TextFragment: BaseFragment() {
	override fun layoutId() = R.layout.fragment_recharge
	
	override fun initView(v: View) {
		show_text.text = getString(arguments!!.getInt(Intent.EXTRA_TEXT))
	}
	
}