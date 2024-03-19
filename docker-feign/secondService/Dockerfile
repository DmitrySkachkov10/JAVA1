FROM openjdk:17-jdk-alpine

WORKDIR /app

# Копируем скомпилированные классы и зависимости в контейнер
COPY target/secondService-0.0.1-SNAPSHOT.jar secondService.jar

EXPOSE 8081
# Указываем команду для запуска микросервиса
CMD ["java", "-jar", "secondService.jar"]
