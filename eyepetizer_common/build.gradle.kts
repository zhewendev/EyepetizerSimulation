plugins {
    id ("com.android.library")
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
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
    //androidX
    api (Config.AndroidX.CARDVIEW)
    api (project(":eyepetizer_base"))
    //jetpack
    implementation (Config.JetPack.HILT_ANDROID)
    kapt (Config.JetPack.HILT_ANDROID_COMPILER)
    implementation(Config.JetPack.HILT_VIEW_MODEL)
    kapt(Config.JetPack.HILT_COMPILER)
    //external
    api (Config.External.BANNER)
    api (Config.External.SMART_REFRESH_LAYOUT_KERNEL)
    api(Config.External.SMART_REFRESH_HEADER_CLASSICS)
    kapt(Config.External.AROUTER_COMPILER)
    api(Config.External.BADGEVIEW)

    testImplementation (Config.AndroidX.JUNIT)
    androidTestImplementation (Config.AndroidX.EXT_JUNIT)
    androidTestImplementation (Config.AndroidX.ESPRESSO_CORE)
}