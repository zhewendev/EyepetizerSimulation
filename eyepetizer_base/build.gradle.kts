plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(ProjectProperties.COMPILE_SDK_VERSION)
    buildToolsVersion(ProjectProperties.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(ProjectProperties.MIN_SDK_VERSION)
        targetSdkVersion(ProjectProperties.TARGET_SDK_VERSION)
        versionCode = ProjectProperties.VERSION_CODE
        versionName = ProjectProperties.VERSION_NAME
        multiDexEnabled = true
        testInstrumentationRunner = ProjectProperties.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }

    kapt {
        arguments{
            arg("AROUTER_MODULE_NAME",project.name)
        }
        generateStubs = true
    }

}

dependencies {

    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(Config.AndroidX.KOTLIN_STDLIB)
    api(Config.AndroidX.CORE_KTX)
    api(Config.AndroidX.COROUTINES_CORE)
    api(Config.AndroidX.COROUTINES_ANDROID)
    api(Config.AndroidX.APP_COMPAT)
    api(Config.AndroidX.MATERIAL)
    api(Config.AndroidX.CONSTRAINT_LAYOUT)
    api(Config.AndroidX.MULTIDEX)
    //JetPack
    api (Config.JetPack.LIFECYCLE_RUNTIME_KTX)
    kapt (Config.JetPack.LIFECYCLE_COMPILER)
    api(Config.JetPack.LIFECYCLE_COMMON_JAVA8)
    api(Config.JetPack.LIFECYCLE_LIVE_DATA_KTX)
    api(Config.JetPack.LIFECYCLE_VIEW_MODEL_KTX)
    api(Config.JetPack.NAVIGATION_FRAGMENT_KTX)
    api(Config.JetPack.NAVIGATION_UI_KTX)
    api(Config.JetPack.NAVIGATION_DYNAMIC_FEATURES)
    implementation (Config.JetPack.HILT_ANDROID)
    kapt (Config.JetPack.HILT_ANDROID_COMPILER)
    implementation(Config.JetPack.HILT_VIEW_MODEL)
    kapt(Config.JetPack.HILT_COMPILER)

    //External
    api(Config.External.LOGGER)
    api(Config.External.EASY_PERMISSION)
    api (Config.External.MMKV)
    api (Config.External.GSON)
    api (Config.External.AROUTER_API)
    kapt(Config.External.AROUTER_COMPILER)
    api(Config.External.RETROFIT)
    api(Config.External.RETROFIT_CONVERTER_GSON)

    testImplementation(Config.AndroidX.JUNIT)
    androidTestImplementation(Config.AndroidX.EXT_JUNIT)
    androidTestImplementation(Config.AndroidX.ESPRESSO_CORE)
    api(Config.External.LOAD_SIR)
}