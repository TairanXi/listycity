plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.listycity"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.listycity"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Enable JUnit 5 for local unit tests
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

// Optional: another way to ensure JUnit Platform runs (mirrors the lab’s Step 26)
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation(files("/Users/X1/Library/Android/sdk/platforms/android-34/android.jar"))
    // Pin to an AGP-compatible Activity version
    implementation("androidx.activity:activity:1.9.3")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    // Do NOT add implementation(libs.activity) if it points to 1.11.0+

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")

    // Instrumented tests
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}


