plugins {
    kotlin("jvm") version "2.0.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:2.0.9")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.5.3")
}


tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.avis.MainKt")
}

