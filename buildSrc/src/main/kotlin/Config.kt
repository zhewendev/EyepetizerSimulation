object Config {

    object Version{
        const val ANDROID_TOOLS_VERSION = "4.1.1"
        const val CORE_KTX_VERSION = "1.3.2"
        const val APP_COMPAT_VERSION = "1.2.0"
        const val MATERIAL_VERSION = "1.2.1"
        const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
        const val JUNIT_VERSION = "4.13.1"
        const val EXT_JUNIT_VERSION = "1.1.2"
        const val ESPRESSO_CORE_VERSION = "3.3.0"
    }

    object Plugin{
        const val ANDROID_TOOLS = "com.android.tools.build:gradle:${Version.ANDROID_TOOLS_VERSION}"
        const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectProperties.KOTLIN_VERSION}"
    }

    object Implementation{
        const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${ProjectProperties.KOTLIN_VERSION}"
        const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX_VERSION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT_VERSION}"
        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT_VERSION}"
        const val JUNIT = "junit:junit:${Version.JUNIT_VERSION}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${Version.EXT_JUNIT_VERSION}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE_VERSION}"
    }

}