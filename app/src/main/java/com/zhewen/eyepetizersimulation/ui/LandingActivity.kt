package com.zhewen.eyepetizersimulation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhewen.eyepetizer_base.base.ActivityStackManager
import com.zhewen.eyepetizer_base.util.MMKVPreference
import com.zhewen.eyepetizersimulation.R
import com.zhewen.eyepetizersimulation.utils.Constants

class LandingActivity:AppCompatActivity() {

    private var mIsFirstEnter by MMKVPreference<Boolean>(Constants.KEY_IS_FIRST_OPEN_APP,true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)


    }

    private fun isFirstOpenApp() : Boolean {
        return
    }


    override fun onStart() {
        super.onStart()
        ActivityStackManager.sActivityStackManagerInstance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityStackManager.sActivityStackManagerInstance.removeActivity(this)
    }
}