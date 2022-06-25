# Calculadora
Microservicio de una calculadora realizado con Spring Boot, OpenApi y Mockito.

La calculadora traza todos los resultados usando la librería tracer-1.0.0.jar.

#### Tecnologías

Apache Maven 3.6.3

Java JDK 11

#### Librerías necesarias
<!-- librería de tracer -->
	<dependency>
		<groupId>io.corp.calculator</groupId>
		<artifactId>tracer</artifactId>
		<version>1.0.0</version>
		<scope>system</scope>
		<systemPath>${basedir}/lib/tracer-1.0.0.jar</systemPath>
	</dependency>

---


#### Cómo compilar el microservicio en local

Para construir el proyecto se utilizarán los siguientes comandos:

> mvn clean install

Este comando ejecuta:
 1. Limpiar el target del proyecto.
 2. Recogerá las librerías necesarias para el microservicio.
 3. Compilará el proyecto con las propiedades de la carpeta `src/main/resources/application.properties`

---

#### Cómo ejecutar el microservicio en local
Siguiendo los pasos anteriores, bastaría con ejecutar el comando en la carpeta raíz del proyecto:

> mvn spring-boot:run

---

#### Servicios disponibles
Una vez lanzado el microservicio para conocer el detalle de la llamada al API y las respuestas esperadas podemos acceder a la siguientes URL:
> **local**: http://localhost:8082/openapi/swagger-ui/index.html

---

#### Comó agregar una nueva operación al microservicio

Para agregar una nueva operación al API deben seguirse los siguientes pasos:

 1. Agregar una nueva operacion en la clase Operador del paquete DTO.
 2. Crear clase con el nombre de la operacion y heredar la clase ListaOperacion con su metodo execute del paquete Model; crear su constructor y modificar la clase execute para el fin de la operación.
 3. Agregar un nuevo case que evalue y ejecute la nueva operacion del paquete Mapper.

---