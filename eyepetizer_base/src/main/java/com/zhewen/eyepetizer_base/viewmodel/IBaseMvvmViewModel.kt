package com.zhewen.eyepetizer_base.viewmodel

import android.view.View

/**
 * 定义viewModel与UI视图的关联
 */
interface IBaseMvvmViewModel {

    /**
     * 关联view
     */
    fun attachView(V:View)

    /**
     * 获取view
     */
    fun getView()

    /**
     * 判断viewModel是否已关联View
     */
    fun isViewAttach():Boolean

    /**
     * 解除viewModel与View的关联
     */
    fun detachView()
}