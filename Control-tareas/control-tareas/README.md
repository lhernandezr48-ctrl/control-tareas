# Control de Tareas Personales

## Descripción del proyecto

Este proyecto consiste en la creación de un programa Java para administrar tareas personales. Cada tarea contiene un identificador, título, descripción, prioridad y estado de finalización.

El proyecto permite registrar varias tareas, almacenarlas en una colección y mostrar cuáles están pendientes y cuáles han sido completadas.

Además, se aplican los fundamentos de Maven, HTTP y REST mediante el diseño lógico de una API para administrar las tareas. No se implementa una API real ni se utiliza Spring Boot.

## Tecnologías utilizadas

- Java 17
- Maven
- IntelliJ IDEA
- Git
- GitHub
- HTTP
- REST
- JSON

## Datos del proyecto Maven

| Dato | Valor |
|---|---|
| GroupId | `com.estudiante` |
| ArtifactId | `control-tareas` |
| Version | `1.0-SNAPSHOT` |
| Java | `17` |

### GroupId

El `groupId` identifica el grupo, organización o desarrollador al que pertenece el proyecto. En este caso se utiliza `com.estudiante`.

### ArtifactId

El `artifactId` identifica el nombre del proyecto dentro de Maven. En este proyecto es `control-tareas`.

### Version

La `version` permite identificar la versión actual del proyecto. En este caso se utiliza `1.0-SNAPSHOT`, que representa una versión de desarrollo.

## Estructura del proyecto

```text
[Lilian Gabriela Hernandez Rodriguez]
[9941-25-27807]
tt
control-tareas/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── estudiante/
│   │               ├── Tarea.java
│   │               └── Main.java
│   └── test/
│       └── java/
├── evidencias/
├── pom.xml
├── README.md
└── .gitignore