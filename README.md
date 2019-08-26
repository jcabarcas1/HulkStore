# Hulk Store

Este es un proyecto de Springboot el cual expone una API RestFull.
Al correr el proyecto se puede acceder al frontend mediante la url de la api.
Por ejemplo:
 - Si la url expuesta por el tomcat de springboot es _http://localhost:8080_ entonces a través de ella podemos ingresar 
    al frontend de la aplicación.


El código fuente del frontend se encuentra en la carpeta FrontEnd-HS y esta desarrollado con Angular 8.

En la carpeta _src/main/resources/static_ se encuentran los archivos minificados del FrontEnd.

_Al ejecutar el proyecto se crearan los modelos de base de datos con Hibernate._

## Dependencias

   [Gradle 5.5.1](https://docs.gradle.org/5.5.1/userguide/userguide.html)    
   
   [Java 8](https://www.java.com/es/download/)
   
   [MariaDB 10.4.7 _(Es posible instalar un Xampp)_](https://downloads.mariadb.org/mariadb/10.4.7/)

## Configuración

Para configurar el proyecto debemos ir al archivo _src/main/resources/application.properties_ (Crearlo de ser necesario), 
pegar el siguiente texto y configurar los parámetros reemplazando por la información real de la base de datos

````
    spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.hibernate.ddl-auto=create-drop
    
    spring.datasource.url=jdbc:mysql://localhost/DB_SCHEMA
    spring.datasource.username=DB_USERNAME
    spring.datasource.password=DB_PASSWORD
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
````


## Ejecución del proyecto

Para ejecutar el proyecto podemos hacerlo con el siguiente comando mediante una consola en la raiz del proyecto:
````
    gradle bootRun
````

## Ejecución de pruebas unitarias

Para ejecutar las pruebas unitarias ingresar el siguiente comando mediante una consola en la raiz del proyecto:
````
    gradle test
````


