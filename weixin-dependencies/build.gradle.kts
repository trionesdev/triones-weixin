plugins {
    `java-platform`
    `maven-publish`
}

group = "com.trionesdev.weixin"
version = property("version") as String

dependencies {
    val junitJupiterVersion = "5.8.2"
    val kotlinVersion = "2.1.21"
    val commonsCodecVersion = "1.16.0"
    val commonsLang3Version = "3.13.0"
    val commonsCollections4Version = "4.4"
    val guavaVersion = "31.0.1-jre"
    val okhttpVersion = "4.12.0"
    val fastjson2Version = "2.0.42"
    val jacksonVersion = "2.15.3"
    val slf4jVersion = "2.0.6"

    constraints {
        // JUnit
        api("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
        
        // Kotlin dependencies
        api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        api("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        api("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
        
        // Apache Commons
        api("commons-codec:commons-codec:$commonsCodecVersion")
        api("org.apache.commons:commons-lang3:$commonsLang3Version")
        api("org.apache.commons:commons-collections4:$commonsCollections4Version")
        
        // Google Guava
        api("com.google.guava:guava:$guavaVersion")
        
        // OkHttp
        api("com.squareup.okhttp3:okhttp:$okhttpVersion")
        api("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
        
        // FastJSON
        api("com.alibaba.fastjson2:fastjson2:$fastjson2Version")
        
        // Jackson
        api("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
        api("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
        api("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
        
        // SLF4J
        api("org.slf4j:slf4j-api:$slf4jVersion")
        api("org.slf4j:slf4j-simple:$slf4jVersion")
        
                // Internal modules
        api("com.trionesdev.weixin:weixin-base:${property("version")}")
        api("com.trionesdev.weixin:weixin-miniprogram:${property("version")}")
        api("com.trionesdev.weixin:weixin-offiaccount:${property("version")}")
        api("com.trionesdev.weixin:weixin-oplatform:${property("version")}")
        api("com.trionesdev.weixin:weixin-web:${property("version")}")
        api("com.trionesdev.weixin:weixin-app:${property("version")}")
    }
}
