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

En la carpeta estan los siguientes script:
```
TiempoAireDB_objetosNecesarios.sql	<Contiene los objetos requeridos para la aplicacion>
TiempoAireDB_RegistrosParaCatalago.sql	<Contiene INSERTs de ejemplos para poblar catalagos>
```

Despues de crear la DB y los objetos requeridos, ejecutar aplicación 
```
java -jar target/tiempoaire-0.0.1-SNAPSHOT.jar
```

Puede revisar los servicios REST disponibles usando la interfaz de Swagger
```
http://localhost:8080/WSTiempoAire/swagger-ui.html
```

