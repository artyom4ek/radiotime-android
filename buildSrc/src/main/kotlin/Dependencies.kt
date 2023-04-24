object Deps {

    // Core
    private const val coreKtxVersion = "1.10.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val lifecycleRuntimeKtxVersion = "2.6.1"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxVersion"

    // Compose
    private const val activityComposeVersion = "1.7.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val composeBomVersion = "2023.04.01"
    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeUiTestJUnit4 = "androidx.compose.ui:ui-test-junit4"

    // Timber
    private const val timberVersion = "5.0.1"
    const val timber = "com.jakewharton.timber:timber:$timberVersion"

    // Testing
    private const val jUnitVersion = "4.13.2"
    const val jUnit = "junit:junit:$jUnitVersion"

    private const val jUnitExtVersion = "1.1.5"
    const val jUnitExt = "androidx.test.ext:junit:$jUnitExtVersion"

    private const val espressoCoreVersion = "3.5.1"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
}