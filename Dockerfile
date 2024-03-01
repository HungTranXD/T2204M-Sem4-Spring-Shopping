#FROM maven:3.9.6-amazoncorretto-21-al2023 AS builder
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
#FROM eclipse-temurin:21-jre-jammy
#WORKDIR /app
#COPY --from=builder /app/target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]
#EXPOSE 8080





# 1 - A basic Dockerfile
#FROM eclipse-temurin:21-jdk-jammy
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

# 2 - The entry point
#FROM eclipse-temurin:21-jdk-jammy
#VOLUME /tmp
#COPY run.sh .
#COPY target/*.jar app.jar
#ENTRYPOINT ["/run.sh"]

#FROM eclipse-temurin:21-jdk-jammy
#VOLUME /tmp
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]

# 3 - A better docker file (layered image)
#FROM eclipse-temurin:21-jdk-jammy
#VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.t2204msem4springshopping.T2204MSem4SpringShoppingApplication"]



#FROM eclipse-temurin:17-jdk-alpine as build
#WORKDIR /workspace/app
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src
#
#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]



FROM eclipse-temurin:21-jdk-jammy as builder
WORKDIR extracted

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN java -Djarmode=layertools -jar target/*.jar extract

FROM eclipse-temurin:21-jre-jammy
VOLUME /tmp
COPY --from=builder extracted/dependencies/ ./
COPY --from=builder extracted/spring-boot-loader/ ./
COPY --from=builder extracted/snapshot-dependencies ./
COPY --from=builder extracted/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.launch.JarLauncher"]