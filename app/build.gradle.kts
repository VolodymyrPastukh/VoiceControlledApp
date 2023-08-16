plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = Config.packageName
    compileSdk = Config.targetVersion

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minVersion
        targetSdk = Config.targetVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        viewBinding = true
    }

    packagingOptions(action = Action {
        exclude("META-INF/*")
    })

}

dependencies {
    implementation(Dependencies.Core.coreKtx)
    implementation(Dependencies.Core.appCompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.constraintLayout)
    implementation(Dependencies.Core.viewBinding)

    implementation(Dependencies.Ktx.viewModel)
    implementation(Dependencies.Ktx.liveData)
    implementation(Dependencies.Ktx.runtime)
    implementation(Dependencies.Ktx.navigationUi)
    implementation(Dependencies.Ktx.navigationFragment)

    implementation(Dependencies.GoogleApi.oAuth2)
    implementation(Dependencies.GoogleApi.grpc)
    implementation(Dependencies.GoogleApi.cloudSpeech)
    implementation(Dependencies.GoogleApi.okHttp)

    implementation(Dependencies.DI.koin)
    implementation(Dependencies.DI.koinExt)
}