import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent


plugins {
    application
    jacoco
    //java
    checkstyle
    //id ("com.adarshr.test-logger") version "3.2.0"
}

group = "hexlet.code"

version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1") // последний раз добавил версию
    //testImplementation("com.ginsberg:junit5-system-exit:1.1.2") // последний раз закоментировал
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") // последний раз добавил
    implementation ("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
}
tasks.withType<JavaCompile>(){
    options.compilerArgs.addAll(listOf("-Aproject=${project.group}/${project.name}"))
}
tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        //showStackTraces = true
        //showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports { xml.required.set(true) }
}
/*testlogger {
    showStandardStreams = true
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}*/
