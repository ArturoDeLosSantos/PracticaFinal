# Practica Final

Para la conexión a Base de datos he creado en pgAdmin4 un Database llamada "PracticaFinal"

En application.properties están las credenciales para la conexión a dicha Base de Datos creando la tabla automáticamente.
//Se me olvidó quitar la linea "spring.jpa.hibernate.ddl-auto = update" por lo que cada vez que ejecuto el programa las tablas se van a modificar

He adjuntado la carga de datos en la ruta src/main/resource archivo superheroe.sql 
No he adjuntado el archivo .sql de las estructura de la tabla (la creación de la tabla es automática)

La inserción de datos inicialmente las he hecho directamente desde el destor de base de datos DBeaver.
La prueba de las peticiones GET,PUT,POST Y DELETE están comprobadas desde el Postman.


La subida del proyecto a GitHub está hecha directamente desde rama principal (no me he creado ramas de desarrollo).

FALTA POR HACER:
- Los test unitarios de los servicios
- Utilizar patron DAO para comunicación entre cliente y controller,mapeado entre entidades y DTO usando Streams, optional, lambdas...
- Gestión centralizada de los erroes
- Test de integración

MEJORA NOTABLE:
- Hacer relaciónes de tablas:
   Crear las entidades SUPERHEROE y ESTADO y relacionar el id_estado con el estado de la tabla Superheroe.
   Aunque la tabla ESTADO solamente tendrá dos entradas, una con valor "vivo" y otra con valor "muerto"
