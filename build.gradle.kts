import org.jetbrains.compose.compose

plugins {

    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.kotlin.kapt") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build362"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    implementation("com.google.dagger:dagger:2.30.1")
    kapt("com.google.dagger:dagger-compiler:2.30.1")

    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
