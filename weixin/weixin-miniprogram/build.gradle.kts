plugins {
    kotlin("jvm")
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    implementation(project(":weixin:weixin-base"))
    
    implementation("org.jetbrains.kotlin:kotlin-reflect:${property("kotlin_version")}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${property("kotlin_version")}")
    
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
}

kotlin {
    jvmToolchain(property("maven_compiler_source").toString().toInt())
}

tasks.test {
    useJUnitPlatform()
}