plugins {
    kotlin("jvm")
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    implementation(project(":weixin:weixin-base"))
    
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}