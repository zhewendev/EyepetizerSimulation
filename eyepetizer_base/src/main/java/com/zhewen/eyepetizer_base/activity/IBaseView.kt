package com.zhewen.eyepetizer_base.activity

/**
 * 界面UI显示切换
 */
interface IBaseView {

    /**
     * 显示内容
     */
    fun showContent()

    /**
     * 显示加载提示
     */
    fun showLoading()

    /**
     * 显示空页面
     */
    fun showEmptyPage()

    /**
     * 显示错误
     */
    fun showError(message:String)

    /**
     * 显示无网络
     */
    fun showNoNetwork()


}