plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
}

//Resolve the used operating system
var currentOS = org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentOperatingSystem()
var platform = ""
if (currentOS.isMacOsX) {
    platform = "mac"
} else if (currentOS.isLinux) {
    platform = "linux"
} else if (currentOS.isWindows) {
    platform = "win"
}

val javaFXVersion = "16"

dependencies {
    implementation("org.openjfx:javafx-base:${javaFXVersion}:${platform}")
    implementation("org.openjfx:javafx-controls:${javaFXVersion}:${platform}")
    implementation("org.openjfx:javafx-graphics:${javaFXVersion}:${platform}")
    implementation("org.openjfx:javafx-fxml:${javaFXVersion}:${platform}")
}

application {
    // Define the main class for the application.
    mainModule.set("dev.vulture.packagefx")
    mainClass.set("dev.vulture.packagefx.App")
}

java {
    modularity.inferModulePath.set(true)
    version = JavaVersion.VERSION_16
}

tasks {
    task<Copy>("copyDependencies") {
        from(configurations.runtimeClasspath)
        into("$buildDir/modules")
    }

    task<Exec>("package") {
        dependsOn(listOf("build", "copyDependencies"))
        commandLine("jpackage")
        args(listOf(
                "-n", "fxBuildDemo",
                "-p", "$buildDir/modules"+File.pathSeparator+"$buildDir/libs",
                "-d", "$buildDir/installer",
                "-m", "dev.vulture.packagefx/dev.vulture.packagefx.App"))
    }

}
