package com.service.buscostcounter.view.fragment.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.service.buscostcounter.viewmodel.base.BaseViewModel

abstract class BaseFragmentWithViewModel<T : ViewDataBinding, U : BaseViewModel> :
    BaseFragment<T>() {

    protected lateinit var vm: U

    protected abstract fun getViewModelClass(): Class<U>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this).get(getViewModelClass())
    }

}