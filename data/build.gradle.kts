plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.tunein.radiotime"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        buildConfig = true
    }
}

dependencies {

    implementation(project("path" to ":common"))
    implementation(project("path" to ":domain"))

    // Hilt
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)

    // Retrofit 2
    implementation(Dependencies.retrofit2)
    implementation(Dependencies.okHttp3)
    implementation(Dependencies.loggingInterceptor)

    // KotlinX Serialization
    implementation(Dependencies.kotlinxSerialization)
    implementation(Dependencies.kotlinxSerializationConverter)

    // Timber
    implementation(Dependencies.timber)

    // Testing
    testImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.mockitoCore)
    androidTestImplementation(Dependencies.jUnitExt)
    androidTestImplementation(Dependencies.testRunner)
    androidTestImplementation(Dependencies.mockitoAndroid)
}