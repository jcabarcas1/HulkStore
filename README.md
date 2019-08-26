# Hulk Store

Este es un proyecto de Springboot el cual expone una API RestFull.
Al correr el proyecto se puede acceder al frontend mediante la url de la api.
Por ejemplo:
 - Si la url expuesta por el tomcat de springboot es localhost:8080 entonces a través de ella podemos ingresar al
   frontend de la aplicación.


El código fuente del frontend se encuentra en la carpeta FrontEnd-HS y esta desarrollado con Angular 8.

En la carpeta _src/main/resources/static_ se encuentran los archivos minificados del FrontEnd.

## Configuración

Para configurar el proyecto debemos ir al archivo _src/main/resources/application.properties_ (Crearlo de ser necesario)
y configurar los siguientes parámetros reemplazando por la información real de la base de datos

````
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=create-drop

spring.datasource.url=jdbc:mysql://localhost/DB_SCHEMA
spring.datasource.username=DB_USERNAME
spring.datasource.password=DB_PASSWORD
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
````

## Dependencias

````
 Gradle 5.5.1
 Java 8
 MySql 15.1
````


## Ejecución de pruebas unitarias


## Ejecución del proyecto