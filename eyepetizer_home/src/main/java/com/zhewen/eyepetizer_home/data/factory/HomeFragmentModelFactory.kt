package com.zhewen.eyepetizer_home.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhewen.eyepetizer_home.data.viewmodel.HomeFragmentViewModel

class HomeFragmentModelFactory:ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel() as T
    }
}