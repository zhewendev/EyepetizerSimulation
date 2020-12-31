package com.zhewen.eyepetizer_base.viewmodel

import androidx.lifecycle.ViewModel
import com.zhewen.eyepetizer_base.data.model.SuperBaseModel
import com.zhewen.eyepetizer_base.data.repository.BaseRepository

//todo
abstract class BaseViewModel<BR:BaseRepository>(val repository: BR):ViewModel(){


}