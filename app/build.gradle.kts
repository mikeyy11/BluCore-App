plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.blucore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.blucore"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    //implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.google.android.material:material:1.9.0")  // For TabLayout
    implementation("com.android.support:recyclerview-v7:24.2.1")
    //implementation("com.google.firebase:firebase-firestore:11.4.2")

    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    // Firebase dependencies (no version needed when using BOM)
    implementation("com.google.firebase:firebase-firestore")
    //implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")
    //implementation("androidx.viewpager2:viewpager2:1.0.0")       // For ViewPager2

    implementation ("org.tensorflow:tensorflow-lite:2.8.0")





}
apply(plugin = "com.google.gms.google-services")
