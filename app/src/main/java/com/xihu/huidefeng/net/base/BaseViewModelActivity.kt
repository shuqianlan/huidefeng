package com.xihu.huidefeng.net.base

import android.os.Bundle
import com.xihu.huidefeng.models.ViewModelDelegate
import com.xihu.huidefeng.ui.activity.BaseActivity

abstract class BaseViewModelActivity<VM: BaseViewModel>: BaseActivity(), ViewModelDelegate<VM> {
    private lateinit var viewModel:VM

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = initViewModel(this)
        super.onCreate(savedInstanceState)
    }
    
    override fun showLoading(it: Boolean) {
        showTopLoading(it)
    }
    
    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel!!)
    }
    
}