package com.xihu.huidefeng.ui.fragments

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ilifesmart.weatherdemoapi.adapters.KotlinDataAdapter
import com.xihu.huidefeng.R
import kotlinx.android.synthetic.main.fragment_group.*

class GroupFragment : BaseFragment() {

	private val datas = MutableLiveData<List<ItemBean>>()
	override fun layoutId(): Int = R.layout.fragment_group

	init {
		val _datas = mutableListOf<ItemBean>()
	    for (i in 0..20)  {
			_datas.add(i, ItemBean("Item-"+(i+1), 10.0f*i))
		}
		datas.value = _datas
	}

	override fun initView(v: View) {
//		group_items.adapter = KotlinDataAdapter<>
		datas.observe(activity!!, Observer {
			group_items.adapter!!.notifyDataSetChanged()
		})
	}

	data class ItemBean(val nick:String, val banance:Float)
}
