package com.xihu.huidefeng.ui.utils

import android.app.Application
import com.google.gson.Gson
import com.xihu.huidefeng.YUAPP
import com.xihu.huidefeng.models.ConfigBean
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder

fun Application.initialize() {
	val context = YUAPP.context
	val reader = InputStreamReader(context.assets.open("config.json"), "UTF-8")
	reader.read()
	val bufferedReader = BufferedReader(reader)
	val builder = StringBuilder()
	var line:String?
	try {
		do {
			line = bufferedReader.readLine()
			if (line != null) {
				builder.append(line).append("\n")
			}
		} while (line != null)
		ConfigBean.instance = Gson().fromJson(builder.toString(), ConfigBean::class.java)
	} catch (exp:Exception) {
		exp.printStackTrace()
	}
}

object Utils {
	var isLogin = true
		set(value:Boolean) {
			field = value
		}
}