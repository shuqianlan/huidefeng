package com.xihu.huidefeng.ui.fragments

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.xihu.huidefeng.R
import kotlinx.android.synthetic.main.fragment_money.*

class MoneyFragment : BaseFragment() {
	override fun layoutId() = R.layout.fragment_money

	private val isScoreSelected = MutableLiveData<Boolean>(true)

	override fun initView(v: View) {
		money_score.isSelected=true
		money_balance.isSelected=false

		isScoreSelected.observe(activity!!, Observer {
			money_score.isSelected = it
			money_balance.isSelected = !it

			consume_value_cont.labelText = context!!.getString(if (it) R.string.user_show_score else R.string.user_show_commission)
			curr_score.text = "可用"+(if (it) "积分" else "佣金") + ":200"
		})

		money_balance.setOnClickListener {
			isScoreSelected.value = false
		}

		money_score.setOnClickListener {
			isScoreSelected.value = true
		}

		consume_sumbit.setOnClickListener {
			val value = consume_value.text
		}
	}
	
}
