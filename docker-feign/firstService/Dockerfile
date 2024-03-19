FROM openjdk:17-jdk-alpine

WORKDIR /app

# Копируем скомпилированные классы и зависимости в контейнер
COPY target/firstService-0.0.1-SNAPSHOT.jar firstService.jar

EXPOSE 8080
# Указываем команду для запуска микросервиса
CMD ["java", "-jar", "firstService.jar"]
