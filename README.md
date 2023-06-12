## TiempoAire
Servicio web REST usando Spring boot.

Ejecutar el proyecto con Eclipse IDE o usar maven para poder construirlo y generar el jar.

Crear una base de datos en MySQL con el nombre "tiempoairedb"

Para construir el proyecto con Maven usando la consola, ubicarse dentro de la carpeta del proyecto
 ```
 cd TiempoAire
 ```

Ejecute lo siguiente para construir el proyecto
```
mvnw package
 ```

En la carpeta estan el siguiente archivo para crear los objetos de DataBase MySQL:
Contiene los objetos requeridos para la aplicacion.
Al final del archivo estan unos INSERT de ejemplos para poblar catalagos
```
TiempoAireDB_objetosNecesarios.sql
```

Despues de crear la DB y los objetos requeridos, ejecutar aplicación 
```
java -jar target/tiempoaire-0.0.1-SNAPSHOT.jar
```

Puede revisar los servicios REST disponibles usando la interfaz de Swagger
```
http://localhost:8080/WSTiempoAire/swagger-ui.html
```

