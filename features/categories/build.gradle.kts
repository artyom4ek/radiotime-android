plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.tunein.radiotime"
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

    implementation(project("path" to ":common"))
    implementation(project("path" to ":domain"))
    implementation(project("path" to ":navigation"))

    // Compose
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.activityCompose)

    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)

    // Hilt
    implementation(Dependencies.hiltNavigationCompose)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)

    // Coil
    implementation(Dependencies.coil)

    // Testing
    androidTestImplementation(platform(Dependencies.composeBom))
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeUiTestManifest)
    debugImplementation(Dependencies.composeUiTestJUnit4)
}