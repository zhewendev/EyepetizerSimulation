package com.zhewen.eyepetizer_base.util

import android.os.Parcelable
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tencent.mmkv.MMKV
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * MMKV相关工具类方法集合
 */

/**
 * 移除某个key对
 */
fun removeMmkvKey(key: String) {
    MMKV.defaultMMKV()?.remove(key)
}

/**
 * 移除部分key对
 */
fun removeMmkvSomeKey(keyArray: Array<String?>?) {
    MMKV.defaultMMKV()?.removeValuesForKeys(keyArray)
}

/**
 * 清除所有key对
 */
fun clearMmkvAll() {
    MMKV.defaultMMKV()?.clearAll()
}

/**
 * 判断是否含有某个key
 */
fun hasMmkvKey(key: String): Boolean {
    return MMKV.defaultMMKV()?.containsKey(key) ?: false
}

/**
 * 往Mmkv中存储数据
 */
fun <U> saveMmkvValue(key: String?,value: U) {
    saveMmkvValue(MMKV.defaultMMKV(),key,value)
}

/**
 * 往Mmkv中存储数据
 */
fun <U> saveMmkvValue(mmkv: MMKV?,key: String?,value: U) = mmkv?.let {
    when (value) {
        is String -> it.encode(key, value)
        is Int -> it.encode(key, value)
        is Boolean -> it.encode(key, value)
        is Float -> it.encode(key, value)
        is Long -> it.encode(key, value)
        is Double -> it.encode(key, value)
        is ByteArray -> it.encode(key, value)
        else -> it.encode(key, value.toString())
    }
}

/**
 * 获取Mmkv中存储的数据
 */
fun <U> getMmkvValue(key: String?, value:U?) : U? {

    val mmkv = MMKV.defaultMMKV()
    return getMmkvValue(mmkv,key,value)
}

/**
 * 获取Mmkv中存储的数据
 */
fun <U> getMmkvValue(mmkv: MMKV?,key: String?, value:U?) : U? {
    return if (mmkv == null) {
        null
    } else {
        val res: Any? = with(mmkv) {
            when (value) {
                is String -> decodeString(key, value)
                is Int -> decodeInt(key, value)
                is Boolean -> decodeBool(key, value)
                is Float -> decodeFloat(key, value)
                is Long -> decodeLong(key, value)
                is Double -> decodeDouble(key, value)
                is ByteArray -> decodeBytes(key, value)
                is Set<*> -> decodeStringSet(key, value as? Set<String>)
                is Parcelable -> decodeParcelable(key, null)
                is Map<*, *> -> {

                }
                else -> throw IllegalArgumentException("This type can be saved into Preferences")
            }
        }
        res as? U?
    }
}

/**
 * 存储map集合
 */
fun saveMmkvMap(key: String, map: Map<String, Any?>) {
    val gson = Gson()
    val jsonArray = JSONArray()
    var obj:JSONObject? = null
    try {
        obj = JSONObject(gson.toJson(map))
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    jsonArray.put(obj)
    MMKV.defaultMMKV()?.encode(key, jsonArray.toString())
}

/**
 * 获取map集合
 */
fun getMmkvMap(key: String):MutableMap<String, String?> {

    val itemMap:MutableMap<String, String?> = HashMap()
    val result = MMKV.defaultMMKV()?.decodeString(key, "")
    try {
        val array = JSONArray(result)
        for (i in 0 until array.length()) {
            val itemObject = array.getJSONObject(i)
            val names = itemObject.names()
            names?.let {
                for (j in 0 until it.length()) {
                    val name = it.getString(j)
                    val value = itemObject.getString(name)
                    itemMap[name] = value
                }
            }
        }

    } catch (e: JSONException) {
        e.printStackTrace()
    }
    return itemMap
}

/**
 * 获取存储在MMKV的对象
 */
fun <T> getMmkvInfo(key: String, t: Class<T>) : T? {
    val str: String? = MMKV.defaultMMKV()?.decodeString(key, null)
    return if (!TextUtils.isEmpty(str)) {
        GsonBuilder().create().fromJson(str, t)
    } else {
        null
    }
}

/**
 * 在MMKV中存储对象
 */
fun saveMmkvInfo(key: String,obj:Any?) {
    val jsonString = GsonBuilder().create().toJson(obj)
    MMKV.defaultMMKV()?.encode(key,jsonString)
}

