/*
 Copyright © 2020-2023 Petr Panteleyev <petr@panteleyev.org>
 SPDX-License-Identifier: BSD-2-Clause
 */
group = "org.panteleyev"
version = "1.5.2"

plugins {
    java
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "1.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

gradlePlugin {
    val jpackage by plugins.creating {
        id = "org.panteleyev.jpackageplugin"
        version = project.version
        displayName = "JPackage Gradle Plugin"
        description = "A plugin that executes jpackage tool from JDK-14+"
        implementationClass = "org.panteleyev.jpackage.JPackageGradlePlugin"
    }
}

pluginBundle {
    website = "https://github.com/petr-panteleyev/jpackage-gradle-plugin"
    vcsUrl = "https://github.com/petr-panteleyev/jpackage-gradle-plugin.git"
    tags = listOf("jpackage")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
