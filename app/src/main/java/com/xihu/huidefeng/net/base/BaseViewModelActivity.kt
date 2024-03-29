package com.xihu.huidefeng.net.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.xihu.huidefeng.models.ViewModelDelegate
import com.xihu.huidefeng.ui.activity.BaseActivity

//inline fun <reified T:BaseViewModel> AppCompatActivity.getViewModel():BaseViewModel {
//    return ViewModelProvider.NewInstanceFactory().create(T::class.java)
//}
//
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