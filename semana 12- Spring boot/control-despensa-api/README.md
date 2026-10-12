# Control de Despensa API

**Estudiante:** Lilian Hernández
**Carné:** [9941-25-27807]

## Descripción del problema
API REST básica que permite consultar y analizar los productos
almacenados en la despensa de un hogar. Los datos se guardan en
memoria; no se usa base de datos.

## Tecnologías utilizadas
- Java 17 o superior
- Spring Boot (Spring Web)
- Maven
- IntelliJ IDEA

## Requisitos para ejecutar el proyecto
- JDK 17 o superior
- Maven (se incluye el wrapper `mvnw`)
- Puerto 8080 libre

## Estructura principal
```
control-despensa-api/
├── src/main/java/com/estudiante/despensa/
│   ├── ControlDespensaApiApplication.java
│   ├── controller/ProductoController.java
│   └── model/
│       ├── Producto.java
│       └── ResumenInventario.java
├── src/main/resources/application.properties
├── evidencias/
├── pom.xml
└── README.md
```

## Explicación de las clases
- **Producto:** representa un producto (id, nombre, categoría, cantidad
  y precio unitario). Valida sus datos y calcula el subtotal
  (cantidad × precio unitario).
- **ResumenInventario:** guarda la cantidad de productos, el total de
  unidades y el valor total del inventario.
- **ProductoController:** define los endpoints REST y mantiene la lista
  de productos en memoria.

## Tabla de endpoints
| Operación | Método | Ruta | Estado esperado |
|---|---|---|---|
| Listar productos | GET | /api/productos | 200 |
| Buscar por identificador | GET | /api/productos/{id} | 200 o 404 |
| Buscar por categoría | GET | /api/productos/categoria/{categoria} | 200 |
| Consultar stock bajo | GET | /api/productos/stock-bajo | 200 |
| Consultar producto de mayor valor | GET | /api/productos/mayor-valor | 200 |
| Obtener resumen | GET | /api/productos/resumen | 200 |

## Cómo ejecutar la aplicación
1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Ejecutar `ControlDespensaApiApplication`, o bien en la terminal:
   `./mvnw spring-boot:run` (en Windows: `mvnw.cmd spring-boot:run`).
4. Abrir `http://localhost:8080/api/productos`.

## Ejemplos de respuestas JSON

`GET /api/productos/3`
```json
{
  "id": 3,
  "nombre": "Arroz",
  "categoria": "Granos",
  "cantidad": 4,
  "precioUnitario": 8.5
}
```

`GET /api/productos/resumen`
```json
{
  "cantidadProductos": 6,
  "totalUnidades": 33,
  "valorTotal": 422.0
}
```

## Evidencias
El documento de Word con las capturas, cálculos y reflexión está en
la carpeta `evidencias/`.