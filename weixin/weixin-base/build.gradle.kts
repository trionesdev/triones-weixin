plugins {
    kotlin("jvm")
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    implementation("com.squareup.okhttp3:okhttp:${property("okhttp_version")}")
    implementation("com.squareup.okhttp3:logging-interceptor:${property("okhttp_version")}")
    implementation("com.google.guava:guava:${property("guava_version")}")
    implementation("org.apache.commons:commons-collections4:${property("commons_collections4_version")}")
    implementation("commons-codec:commons-codec:${property("commons_codec_version")}")
    implementation("com.fasterxml.jackson.core:jackson-core:${property("jackson_version")}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${property("jackson_version")}")
    implementation("com.fasterxml.jackson.core:jackson-annotations:${property("jackson_version")}")
    implementation("com.alibaba.fastjson2:fastjson2:${property("fastjson2_version")}")
    implementation("org.slf4j:slf4j-api:${property("slf4j_version")}")
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