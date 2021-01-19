package com.zhewen.eyepetizer_home.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhewen.eyepetizer_home.viewmodel.HomeFragmentViewModel

class HomeFragmentModelFactory:ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel() as T
    }
}