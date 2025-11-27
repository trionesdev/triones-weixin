plugins {
    `java-library`
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    api(project(":weixin-dependencies"))
}

subprojects {
    apply(plugin = "java-library")
    
    dependencies {
        implementation(platform(project(":weixin-dependencies")))
        
        // Kotlin dependencies
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.junit.jupiter:junit-jupiter-api")
    }
}