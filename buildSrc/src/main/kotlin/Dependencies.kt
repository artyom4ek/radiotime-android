object Dependencies {

    private object Versions {
        const val coreKtx = "1.10.0"
        const val lifecycleRuntimeKtx = "2.6.1"
        const val activityCompose = "1.7.1"
        const val navigation = "2.5.3"
        const val composeBom = "2023.04.01"
        const val hilt = "2.46"
        const val hiltNavigationCompose = "1.0.0"
        const val kotlinxSerialization = "1.5.0"
        const val kotlinxSerializationConverter = "1.0.0"
        const val retrofit2 = "2.9.0"
        const val okHttp3 = "4.11.0"
        const val timber = "5.0.1"
        const val jUnit = "4.13.2"
        const val jUnitExt = "1.1.5"
    }

    // Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val navigationCommonKtx =
        "androidx.navigation:navigation-common-ktx:${Versions.navigation}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"

    // Compose
    const val activityCompose =
        "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeFoundation = "androidx.compose.foundation:foundation"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeUiTestJUnit4 = "androidx.compose.ui:ui-test-junit4"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Retrofit 2
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3}"

    // KotlinX Serialization
    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val kotlinxSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinxSerializationConverter}"

    // Testing
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
}