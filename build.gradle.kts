plugins {
    kotlin("jvm") version "2.1.21" apply false
    `maven-publish`
}

group = "com.trionesdev.weixin"
version = property("version") as String

subprojects {
    repositories {
        mavenCentral()
    }
    
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "maven-publish")
    
    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.toVersion(property("maven_compiler_source"))
        targetCompatibility = JavaVersion.toVersion(property("maven_compiler_target"))
    }
    
    configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
        jvmToolchain(property("maven_compiler_source").toString().toInt())
    }
    
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.trionesdev.weixin"
                artifactId = project.name
                version = project.version.toString()
                
                from(components["java"])
            }
        }
    }
}