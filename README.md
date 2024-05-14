# Challenge ELDAR
## Descripción

Este proyecto es una aplicación desarrollada en Java con Spring Boot que ofrece funcionalidades para el procesamiento de operaciones con tarjetas de crédito. La aplicación expone una API REST para realizar diversas operaciones, como registrar nuevas tarjetas, actualizar datos de tarjetas existentes, obtener información sobre tarjetas y validar tarjetas para operaciones.

## Librerías y Dependencias

-   **Spring Boot**: Framework de aplicación Java que facilita la creación de aplicaciones basadas en Spring con un mínimo de configuración.
-   **Spring Data JPA**: Proporciona una capa de abstracción sobre las tecnologías de acceso a datos, permitiendo interactuar con la base de datos de manera más sencilla.
-   **H2 Database**: Base de datos en memoria utilizada para desarrollo y pruebas..
-   **Lombok**: Biblioteca que simplifica la creación de clases Java al reducir la cantidad de código boilerplate.

## Funcionalidades Principales

-   **Registrar Nueva Tarjeta**: Permite registrar una nueva tarjeta de crédito en el sistema.
-   **Actualizar Datos de Tarjeta**: Permite actualizar los datos de una tarjeta existente en el sistema.
-   **Obtener Información de Tarjeta**: Permite obtener información detallada sobre una tarjeta específica.
-   **Validar Tarjeta para Operaciones**: Permite verificar si una tarjeta es válida para realizar operaciones, según ciertos criterios predefinidos.

## Instalación y Uso

1.  Clona este repositorio en tu máquina local.
2.  Abre el proyecto en tu IDE preferido.
3.  Configura la base de datos según tus necesidades en el archivo `application.properties`.
4.  Ejecuta la aplicación como una aplicación Spring Boot.
    > mvn spring-boot:run

### Operacion
	> [URL]/operaciones/.

- REQUEST

  	{
  		"marca"  :"VISA",
  		"monto"  :  50.20
  	}

- RESPONSE

  	{
  	"marca":  "VISA",
  	"monto":  50.2,
  	"tasa":  10.458333333333334
  	}

Por ultimo, les recuerdo que en la carpeta **Collection** pueden encontrar una colección para POSTMAN para facilitarles el armado de los request y URL's correspondientes.

La aplicación puede ser probada apuntando a la siguiente dirección publica:
- http://54.207.99.202 
