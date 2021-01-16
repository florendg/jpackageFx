# jpackageFX 

This project is created to demonstrate how to build a very simple Java FX application and use
jpackage to create an installer. Using Github Actions, an installer is created for Mac, Windows and Linux.

## The Gradle build

For the Gradle build configuration I have chosen not to use the gradle plugin provided by the FX developers just
to make the steps performed in the build more transparent.
An important thing to note is the fact that the javaFX dependencies are platform dependent. Another set of jars is
needed when you build for Linux than When building for Windows or Mac. So first Gradle needs to discover the OS 

## jpackage

TODO

## Github Actions

TODO



