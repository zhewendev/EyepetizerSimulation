package com.zhewen.eyepetizer_base.util

import com.tencent.mmkv.MMKV
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * MMKV轻量存储工具的工具封装类
 */

class MMKVPreference<T>(private val key: String?, private val defaultValue: T) :
    ReadWriteProperty<Any, T> {

    private val mmkv = MMKV.defaultMMKV()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        saveMmkvValue(mmkv, key, defaultValue)
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return getMmkvValue(mmkv, key, defaultValue) ?: defaultValue
    }
}
