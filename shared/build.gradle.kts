import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    // alias(libs.plugins.composeMultiplatformPlugin)
    id("co.touchlab.skie") version "0.10.4" // Para crear wrapper del viewModel en ios, uso skie
    kotlin("plugin.serialization") version "1.9.20"
    alias(libs.plugins.sqlDelight)
    // alias(libs.plugins.kotlinCocoapods)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    // ___________ Nuevo ___________
//    jvm("desktop")
//
//    js(IR) {
//        binaries.executable()
//        browser()
//    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            // Llamadas a servicios API / BACK (tb se necesitas especificos en cada plataforma, ver mas abajo)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)

            implementation(libs.sql.coroutines.extensions)

//            implementation(libs.koin.compose)
//            implementation(libs.compose.foundation)
//            implementation(libs.compose.material)
//            implementation(libs.kamel.image)
//            implementation(libs.voyager.navigator)
//            implementation(libs.voyager.transitions)
            // implementation(libs.compose.runtime)
            // implementation(libs.compose.components.resources)
            // implementation(compose.material3)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        // Se pueden añadir las dependencias de android y de ios (del modulo compartido shared, que es en el gradle que nos encontramos
        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.runtime.ktx)
            implementation(libs.androidx.lifecycle.viewmodel.android)
            implementation(libs.ktor.client.android) // añadir para ktor
            implementation(libs.sql.android.driver)  // añadir sqlDelight
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin) // añadir para ktor
            implementation(libs.sql.native.driver) // añadir sqlDelight
        }

//        jsMain.dependencies {
//            implementation(libs.ktor.client.js)
//        }
//
//        val desktopMain by getting {
//            dependencies {
//                implementation(libs.ktor.client.cio)
//                implementation(libs.sql.desktop.driver)
//            }
//        }
    }
}

android {
    namespace = "com.ccanogo.dailypulse"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    databases {
        create(name = "DailyPulseDatabase") {
            packageName.set("com.ccanogo.dailypulse.database") // IMPORTANTE: donde se van a encontrar todas las reglas de la base de datos, solo va a ser en esta localización
        }
    }
}