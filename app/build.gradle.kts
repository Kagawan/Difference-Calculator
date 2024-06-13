import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
    java
    checkstyle
    id ("com.adarshr.test-logger") version "3.2.0"
}

group = "hexlet.code"

version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.ginsberg:junit5-system-exit:1.1.2")
    implementation ("info.picocli:picocli:4.7.6")
    //implementation ("com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.13.4.2")
    //implementation ("com.fasterxml.jackson.dataformat', name: 'jackson-dataformat-json', version: '2.13.4.2")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }
testlogger {
    showStandardStreams = true
}