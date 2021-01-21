package com.zhewen.eyepetizer_home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.orhanobut.logger.Logger
import com.zhewen.eyepetizer_base.viewmodel.BaseViewModel
import com.zhewen.eyepetizer_common.data.model.Item
import com.zhewen.eyepetizer_common.network.doFailure
import com.zhewen.eyepetizer_common.network.doSuccess
import com.zhewen.eyepetizer_home.data.model.DiscoveryModel
import com.zhewen.eyepetizer_home.data.repository.DiscoveryRepositoryImpl
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

/**
 * 发现页ViewModel处理
 */
class DiscoveryFragmentViewModel @ViewModelInject constructor(private val repository: DiscoveryRepositoryImpl) :
    BaseViewModel() {

    private val mDiscoveryModel = MutableLiveData<DiscoveryModel>()
    var mTopBannerModel = MutableLiveData<Item>()
    var mCategoryCardModel = MutableLiveData<Item>()
    var mSubjectCardModel = MutableLiveData<Item>()
    var mTextCardMode = MutableLiveData<Item>()
    var mBannerModel = MutableLiveData<Item>()
    var mVideoSmallCardModel = MutableLiveData<Item>()
    var mBriefCardModel = MutableLiveData<Item>()

    fun fetchDiscoveryModel() = liveData<DiscoveryModel> {
        repository.fetchDiscoveryPage().onStart {
            // 在调用 flow 请求数据之前，做一些准备工作
        }.catch {
            // 捕获上游出现的异常

        }.onCompletion {
            //请求完成

        }.collectLatest { result ->
            result.doFailure { throwable ->
                Logger.t("discoveryFragmentViewModel").d("failure ${throwable?.message}")
            }
            result.doSuccess { data ->
                updateModel(data)
                emit(data)
            }
        }
    }

    /**
     * 更新数据
     */
    private fun updateModel(discoveryModel: DiscoveryModel) {
        mDiscoveryModel.postValue(discoveryModel)
        for (item in discoveryModel.itemList) {
            when (item.type) {
                TYPE_HORIZONTAL_SCROLL_CARD -> mTopBannerModel.postValue(item)
                TYPE_SPECIAL_SQUARE_CARD_COLLECTION -> mCategoryCardModel.postValue(item)
                TYPE_COLUMN_CARD_LIST -> mSubjectCardModel.postValue(item)
                TYPE_TEXT_CARD -> mTextCardMode.postValue(item)
                TYPE_BANNER -> mBannerModel.postValue(item)
                TYPE_VIDEO_SMALL_CARD -> mVideoSmallCardModel.postValue(item)
                TYPE_BRIEF_CARD -> mBriefCardModel.postValue(item)
                else ->{

                }
            }
        }
    }


    companion object {
        const val TYPE_HORIZONTAL_SCROLL_CARD = "horizontalScrollCard"
        const val TYPE_SPECIAL_SQUARE_CARD_COLLECTION = "specialSquareCardCollection"
        const val TYPE_COLUMN_CARD_LIST = "columnCardList"
        const val TYPE_TEXT_CARD = "textCard"
        const val TYPE_BANNER = "banner"
        const val TYPE_VIDEO_SMALL_CARD = "videoSmallCard"
        const val TYPE_BRIEF_CARD = "briefCard"
    }

}