package com.xihu.huidefeng.net.beans

class ScoreHistory (list:List<HistoryBean>) {
	inner class HistoryBean(
			flag:Int,
			date:String,
			tag:Int,
			score:Float
	)
}