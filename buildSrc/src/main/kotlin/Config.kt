object Config {

    object Version{
        const val HILT_ANDROID_VERSION = "2.28-alpha"
    }

    object Plugin{
        private const val ANDROID_TOOLS_VERSION = "4.1.1"

        const val ANDROID_TOOLS = "com.android.tools.build:gradle:${ANDROID_TOOLS_VERSION}"
        const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectProperties.KOTLIN_VERSION}"
        const val HILT_ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT_ANDROID_VERSION}"
    }

    //AndroidX相关依赖库
    object AndroidX{
        private const val CORE_KTX_VERSION = "1.3.2"
        private const val APP_COMPAT_VERSION = "1.2.0"
        private const val MATERIAL_VERSION = "1.2.1"
        private const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
        private const val JUNIT_VERSION = "4.13.1"
        private const val EXT_JUNIT_VERSION = "1.1.2"
        private const val ESPRESSO_CORE_VERSION = "3.3.0"

        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${ProjectProperties.KOTLIN_VERSION}"
        const val CORE_KTX = "androidx.core:core-ktx:${CORE_KTX_VERSION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${APP_COMPAT_VERSION}"
        const val MATERIAL = "com.google.android.material:material:${MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${CONSTRAINT_LAYOUT_VERSION}"
        const val JUNIT = "junit:junit:${JUNIT_VERSION}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${EXT_JUNIT_VERSION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${ESPRESSO_CORE_VERSION}"
    }

    //JetPack相关依赖库
    object JetPack{
        private const val LIFECYCLE_VERSION = "2.2.0"

        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${LIFECYCLE_VERSION}"
        const val LIFECYCLE_VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LIFECYCLE_VERSION}"

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