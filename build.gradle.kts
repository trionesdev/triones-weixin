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

    apply(plugin = "maven-publish")

    if (name != "weixin-dependencies") {
        apply(plugin = "org.jetbrains.kotlin.jvm")
    }

    plugins.withType<JavaPlugin> {
        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.toVersion(property("maven_compiler_source").toString())
            targetCompatibility = JavaVersion.toVersion(property("maven_compiler_target").toString())
        }
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
            jvmToolchain(property("maven_compiler_source").toString().toInt())
        }
    }

    val mavenPublication = extensions
        .getByType<PublishingExtension>()
        .publications
        .register("maven", MavenPublication::class) {
            groupId = "com.trionesdev.weixin"
            artifactId = project.name
            version = project.version.toString()
        }

    afterEvaluate {
        val component = components.findByName("java") ?: components.findByName("javaPlatform")
        if (component != null) {
            mavenPublication.get().from(component)
        }
    }

    // Configure publishing repositories
    extensions.configure<PublishingExtension> {
        repositories {
            maven {
                name = "trionesdev"
                url = uri("https://maven.cnb.cool/trionesdev/mvn/-/packages/")
                credentials {
                    username = properties["mavenRepoUsername"] as String
                    password = properties["mavenRepoPassword"] as String
                }
            }
        }
    }
}
