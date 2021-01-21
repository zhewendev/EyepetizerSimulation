plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
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
        multiDexEnabled = true

        testInstrumentationRunner = ProjectProperties.TEST_INSTRUMENTATION_RUNNER
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
        viewBinding = true
    }

    kapt{
        arguments{
            arg("AROUTER_MODULE_NAME",project.name)
        }
        generateStubs = true
    }
}


dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":eyepetizer_common"))
    implementation(project(":eyepetizer_home"))

    implementation(Config.JetPack.HILT_ANDROID)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    kapt(Config.JetPack.HILT_ANDROID_COMPILER)
    implementation(Config.JetPack.HILT_VIEW_MODEL)
    kapt(Config.JetPack.HILT_COMPILER)

    kapt(Config.External.AROUTER_COMPILER)

    testImplementation(Config.AndroidX.JUNIT)
    androidTestImplementation(Config.AndroidX.EXT_JUNIT)
    androidTestImplementation(Config.AndroidX.ESPRESSO_CORE)
}