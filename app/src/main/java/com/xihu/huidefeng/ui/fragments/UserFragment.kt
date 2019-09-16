package com.xihu.huidefeng.ui.fragments


import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ilifesmart.weatherdemoapi.adapters.KotlinDataAdapter

import com.xihu.huidefeng.R
import com.xihu.huidefeng.databinding.LayoutUserItemHolderBinding
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment() {
	
	override fun layoutId()=R.layout.fragment_user
	private val datas = mutableListOf<ItemBean>()
	
	private val CATEGORY_DEFAULT = 0

	override fun initView() {
		datas.clear()
		datas.apply {
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_recharge), R.drawable.recharge, category = 2))
			add(ItemBean(getString(R.string.user_balance), R.drawable.balance, category = 3))
			add(ItemBean(getString(R.string.user_score), R.drawable.score, category = 4))
			add(ItemBean(getString(R.string.user_withdraw), R.drawable.withdraw, category = 5))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_atlas), R.drawable.vip_atlas, category = 6))
			add(ItemBean(getString(R.string.user_notice), R.drawable.vip_notice, category = 7))
			add(ItemBean(getString(R.string.user_security), R.drawable.security, category = 8))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_info), R.drawable.user_info, category = 9))
			add(ItemBean(getString(R.string.user_download), R.drawable.download, category = 10))
			add(ItemBean(getString(R.string.user_placeholder), viewType = 0))
			add(ItemBean(getString(R.string.user_logout), R.drawable.logout, category = 11))
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
				view, bean ->
				when(bean.category) {
					2 -> navigateTo(view, R.id.action_user_fragment_to_charge_fragment, R.string.user_recharge)
					3 -> navigateTo(view, R.id.action_user_fragment_to_balance_fragment, R.string.user_balance)
					4 -> navigateTo(view, R.id.action_user_fragment_to_score_fragment, R.string.user_score)
					5 -> navigateTo(view, R.id.action_user_fragment_to_withdraw_fragment, R.string.user_withdraw)
					6 -> navigateTo(view, R.id.action_user_fragment_to_atlas_fragment, R.string.user_atlas)
					7 -> navigateTo(view, R.id.action_user_fragment_to_notice_fragment, R.string.user_notice)
					8 -> navigateTo(view, R.id.action_user_fragment_to_security_fragment, R.string.user_security)
					9 -> navigateTo(view, R.id.action_user_fragment_to_info_fragment, R.string.user_info)
					10 -> navigateTo(view, R.id.action_user_fragment_to_download_fragment, R.string.user_download)
					11 -> navigateTo(view, R.id.action_user_fragment_to_logout_fragment, R.string.user_logout)
				}
			}
			itemViewType { b -> b.viewType }
			
		}.build()
	}
	
	inner class ItemBean(val title:String, val icon:Int=R.drawable.user, val viewType:Int=1, val category:Int=0) {
		val drawable:BitmapDrawable
		
		// 因为icon大小并不统一，暂不显示.
		init {
			drawable = BitmapDrawable(this@UserFragment.resources, BitmapFactory.decodeResource(this@UserFragment.resources, icon))
		}
	}
	
	private fun navigateTo(view:View, actionId:Int, descId:Int) {
		Navigation.findNavController(view).navigate(actionId, Bundle().apply {
			putInt(Intent.EXTRA_TEXT, descId)
		})
	}
}
