plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.tunein.radiotime.common"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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

    // Compose
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)

    // Hilt
    implementation(Dependencies.hiltNavigationCompose)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)

    // Shimmer
    implementation(Dependencies.composeShimmer)
}