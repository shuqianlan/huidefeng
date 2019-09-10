package com.xihu.huidefeng.ui.fragments


import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilifesmart.weatherdemoapi.adapters.KotlinDataAdapter

import com.xihu.huidefeng.R
import com.xihu.huidefeng.databinding.LayoutUserItemHolderBinding
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {
	
	init {
	
	}
	private val datas = mutableListOf<ItemBean>()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_user, container, false)
	}
	
	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		
	}
	
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		datas.apply {
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_recharge), R.drawable.recharge))
			add(ItemBean(getString(R.string.user_balance), R.drawable.balance))
			add(ItemBean(getString(R.string.user_score), R.drawable.score))
			add(ItemBean(getString(R.string.user_withdraw), R.drawable.withdraw))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_atlas), R.drawable.vip_atlas))
			add(ItemBean(getString(R.string.user_notice), R.drawable.vip_notice))
			add(ItemBean(getString(R.string.user_security), R.drawable.security))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_info), R.drawable.user_info))
			add(ItemBean(getString(R.string.user_download), R.drawable.download))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_logout), R.drawable.logout))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
		}
		user_items.adapter = KotlinDataAdapter.Builder<ItemBean, LayoutUserItemHolderBinding>().apply {
			setLayoutId() {
				viewType ->
				if (viewType == 1) {
					R.layout.layout_user_item_holder
				} else {
					R.layout.layout_user_item_empty
				}
			}
			setData(datas)
			onItemClick() {
				_, bean -> println("title:${bean.title}; bean=$bean")
			}
			itemViewType { b -> b.viewType!! }
			
		}.build()
	}
	
	inner class ItemBean(val title:String, val icon:Int=R.drawable.bottom_nav_user, val viewType:Int?=1) {
		val drawable:BitmapDrawable
		
		init {
			drawable = BitmapDrawable(this@UserFragment.resources, BitmapFactory.decodeResource(this@UserFragment.resources, icon))
		}
	}
}
