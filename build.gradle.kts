plugins {
    java
}

group = "com.radar"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(files("libs/HytaleServer.jar"))
}

tasks.jar {
    archiveBaseName.set("HytaleRadar")
    archiveVersion.set("1.0.0")
    manifest {
        attributes("Main-Class" to "com.radar.RadarPlugin")
    }
}
