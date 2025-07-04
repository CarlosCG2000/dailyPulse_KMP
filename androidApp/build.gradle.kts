plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.ccanogo.dailypulse.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.ccanogo.dailypulse.android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared) // Contiene el código del módulo compartido, es decir de la carpeta shared el 'androidMain' y 'commonMain' (pero no el 'iosMain')
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.compose) // coil
    implementation(libs.androidx.navigation.compose) // Navigation compose
    implementation(libs.koin.android) // koin 1
    implementation(libs.koin.androidx.compose) // koin 2
    implementation (libs.accompanist.swiperefresh)


    debugImplementation(libs.compose.ui.tooling)
}