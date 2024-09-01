plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
// https://mvnrepository.com/artifact/com.h2database/h2
    runtimeOnly("com.h2database:h2:2.3.232")
    implementation(libs.spring.boot.data.jpa)
    implementation(project(":domain"))
}
