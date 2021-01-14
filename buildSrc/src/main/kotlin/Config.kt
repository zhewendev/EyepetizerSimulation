object Config {

    object Version {
        const val HILT_ANDROID_VERSION = "2.28-alpha"
    }

    object Plugin {
        private const val ANDROID_TOOLS_VERSION = "4.1.1"

        const val ANDROID_TOOLS = "com.android.tools.build:gradle:${ANDROID_TOOLS_VERSION}"
        const val KOTLIN_GRADLE_PLUGIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectProperties.KOTLIN_VERSION}"
        const val HILT_ANDROID_GRADLE_PLUGIN =
            "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_ANDROID_VERSION}"
    }

    //AndroidX相关依赖库
    object AndroidX {
        private const val CORE_KTX_VERSION = "1.3.2"
        private const val APP_COMPAT_VERSION = "1.2.0"
        private const val MATERIAL_VERSION = "1.2.1"
        private const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
        private const val JUNIT_VERSION = "4.13.1"
        private const val EXT_JUNIT_VERSION = "1.1.2"
        private const val ESPRESSO_CORE_VERSION = "3.3.0"
        private const val MULTIDEX_VERSION = "2.0.1"
        private const val CARDVIEW_VERSION = "1.0.0"

        const val KOTLIN_STDLIB =
            "org.jetbrains.kotlin:kotlin-stdlib:${ProjectProperties.KOTLIN_VERSION}"
        const val CORE_KTX = "androidx.core:core-ktx:${CORE_KTX_VERSION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${APP_COMPAT_VERSION}"
        const val MATERIAL = "com.google.android.material:material:${MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${CONSTRAINT_LAYOUT_VERSION}"
        const val JUNIT = "junit:junit:${JUNIT_VERSION}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${EXT_JUNIT_VERSION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${ESPRESSO_CORE_VERSION}"
        const val MULTIDEX = "androidx.multidex:multidex:${MULTIDEX_VERSION}"
        const val CARDVIEW = "androidx.cardview:cardview:${CARDVIEW_VERSION}"
    }

    //JetPack相关依赖库
    object JetPack {
        private const val LIFECYCLE_VERSION = "2.2.0"
        private const val NAVIGATION_VERSION = "2.3.1"

        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMMON_JAVA8 =
            "androidx.lifecycle:lifecycle-common-java8:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_LIVE_DATA_KTX =
            "androidx.lifecycle:lifecycle-livedata-ktx:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_VIEW_MODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${LIFECYCLE_VERSION}"
        const val NAVIGATION_FRAGMENT_KTX =
            "androidx.navigation:navigation-fragment-ktx:${NAVIGATION_VERSION}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${NAVIGATION_VERSION}"
        const val NAVIGATION_DYNAMIC_FEATURES =
            "androidx.navigation:navigation-dynamic-features-fragment:${NAVIGATION_VERSION}"

        //hilt
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT_ANDROID_VERSION}"
        const val HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-android-compiler:${Version.HILT_ANDROID_VERSION}"

    }

    //外部开源依赖库
    object External {
        private const val LOAD_SIR_VERSION = "1.3.8"
        private const val LOGGER_VERSION = "2.2.0"
        private const val EASY_PERMISSION_VERSION = "3.0.0"
        private const val MMKV_VERSION = "1.2.7"
        private const val GSON_VERSION = "2.8.6"
        private const val BANNER_VERSION = "2.1.0"
        //下拉刷新开源库
        private const val SMART_REFRESH_LAYOUT_VERSION = "2.0.3"
        private const val AROUTER_VERSION = "1.5.1"
        private const val BADGEVIEW_VERSION = "1.1.3"



        const val LOAD_SIR = "com.kingja.loadsir:loadsir:${LOAD_SIR_VERSION}"
        const val LOGGER = "com.orhanobut:logger:${LOGGER_VERSION}"
        const val EASY_PERMISSION = "pub.devrel:easypermissions:${EASY_PERMISSION_VERSION}"
        const val MMKV = "com.tencent:mmkv-static:${MMKV_VERSION}"
        const val GSON = "com.google.code.gson:gson:${GSON_VERSION}"
        const val BANNER = "com.youth.banner:banner:${BANNER_VERSION}"

        const val SMART_REFRESH_LAYOUT_KERNEL = "com.scwang.smart:refresh-layout-kernel:${SMART_REFRESH_LAYOUT_VERSION}"    //下拉刷新核心库
        const val SMART_REFRESH_HEADER_CLASSICS = "com.scwang.smart:refresh-header-classics:${SMART_REFRESH_LAYOUT_VERSION}"    //经典刷新头
        const val SMART_REFRESH_HEADER_RADAR = "com.scwang.smart:refresh-header-radar:${SMART_REFRESH_LAYOUT_VERSION}"  //雷达刷新头
        const val SMART_REFRESH_HEADER_FALSIFY = "com.scwang.smart:refresh-header-falsify:${SMART_REFRESH_LAYOUT_VERSION}"//虚拟刷新头
        const val SMART_REFRESH_HEADER_MATERIAL = "com.scwang.smart:refresh-header-material:${SMART_REFRESH_LAYOUT_VERSION}"//谷歌刷新头
        const val SMART_REFRESH_HEADER_TWO_LEVEL = "com.scwang.smart:refresh-header-two-level:${SMART_REFRESH_LAYOUT_VERSION}" //二级刷新头
        const val SMART_REFRESH_FOOTER_BALL = "com.scwang.smart:refresh-footer-ball:${SMART_REFRESH_LAYOUT_VERSION}"    //球脉冲加载
        const val SMART_REFRESH_FOOTER_CLASSICS = "com.scwang.smart:refresh-footer-classics:${SMART_REFRESH_LAYOUT_VERSION}"

        const val AROUTER_API ="com.alibaba:arouter-api:${AROUTER_VERSION}"
        const val AROUTER_COMPILER = "com.alibaba:arouter-compiler:${AROUTER_VERSION}"
        const val BADGEVIEW = "q.rorbin:badgeview:${BADGEVIEW_VERSION}"


    }

    //Kotlin相关依赖库
    object Kotlin {

    }

}