package com.xihu.huidefeng.ui.fragments

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.xihu.huidefeng.R
import com.xihu.huidefeng.ui.activity.BaseActivity
import com.xihu.huidefeng.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.goto_register
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment: BaseFragment() {
	override fun layoutId() = R.layout.fragment_register

	var isPassword = true
	override fun initView(v: View) {
		goto_register.setOnClickListener {
			val phone = register_userid.text
			val password = register_password.text
			val invite_code = invitation_code.text

			if (phone.isNullOrEmpty() or password.isNullOrEmpty()) {
				Toast.makeText(context!!, R.string.warning_tips1, Toast.LENGTH_SHORT).show()
				return@setOnClickListener
			}

			if ((phone.length != 11) or !phone.isDigitsOnly()) {
				Toast.makeText(context!!, R.string.warning_tips2, Toast.LENGTH_SHORT).show()
				return@setOnClickListener
			}

			if (password.length < 6) {
				Toast.makeText(activity!!, R.string.warning_tips3, Toast.LENGTH_SHORT).show()
				return@setOnClickListener
			}

			Utils.isLogin = true
			navigationPopUpTo(v, null, R.id.action_registerFragment_to_mainActivity, true)
		}

		register_password_cont.endIconImageButton.setOnClickListener {
			register_password.transformationMethod = if (isPassword) {
				HideReturnsTransformationMethod.getInstance()
			} else {
				PasswordTransformationMethod.getInstance()
			}

			isPassword = !isPassword
			register_password_cont.setEndIcon(if (!isPassword) R.drawable.eye_on else R.drawable.eye_off)
		}

		register_user_cont.endIconImageButton.setOnClickListener {
			register_userid.setText("")
		}
	}
}