package com.zhewen.eyepetizer_common.util.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

/**
 * Fragment相关封装工具类
 */
class FragmentUtil {

    companion object {

        /**
         * 添加Fragment
         */
        fun <T : Fragment> addFragment(activity: FragmentActivity, fragment: T, containerId: Int) {
            addFragment(activity, fragment, containerId, null)
        }

        /**
         * 添加Fragment
         */
        fun <T : Fragment> addFragment(
            activity: FragmentActivity,
            fragment: T,
            containerId: Int,
            tag: String?
        ) {
            activity.supportFragmentManager.commit {
                if (!fragment.isAdded) {
                    add(containerId, fragment, tag)
                }
            }
        }


        /**
         * 展示Fragment
         */
        fun <T : Fragment> showNewFragment(
            activity: FragmentActivity,
            oldFragment: Fragment,
            newFragment: T,
            containerId: Int
        ) {

            showNewFragment(activity, oldFragment, newFragment, containerId, null)
        }

        /**
         * 展示Fragment
         */
        fun <T : Fragment> showNewFragment(
            activity: FragmentActivity,
            oldFragment: Fragment,
            newFragment: T,
            containerId: Int,
            tag: String?
        ) {
            activity.supportFragmentManager.commit {
                if (!newFragment.isAdded) {
                    add(containerId, newFragment, tag).show(newFragment)
                } else if (oldFragment != newFragment) {
                    hide(oldFragment).show(newFragment)
                }
            }
        }

        /**
         * 切换展示新的Fragment
         */
        fun<T:Fragment> showNewFragment(activity: FragmentActivity,newFragment:T,containerId: Int) {
            val currentFragment = getCurrentFragment(activity,containerId)
            if (currentFragment != null) {
                showNewFragment(activity,currentFragment,newFragment,containerId)
            } else {
                activity.supportFragmentManager.commit {
                    show(newFragment)
                }
            }
        }

        /**
         * 替换Fragment
         */
        fun <T : Fragment> replaceFragment(
            activity: FragmentActivity,
            oldFragment: Fragment,
            containerId: Int,
            newFragment: T
        ) {
            replaceFragment(activity, oldFragment, newFragment, containerId, null)
        }

        /**
         * 替换Fragment
         */
        fun <T : Fragment> replaceFragment(
            activity: FragmentActivity,
            oldFragment: Fragment,
            newFragment: T,
            containerId: Int,
            tag: String?
        ) {
            activity.supportFragmentManager.commit {
                if (!newFragment.isAdded) {
                    replace(containerId, newFragment, tag)
                } else if (oldFragment != newFragment) {
                    hide(oldFragment).show(newFragment)
                }
            }
        }

        /**
         * 获取当前展示的fragment
         */
        fun getCurrentFragment(activity: FragmentActivity,containerId: Int):Fragment? {
            return activity.supportFragmentManager.findFragmentById(containerId)
        }
    }
}