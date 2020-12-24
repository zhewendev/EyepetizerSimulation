package com.zhewen.eyepetizer_base.viewmodel


/**
 * 定义viewModel与UI视图的关联
 */
interface IBaseMvvmViewModel<V> {

    /**
     * 关联view
     */
    fun attachView(view:V)

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