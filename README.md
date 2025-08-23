# 🌸 Floristería App - Backend

Este es el backend de la aplicación **Floristería App**, desarrollado para gestionar pedidos de una floristería y almacenar la información en la base de datos de manera estructurada y eficiente.

## 🚀 Tecnologías utilizadas
- **Java 21**
- **Spring Boot**
- **Gradle**
- **Scaffold Clean Architecture (Bancolombia)**

## 🏗️ Arquitectura
El proyecto sigue la arquitectura **Clean Architecture** del scaffold de Bancolombia, organizada en capas:

- **Domain** → Modelos y lógica de negocio.
- **Use Case** → Casos de uso y reglas de aplicación.
- **Infrastructure** → Adaptadores externos (bases de datos, servicios, etc.).
- **Applications** → Configuración y ensamblaje de dependencias.
- **Deployment** → Configuración para despliegue (Docker, scripts, etc.).

👉 Para una explicación más detallada consulta el archivo [ARCHITECTURE.md](ARCHITECTURE.md).

## ⚙️ Requisitos previos
- [Java 21](https://openjdk.org/projects/jdk/21/)
- [Gradle](https://gradle.org/) (incluye wrapper en el repo)
- Base de datos (ejemplo: PostgreSQL, definida en `application.yaml`)

## ▶️ Ejecución del proyecto
Clona este repositorio y ejecuta:

```
bash
# Clonar el repositorio
git clone https://github.com/jsluna0919/floristeria-backend.git
cd floristeria-backend

# Construir el proyecto
./gradlew build

# Ejecutar el backend
./gradlew bootRun
```

El backend se levantará por defecto en:
👉 http://localhost:8080

🧪 Tests

Para correr las pruebas:

```
./gradlew test
```

📡 Endpoints principales

📦 Pedidos

```
h
GET /pedidos → Lista todos los pedidos.
GET /pedidos/{id} → Obtiene un pedido por su ID.
POST /pedidos → Crea un nuevo pedido.
PUT /pedidos/{id} → Actualiza un pedido existente.
DELETE /pedidos/{id} → Elimina un pedido por su ID.
```

Ejemplo JSON:

```
json
{
  "cliente": {
    "tipoDocumento": "C.C",
    "numeroDocumento": "32104176",
    "nombre": "Lilliana Marcela",
    "apellido": "Tilano Tavera",
    "telefono": "3152508237",
    "email": "admonfloristeri@gmail.com",
    "ciudad": "Medellín",
    "direccion": "cra 71 # 44 - 35"
  },
  "destinatario": {
    "nombre": "Juan Santiago Luna",
    "telefono": "3158201429",
    "ciudad": "Med",
    "direccion": "cra 71 # 44 - 35 "
  },
  "arreglo": {
    "nombre": "Cumpleanios",
    "descripcion": "Bouquete con torta y globos",
    "anexos": "Botella de vino ",
    "precio": 120000,
    "imagen": "https://floristeriamistad.com/producto/5-kit-cumpleanos-premium-bouquet-torta-globo",
    "mensaje": "Feliz cumple"
  },
  "fechaEntrega": "17 de agosto 2025"
}
```

👤 Clientes
```
h
GET /clientes → Lista todos los clientes.
GET /clientes/{id} → Obtiene un cliente por su ID.
POST /clientes → Registra un nuevo cliente.
PUT /clientes/{id} → Actualiza un cliente existente.
DELETE /clientes/{id} → Elimina un cliente por su ID.
DELETE /clientes?tipoDocumento={tipo}&numeroDocumento={numero}  → Elimina un cliente por tipo y número de documento
```

Ejemplo JSON:

```
json
{
  "tipoDocumento": "c.c",
  "numeroDocumento": "1001360953",
  "nombre": "Caglos Albegto",
  "apellido": "Jesus Jediondo",
  "telefono": "1236544",
  "email": "caglos@gmail.com",
  "ciudad": "medellin",
  "direccion": "calle 49aa # tata"
}
```

🌺 Arreglos Florales

```
h
GET /arreglos → Lista todos los arreglos florales.
GET /arreglos/{id} → Obtiene un arreglo floral por su ID.
POST /arreglos → Crea un nuevo arreglo floral.
PUT /arreglos/{id} → Actualiza un arreglo floral existente.
DELETE /arreglos/{id} → Elimina un arreglo floral por su ID.
```

Ejemplo JSON:

```
json
{
  "nombre": "Ref 13 – Arreglo primaveral en caja decorativa",
  "descripcion": "Caja decorativa con 20 flores y follajes",
  "precio": 120000,
  "imagen": "https://floristeriamistad.com/producto/ref-13-arreglo-primaveral-en-caja-decorativa/"
}
```

🎁 Destinatarios

```
h
GET /destinatarios → Lista los destinatarios.
GET /destinatarios/{id} → Obtiene un destinatario por su ID.
POST /destinatarios → Registra un destinatario.
PUT /destinatarios/{id} → Actualiza un destinatario existente.
DELETE /destinatarios/{id} → Elimina un destinatario por su ID.
DELETE /destinatarios?nombre={nombre}&telefono={telefono} → Elimina un destinatario por nombre y teléfono
```
Ejemplo JSON:

```
json
{
  "nombre": "Sofia Rivera",
  "telefono": "254565325",
  "ciudad": "Bogota",
  "direccion": "calle 3 - 25 "
}
```

✨ Autor

Juan Santiago Luna Tilano

📌 Proyecto académico/personal desarrollado con enfoque en buenas prácticas de arquitectura de software.