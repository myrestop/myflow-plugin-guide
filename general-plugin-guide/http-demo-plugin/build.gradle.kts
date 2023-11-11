import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.20"
}

group = "runflow"
version = "0.0.1"

val ktor = "2.3.6"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor")
    implementation("io.ktor:ktor-server-core-jvm:$ktor")
    implementation("io.ktor:ktor-serialization-jackson-jvm:$ktor")
    implementation("io.ktor:ktor-server-cio-jvm:$ktor")
    implementation("ch.qos.logback:logback-classic:1.4.7")
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
