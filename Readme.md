# jpackageFX 

This project is created to demonstrate how to build a very simple Java FX application with only the javaFX modules 
as none Java SE dependencies. 
The project and uses jpackage to create an installer.
Using Github Actions, an installer is created for Mac, Windows and Linux.

## The Gradle build

For the Gradle build configuration I have chosen not to use the gradle plugin provided by the FX developers just
to make the steps performed in the build more transparent.
An important thing to note is the fact that the javaFX dependencies are platform dependent. Another set of jars is
needed when you build for Linux than When building for Windows or Mac. So first Gradle needs to discover the OS 
Using the discovered operating system, the dependencies for javaFX are resolved.

### Gradle toolchain
With the release of Java 17 in September 2021, Gradle was not directly compatible to the Java version. This triggered me to apply the toolchain feature introduced in Gradle 6.7. Using the toolchain configuration, it is possible that while Gradle itself runs Java 11.x, a artifact can be build against Java 17.

## jpackage

Jpackage is a now part of Java 16. The tool uses jlink to create a dedicated runtime
for the application. With this dedicated image, an installer is created for the OS on which the build script is executed.

## Github Actions

Finally, the project uses github actions to request the Github environment to perform the build for Windows, Linux and Mac-OS
The resulting artifact is available as download with the build.



