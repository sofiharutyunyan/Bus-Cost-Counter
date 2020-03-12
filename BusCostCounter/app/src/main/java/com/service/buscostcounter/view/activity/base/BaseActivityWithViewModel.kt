package com.service.buscostcounter.view.activity.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.service.buscostcounter.viewmodel.base.BaseViewModel

open abstract class BaseActivityWithViewModel<T : ViewDataBinding, U : BaseViewModel> : BaseActivity<T>() {

    protected lateinit var vm : U

    protected abstract fun getViewModelClass(): Class<U>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm  = ViewModelProviders.of(this).get(getViewModelClass())
    }
}