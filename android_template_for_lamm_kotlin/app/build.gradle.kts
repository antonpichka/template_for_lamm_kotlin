plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.compose)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    compileSdk = 35
    namespace "com.android_template_for_lamm_kotlin"

    defaultConfig {
        applicationId "com.android_template_for_lamm_kotlin"
        minSdk 24
        targetSdk 35
        versionCode 1
        versionName "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.compose.animation:animation-core:$compose_version")
    implementation("androidx.compose.animation:animation:$compose_version")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.compose.ui:ui-geometry:$compose_version")
    implementation("androidx.compose.ui:ui-graphics:$compose_version")
    implementation("androidx.compose.foundation:foundation-layout:$compose_version")
    implementation("androidx.compose.ui:ui-text:$compose_version")
    implementation("androidx.compose.ui:ui-util:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")
    implementation("androidx.core:core-ktx:1.8.0")

    /*
    implementation "androidx.core:core-ktx:1.8.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    implementation "androidx.activity:activity-compose:1.5.1"
    implementation platform("androidx.compose:compose-bom:2022.10.00")
    implementation "androidx.compose.ui:ui"
    implementation "androidx.compose.ui:ui-graphics"
    implementation "androidx.compose.ui:ui-tooling-preview"
    implementation "androidx.compose.material3:material3"
    testImplementation "junit:junit:4.13.2"

    debugImplementation "androidx.compose.ui:ui-tooling"
    debugImplementation "androidx.compose.ui:ui-test-manifest"*/
}