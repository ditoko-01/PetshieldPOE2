import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "1.9.23" // Ensure this version is correct
    kotlin("plugin.parcelize")
    id("com.google.gms.google-services")
    id("org.jetbrains.kotlin.plugin.compose") // Corrected plugin declaration

}

android {
    namespace = "com.petshield.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.petshield.app"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    // This block is no longer needed
    // composeOptions {
    //     kotlinCompilerExtensionVersion = "1.5.13"
    // }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    // AndroidX
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))


    // Material Design
    implementation("com.google.android.material:material:1.10.0")


    // Firebase
    implementation("com.google.firebase:firebase-auth-ktx:22.3.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.8.1")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.firebase:firebase-messaging-ktx")
    // Kotlin Serialization (optional)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.google.firebase:firebase-analytics")

    // Jetpack Compose
    val composeBom = platform("androidx.compose:compose-bom:2024.09.00") // Check for the latest version
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.activity:activity-compose:1.9.0") // Check for the latest version
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.1") // Check for the latest version



}
