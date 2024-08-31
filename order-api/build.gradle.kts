plugins {
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(libs.spring.boot.actuator)
    implementation(libs.spring.boot.web)
    implementation(libs.spring.context.tx)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.spring.boot.validation)
    implementation(libs.kotlin.reflect)
    implementation(project(":domain"))
    implementation(project(":infrastructure:h2-db"))
}
