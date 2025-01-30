plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")//for hiding database connections in gitignore
    implementation("at.favre.lib:bcrypt:0.9.0")//for hashing sensitive data
    implementation(files("gradle/lib/mysql-connector-j-9.1.0.jar"))//for database connectivity
}

tasks.test {
    useJUnitPlatform()
}