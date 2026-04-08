plugins {
    kotlin("jvm")
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("com.google.guava:guava")
    implementation("org.apache.commons:commons-collections4")
    implementation("commons-codec:commons-codec")
    implementation("com.fasterxml.jackson.core:jackson-core")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.core:jackson-annotations")
    implementation("com.alibaba.fastjson2:fastjson2")
    implementation("org.slf4j:slf4j-api")
}

kotlin {
    jvmToolchain(property("maven_compiler_source").toString().toInt())
}

tasks.test {
    useJUnitPlatform()
}
