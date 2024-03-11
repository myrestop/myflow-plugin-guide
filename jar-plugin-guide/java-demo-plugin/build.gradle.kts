import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.compose") version "1.5.12"
}

group = "runflow"
version = "1.0.0"
val entry = "java-demo-plugin.jar"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val myflowVersion = "1.0.5"

dependencies {
    compileOnly(compose.desktop.currentOs)
    compileOnly("top.myrest:myflow-kit:$myflowVersion")
    testImplementation("top.myrest:myflow-baseimpl:$myflowVersion")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.jar {
    archiveFileName.set(entry)
    val exists = mutableSetOf<String>()
    val files = mutableListOf<Any>()
    configurations.runtimeClasspath.get().allDependencies.forEach { dependency ->
        configurations.runtimeClasspath.get().files(dependency).forEach { file ->
            if (exists.add(file.name)) {
                files.add(if (file.isDirectory) file else zipTree(file))
            }
        }
    }
    from(files)
    exclude(".gitkeep")
}

tasks.build {
    doLast {
        copy {
            from("./build/libs/$entry")
            into(".")
        }
        val specFile = file("./plugin-spec.yml")
        val specContent = specFile.readLines(Charsets.UTF_8).joinToString(separator = System.lineSeparator()) {
            if (it.startsWith("version:")) {
                "version: $version"
            } else if (it.startsWith("entry:")) {
                "entry: ./$entry"
            } else it
        }
        specFile.writeText(specContent, Charsets.UTF_8)
        specFile.appendText(System.lineSeparator())
    }
}

tasks.register("packagePlugin") {
    group = "build"
    description = "Package as runflow plugin zip file."
    dependsOn("build")
    doLast {
        val zipFile = file("./runflow-plugin.zip")
        val zip = ZipOutputStream(FileOutputStream(zipFile))
        val files = mutableListOf(
            file(entry) to entry,
            file("plugin-spec.yml") to "plugin-spec.yml",
            file("description_en_us.md") to "description_en_us.md",
            file("description_zh_cn.md") to "description_zh_cn.md",
        )
        file("language").listFiles()?.forEach {
            files.add(it to "language/${it.name}")
        }
        file("logos").listFiles()?.forEach {
            files.add(it to "logos/${it.name}")
        }
        files.filter {
            it.first.exists()
        }.forEach {
            zip.putNextEntry(ZipEntry(it.second))
            zip.write(it.first.readBytes())
        }
        zip.closeEntry()
        zip.close()
    }
}