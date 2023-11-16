plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.1.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation ("io.github.bonigarcia:webdrivermanager:5.4.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation ("org.seleniumhq.selenium:selenium-java:4.10.0")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    testImplementation ("org.slf4j:slf4j-simple:1.7.36")
    // https://mvnrepository.com/artifact/org.apache.poi/poi
    implementation ("org.apache.poi:poi:5.2.3")
    // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
    implementation ("org.apache.poi:poi-ooxml:5.2.3")


}

tasks.test {
    useJUnitPlatform()
}