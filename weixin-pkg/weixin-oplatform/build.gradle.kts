plugins {
    kotlin("jvm")
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    implementation(project(":weixin-pkg:weixin-base"))
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}
