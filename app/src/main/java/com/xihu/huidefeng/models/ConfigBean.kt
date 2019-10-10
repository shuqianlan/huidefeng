package com.xihu.huidefeng.models

data class ConfigBean(
	val baseUrl: String,
	val readTimeout: Long,
	val connectTimeout: Long,
	val requestTimeout: Long
) {
	companion object {
		@JvmStatic
		lateinit var instance: ConfigBean
	}
	
	init {
		instance = this
	}
}