plugins {
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("plugin.noarg") version "1.6.21"
    kotlin("plugin.allopen") version "1.6.21"
}

apply {
    plugin("org.jetbrains.kotlin.plugin.jpa")
    plugin("org.jetbrains.kotlin.plugin.noarg")
    plugin("org.jetbrains.kotlin.plugin.allopen")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-jpa")
    api(project(":service-starter:json"))
//    kapt(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
//    kotlin.sourceSets.main {
//        println("kotlin sourceSets buildDir :: $buildDir")
//        setBuildDir("$buildDir")
//    }
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}