package com.xihu.huidefeng.net.beans

data class UserInfoResponse(
		val phone:String,
		val invitation_code: String,
		val wechat_no:String,
		val idcard:String,
		val nick_name:String,
		val portrait:String,
		val bank_card:String,
		val card_name:String,
		val balance:Float,
		val score:Float,
		val commission:Float
)