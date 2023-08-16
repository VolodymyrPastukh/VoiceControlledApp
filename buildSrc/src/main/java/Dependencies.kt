object Dependencies {

    object Ktx {
        private const val lifecycleKtxVersion = "2.5.1"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleKtxVersion"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleKtxVersion"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleKtxVersion"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$lifecycleKtxVersion"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$lifecycleKtxVersion"
    }

    object Core {
        const val coreKtx = "androidx.core:core-ktx:1.10.1"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.7.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val viewBinding = "androidx.databinding:viewbinding:8.1.0"
    }

    object Compose {
        const val material1 = "androidx.compose.material:material:1.4.3"
        const val material3 = "androidx.compose.material3:material3:1.2.0-alpha02"
        const val navigation = "androidx.navigation:navigation-compose:2.6.0"
        const val activity = "androidx.activity:activity-compose:1.7.2"
        const val constraint = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
        const val uitool = "androidx.compose.ui:ui-tooling:1.4.3"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1"
    }

    object DI {
        private const val koinVersion = "3.4.0"
        const val koin = "io.insert-koin:koin-android:$koinVersion"
        const val koinExt = "io.insert-koin:koin-android-ext:3.0.1"
        const val compose = "io.insert-koin:koin-androidx-compose:3.4.4"
    }
    
    object GoogleApi{
        const val cloudSpeech = "com.google.cloud:google-cloud-speech:1.29.1"
        const val oAuth2 =  "com.google.auth:google-auth-library-oauth2-http:0.26.0"
        const val okHttp =  "io.grpc:grpc-okhttp:1.38.1"
        const val grpc =  "io.grpc:grpc-stub:1.39.0"
    }

    object Utils{
        const val gson = "com.google.code.gson:gson:2.9.1"
    }
}