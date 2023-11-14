plugins {
    kotlin("multiplatform") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
}

group = "runflow"
version = "1.0.0"

repositories {
    mavenCentral()
}

val hostOs = System.getProperty("os.name")
val isArm64 = System.getProperty("os.arch") == "aarch64"
val isMingwX64 = hostOs.startsWith("Windows")

kotlin {
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
                // runTask?.args("")
            }
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            }
        }
        val nativeTest by getting
    }
}

tasks.build {
    doLast {
        copy {
            if (isMingwX64) {
                from("./build/bin/native/debugExecutable/commandline-demo-plugin.exe")
                into("./windows")
                rename { old -> old.removeSuffix(".exe") }
            } else {
                from("./build/bin/native/debugExecutable/commandline-demo-plugin")
                into(if (hostOs.startsWith("mac", true)) "./macos" else "./linux")
            }
        }
    }
}
