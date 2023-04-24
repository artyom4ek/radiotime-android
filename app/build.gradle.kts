plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.tunein.radiotime"
    compileSdk = Config.compileSdk
    buildToolsVersion = Config.buildTools

    defaultConfig {
        applicationId = "com.tunein.radiotime"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtension
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    // Modules
    implementation(project("path" to ":common"))

    // Core
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)

    // Compose
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)

    androidTestImplementation(platform(Dependencies.composeBom))
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeUiTestManifest)
    debugImplementation(Dependencies.composeUiTestJUnit4)

    // Timber
    implementation(Dependencies.timber)

    // Testing
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.jUnitExt)
    androidTestImplementation(Dependencies.espressoCore)
}