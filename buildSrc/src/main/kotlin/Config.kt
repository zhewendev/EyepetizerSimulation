object Config {

    object Version{

        //Plugin与AndroidX相关依赖库版本
        const val ANDROID_TOOLS_VERSION = "4.1.1"
        const val CORE_KTX_VERSION = "1.3.2"
        const val HILT_ANDROID_VERSION = "2.28-alpha"
        const val APP_COMPAT_VERSION = "1.2.0"
        const val MATERIAL_VERSION = "1.2.1"
        const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
        const val JUNIT_VERSION = "4.13.1"
        const val EXT_JUNIT_VERSION = "1.1.2"
        const val ESPRESSO_CORE_VERSION = "3.3.0"

        //JetPack相关依赖库版本
        const val LIFECYCLE_VERSION = "2.2.0"

        //外部开源依赖库版本

        //Kotlin相关依赖库版本
    }

    object Plugin{
        const val ANDROID_TOOLS = "com.android.tools.build:gradle:${Version.ANDROID_TOOLS_VERSION}"
        const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectProperties.KOTLIN_VERSION}"
        const val HILT_ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_ANDROID_VERSION}"
    }

    //AndroidX相关依赖库
    object AndroidX{
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${ProjectProperties.KOTLIN_VERSION}"
        const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX_VERSION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT_VERSION}"
        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT_VERSION}"
        const val JUNIT = "junit:junit:${Version.JUNIT_VERSION}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${Version.EXT_JUNIT_VERSION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE_VERSION}"
    }

    //JetPack相关依赖库
    object JetPack{


        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${Version.LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${Version.LIFECYCLE_VERSION}"
        const val LIFECYCLE_LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFECYCLE_VERSION}"
        const val LIFECYCLE_VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE_VERSION}"

        //hilt
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT_ANDROID_VERSION}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Version.HILT_ANDROID_VERSION}"

    }

    //外部开源依赖库
    object External{

    }

    //Kotlin相关依赖库
    object Kotlin{

    }

}