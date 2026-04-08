plugins {
    `java-library`
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    api(platform(project(":weixin-dependencies")))
}

subprojects {
    apply(plugin = "java-library")
    
    dependencies {
        implementation(platform(project(":weixin-dependencies")))
        
        // Kotlin dependencies
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        
        // Jackson for modules that use annotations / databind
        implementation("com.fasterxml.jackson.core:jackson-annotations")
        implementation("com.fasterxml.jackson.core:jackson-databind")
        implementation("com.fasterxml.jackson.core:jackson-core")

        // OkHttp and Apache Commons Codec used directly in submodules
        implementation("com.squareup.okhttp3:okhttp")
        implementation("com.squareup.okhttp3:logging-interceptor")
        implementation("commons-codec:commons-codec")

        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.junit.jupiter:junit-jupiter-api")
    }
}
