package com.zhewen.eyepetizer_base.livadata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zhewen.eyepetizer_base.livadata.LiveDataBus.ObserverWrapper
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * 基于livaData的事件总线
 * 通过map维护一个消息事件和MutableLiveData的映射关系，MutableLiveData的类型默认为Object，接收任意类型，实现总线通信
 * 将LiveDataBus封装为一个单例类
 * 消息注册时，如果当前map中不存在，则先将消息和对应的MutableLiveData对象放入维护的map中，添加映射关系，返回当前map中缓存的MutableLiveData对象
 */
class LiveDataBus private constructor() {

    companion object {
        val sLiveDataBusInstance = SingletonHolder.sInstance
    }

    private object SingletonHolder {
        val sInstance = LiveDataBus()
    }

    private val mBus:MutableMap<String, BusMutableLiveData<Any>> = mutableMapOf()    //普通事件
    private val mStickyBus:MutableMap<String, MutableLiveData<Any>> = mutableMapOf() //粘性事件

    inline fun <reified T> with(key: String): MutableLiveData<T> {
        return with(key, T::class.java)
    }

    @Throws(Exception::class)
    fun <T> with(key: String, type: Class<T>): MutableLiveData<T> {
        if (!mBus.containsKey(key)) {
            mBus[key] = BusMutableLiveData()
        }
        return mBus[key] as MutableLiveData<T>
    }

    inline fun <reified T> withSticky(key: String): MutableLiveData<T> {
        return withSticky(key, T::class.java)
    }

    @Throws(Exception::class)
    fun <T> withSticky(key: String, type: Class<T>): MutableLiveData<T> {
        if (!mStickyBus.containsKey(key)) {
            mStickyBus[key] = MutableLiveData<Any>()
        }
        return mStickyBus[key] as MutableLiveData<T>
    }

    /**
     * Observer包装类
     */
    private class ObserverWrapper<T>(val observer: Observer<T>) : Observer<T> {
        override fun onChanged(t: T) {
            if (isCallOnObserverForever()) {
                return
            }
            observer.onChanged(t)
        }

        private fun isCallOnObserverForever(): Boolean {
            val stackTrace = Thread.currentThread().stackTrace
            for (element in stackTrace) {
                if ("androidx.lifecycle.LiveData" == element.className
                    && "observeForever" == element.methodName
                ) {
                    return true
                }
            }
            return false
        }
    }

    private class BusMutableLiveData<T> : MutableLiveData<T>() {
        private var mObserverMap: MutableMap<Observer<*>, Observer<*>> = mutableMapOf()
        override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
            super.observe(owner, observer)
            try {
                hook(observer)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        override fun observeForever(observer: Observer<in T>) {
            if (!mObserverMap.containsKey(observer)) {
                mObserverMap[observer] = ObserverWrapper(observer)
            }
            super.observeForever(observer)
        }

        @Throws(Exception::class)
        override fun removeObserver(observer: Observer<in T>) {
            val realObserver = if (mObserverMap.containsKey(observer)) {
                mObserverMap.remove(observer) as Observer<in T>
            } else {
                observer
            }
            super.removeObserver(realObserver)
        }

        /**
         * 拦截订阅之前的事件
         */
        @Throws(Exception::class)
        private fun hook(observer: Observer<in T>) {
            val classLiveData = LiveData::class.java
            val fieldObservers = classLiveData.getDeclaredField("mObservers")
            fieldObservers.isAccessible = true
            val objectObservers = fieldObservers[this]
            val classObservers = objectObservers.javaClass
            val methodGet: Method = classObservers.getDeclaredMethod("get", Any::class.java)
            methodGet.isAccessible = true
            val objectWrapperEntry: Any = methodGet.invoke(objectObservers, observer)
                ?: throw NullPointerException("objectWrapperEntry can not be bull!")
            var objectWrapper: Any? = null
            if (objectWrapperEntry is Map.Entry<*, *>) {
                objectWrapper = objectWrapperEntry.value
            }
            if (objectWrapper == null) {
                throw NullPointerException("Wrapper can not be bull!")
            }
            val classObserverWrapper: Class<*>? = objectWrapper.javaClass.superclass
            val fieldLastVersion: Field = classObserverWrapper?.getDeclaredField("mLastVersion")
                ?: throw NullPointerException("Field can not be bull!")
            fieldLastVersion.isAccessible = true
            //get livedata's version
            val fieldVersion: Field = classLiveData.getDeclaredField("mVersion")
            fieldVersion.isAccessible = true
            val objectVersion: Any? = fieldVersion[this]
            //set wrapper's version
            fieldLastVersion.set(objectWrapper, objectVersion)
        }
    }


}