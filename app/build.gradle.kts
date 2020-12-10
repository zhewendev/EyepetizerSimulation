plugins {
   id( "com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(ProjectProperties.COMPILE_SDK_VERSION)
    buildToolsVersion(ProjectProperties.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = ProjectProperties.APPLICATION_ID
        minSdkVersion(ProjectProperties.MIN_SDK_VERSION)
        targetSdkVersion(ProjectProperties.TARGET_SDK_VERSION)
        versionCode = ProjectProperties.VERSION_CODE
        versionName = ProjectProperties.VERSION_NAME

        testInstrumentationRunner = ProjectProperties.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (Config.AndroidX.KOTLIN_STDLIB)
    implementation (Config.AndroidX.CORE_KTX)
    implementation (Config.AndroidX.APP_COMPAT)
    implementation (Config.AndroidX.MATERIAL)
    implementation (Config.AndroidX.CONSTRAINT_LAYOUT)
    testImplementation (Config.AndroidX.JUNIT)
    androidTestImplementation (Config.AndroidX.EXT_JUNIT)
    androidTestImplementation (Config.AndroidX.ESPRESSO_CORE)
}