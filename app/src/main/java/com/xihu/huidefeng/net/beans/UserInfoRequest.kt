package com.xihu.huidefeng.net.beans

data class UserInfoRequest(
		val token:String,
		val wechat_no:String?=null,
		val idcard:String?=null,
		val name:String?=null,
		val nick_name:String?=null,
		val portrait:String?=null,
		val bank_card: String?=null,
		val bank_name:String?=null,
		val card_name:String?=null
)