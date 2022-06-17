FROM openjdk:18-jdk-alpine
EXPOSE 8080
COPY target/gusmelford_books.jar gusmelford_books.jar
ENTRYPOINT ["java","-jar","/gusmelford_books.jar"]