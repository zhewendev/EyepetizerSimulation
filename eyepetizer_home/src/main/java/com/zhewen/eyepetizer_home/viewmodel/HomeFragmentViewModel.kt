package com.zhewen.eyepetizer_home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import com.zhewen.eyepetizer_base.viewmodel.BaseViewModel
import com.zhewen.eyepetizer_home.data.repository.HomeRepositoryImpl

/**
 *
 */
class HomeFragmentViewModel @ViewModelInject constructor(private val repository:HomeRepositoryImpl) :BaseViewModel() {

}