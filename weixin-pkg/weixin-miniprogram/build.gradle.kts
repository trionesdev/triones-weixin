plugins {
    kotlin("jvm")
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    implementation(project(":weixin-pkg:weixin-base"))
}

kotlin {
    jvmToolchain(property("maven_compiler_source").toString().toInt())
}

tasks.test {
    useJUnitPlatform()
}
