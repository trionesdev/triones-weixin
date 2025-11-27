plugins {

    `maven-publish`
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    constraints {
        // JUnit
        api("org.junit.jupiter:junit-jupiter-api:5.8.2")
        
        // Kotlin dependencies
        api("org.jetbrains.kotlin:kotlin-stdlib:${property("kotlin_version")}")
        api("org.jetbrains.kotlin:kotlin-reflect:${property("kotlin_version")}")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${property("kotlin_version")}")
        api("org.jetbrains.kotlin:kotlin-test:${property("kotlin_version")}")
        
        // Apache Commons
        api("commons-codec:commons-codec:1.16.0")
        api("org.apache.commons:commons-lang3:3.13.0")
        api("org.apache.commons:commons-collections4:4.4")
        
        // Google Guava
        api("com.google.guava:guava:31.0.1-jre")
        
        // OkHttp
        api("com.squareup.okhttp3:okhttp:4.12.0")
        api("com.squareup.okhttp3:logging-interceptor:4.12.0")
        
        // FastJSON
        api("com.alibaba.fastjson2:fastjson2:2.0.42")
        
        // Jackson
        api("com.fasterxml.jackson.core:jackson-core:${property("jackson_version")}")
        api("com.fasterxml.jackson.core:jackson-databind:${property("jackson_version")}")
        api("com.fasterxml.jackson.core:jackson-annotations:${property("jackson_version")}")
        
        // SLF4J
        api("org.slf4j:slf4j-api:2.0.6")
        api("org.slf4j:slf4j-simple:2.0.6")
        
                // Internal modules
        api("com.trionesdev.weixin:weixin-base:${property("version")}")
        api("com.trionesdev.weixin:weixin-miniprogram:${property("version")}")
        api("com.trionesdev.weixin:weixin-offiaccount:${property("version")}")
        api("com.trionesdev.weixin:weixin-oplatform:${property("version")}")
        api("com.trionesdev.weixin:weixin-web:${property("version")}")
        api("com.trionesdev.weixin:weixin-app:${property("version")}")
    }
}

