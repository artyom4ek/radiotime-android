plugins {
    id("com.android.application")
    kotlin("android")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.tunein.radiotime"
    compileSdk = 33
    buildToolsVersion = "33.0.0 rc2"

    defaultConfig {
        applicationId = "com.tunein.radiotime"
        minSdk = 26
        targetSdk = 33
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
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    dependencies {

        // Core
        implementation(Deps.coreKtx)
        implementation(Deps.lifecycleRuntimeKtx)
        implementation(Deps.activityCompose)

        // Compose
        implementation(platform(Deps.composeBom))
        implementation(Deps.composeUi)
        implementation(Deps.composeUiGraphics)
        implementation(Deps.composeUiToolingPreview)
        implementation(Deps.composeMaterial3)

        androidTestImplementation(platform(Deps.composeBom))
        debugImplementation(Deps.composeUiTooling)
        debugImplementation(Deps.composeUiTestManifest)
        debugImplementation(Deps.composeUiTestJUnit4)

        // Testing
        testImplementation(Deps.jUnit)
        androidTestImplementation(Deps.jUnitExt)
        androidTestImplementation(Deps.espressoCore)
    }
}