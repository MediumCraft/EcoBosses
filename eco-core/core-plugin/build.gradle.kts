group = "com.willfp"
version = rootProject.version

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
    compileOnly("com.github.lokka30:LevelledMobs:3.1.4")
    compileOnly("com.ticxo.modelengine:api:R3.1.5")
}

publishing {
    publications {
        register("maven", MavenPublication::class) {
            from(components["java"])
            artifactId = rootProject.name
        }
    }

    repositories {
        maven {
            name = "auxilor"
            url = uri("https://repo.auxilor.io/repository/maven-releases/")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }
}

tasks {
    build {
        dependsOn(publishToMavenLocal)
    }
}
