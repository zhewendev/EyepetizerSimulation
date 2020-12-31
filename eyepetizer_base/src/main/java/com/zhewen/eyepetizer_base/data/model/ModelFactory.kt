package com.zhewen.eyepetizer_base.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhewen.eyepetizer_base.data.repository.BaseRepository
import com.zhewen.eyepetizer_base.viewmodel.BaseViewModel

/**
 * model数据构造工厂基类
 */
abstract class ModelFactory<BR : BaseRepository,VM:BaseViewModel<BR>>(private val repository: BR) :  ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VM(repository) as T
    }
}