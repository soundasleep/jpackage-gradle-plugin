/*
 Copyright (c) Petr Panteleyev. All rights reserved.
 Licensed under the BSD license. See LICENSE file in the project root for full license information.
 */
group = "org.panteleyev"
version = "0.0.1"

plugins {
    `java-gradle-plugin`
    `maven-publish`
    signing
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("com.gradle.plugin-publish") version "0.12.0"
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
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
