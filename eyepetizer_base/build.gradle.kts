plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(ProjectProperties.COMPILE_SDK_VERSION)
    buildToolsVersion(ProjectProperties.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(ProjectProperties.MIN_SDK_VERSION)
        targetSdkVersion(ProjectProperties.TARGET_SDK_VERSION)
        versionCode = ProjectProperties.VERSION_CODE
        versionName = ProjectProperties.VERSION_NAME

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
        generateStubs = true
    }

}

dependencies {

    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(Config.AndroidX.KOTLIN_STDLIB)
    api(Config.AndroidX.CORE_KTX)
    api(Config.AndroidX.APP_COMPAT)
    api(Config.AndroidX.MATERIAL)
    api(Config.AndroidX.CONSTRAINT_LAYOUT)
    testImplementation(Config.AndroidX.JUNIT)
    androidTestImplementation(Config.AndroidX.EXT_JUNIT)
    androidTestImplementation(Config.AndroidX.ESPRESSO_CORE)
    api(Config.External.LOAD_SIR)
}