package com.example.mvvmexample.base

import android.arch.lifecycle.ViewModel
import com.example.mvvmexample.injection.component.DaggerViewModelInjector
import com.example.mvvmexample.injection.component.ViewModelInjector
import com.example.mvvmexample.module.NetworkModule
import com.example.mvvmexample.ui.post.PostListViewModel
import com.example.mvvmexample.ui.post.PostViewModel

abstract  class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}