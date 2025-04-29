Psychedelicraft
============
A continuation of Psychedelicraft for 1.7.10
It's a fork of original repository which uses GTNH Gradle for build, it allows you to build it even with newer version of JDK & Gradle
This fork disables most GL ERROR checks so it doesn't infinitely spam console with Angelica or OptiFine. Some effects surprisingly work even with other shader mods

(Uses fork of IvToolkit - https://github.com/quentin452/IvToolkit)

Quick guide:

Requires: [Gradle](https://gradle.org), [Java 17 or 21 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* gradle setupDecompWorkspace
* Depending on your IDE:
  * IntelliJ idea: Import gradle project, then: gradle genIntellijRuns
  * Eclipse: gradle eclipse
* And you're done!