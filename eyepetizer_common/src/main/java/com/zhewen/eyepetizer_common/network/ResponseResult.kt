package com.zhewen.eyepetizer_common.network

/**
 * 处理通用的网络请求结果状态
 */
sealed class ResponseResult<out T> {
    data class Success<out T : Any>(val data:T):ResponseResult<T>()

    data class Failure(val throwable: Throwable?):ResponseResult<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success<*> -> "Success=[data=$data]"
            is Failure -> "Failure[throwable=$throwable]"
        }
    }
}

inline fun <reified T> ResponseResult<T>.doSuccess(success:(T) -> Unit) {
    if (this is ResponseResult.Success) {
        success(data)
    }
}

inline fun <reified T> ResponseResult<T>.doFailure(failure:(Throwable?) -> Unit) {
    if (this is ResponseResult.Failure) {
        failure(throwable)
    }
}
