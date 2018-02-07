# drone

* Esta es una implementacion del driver para drones

## Pruebas

* Para probar su funcionamiento, usted puede ejecutar la suite de pruebas
```
mvn clean test
```

* El resultado esperado debe indicar que las pruebas se han ejecutado correctamente

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.idealista.drone.impl.OperacionesDroneTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.552 sec - in com.idealista.drone.impl.OperacionesDroneTest

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
```

## Empaquetado

* Para empaquetar el codigo de la librería deberá ejecutar
```
mvn clean package
```

* El resultado esperado debe indicar que el jar se ha generado correctamente

```
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ driver ---
[INFO] Building jar: /home/miguelg/Codigo/personal/idealista/target/driver-1.0.0.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.093 s
[INFO] Finished at: 2018-02-07T01:23:50+01:00
[INFO] Final Memory: 22M/239M
[INFO] ------------------------------------------------------------------------
```


**Nota:** Para más información sobre utilización de la herramienta maven puede consultar su [documentacion online](http://maven.apache.org/guides/)


