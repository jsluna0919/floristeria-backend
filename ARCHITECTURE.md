# 🏗️ Arquitectura del Proyecto

Este backend está construido a partir del **Scaffold Clean Architecture de Bancolombia**, lo cual permite mantener un código desacoplado, fácil de mantener y escalar.

## 📖 Antes de iniciar

Empezaremos por explicar los diferentes componentes del proyecto, partiendo de los **componentes externos**, continuando con los **componentes core de negocio (dominio)** y, por último, el **inicio y configuración de la aplicación**.

📌 Recomendación de lectura:  
[Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

---

## 🏛️ Arquitectura General

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

---

## 🔹 Domain

Es el módulo más interno de la arquitectura, pertenece a la **capa del dominio** y encapsula la lógica y reglas del negocio mediante **modelos y entidades del dominio**.

---

## 🔹 Use Cases

Este módulo de Gradle, perteneciente a la capa de dominio, implementa los **casos de uso del sistema**.

- Define la lógica de aplicación.
- Reacciona a las invocaciones desde el módulo de *Entry Points*.
- Orquesta los flujos hacia los modelos del dominio.

---

## 🔹 Infrastructure

La infraestructura implementa la comunicación con sistemas externos mediante diferentes componentes:

### 🛠️ Helpers
- Contienen utilidades generales para los **Driven Adapters** y **Entry Points**.
- Usan **generics** para modelar comportamientos comunes en persistencia.
- Siguen patrones como [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006).
- No deben existir de manera aislada, siempre se usan en los **Driven Adapters**.

### 🌐 Driven Adapters
Representan implementaciones externas a nuestro sistema, como:
- Conexiones a **bases de datos**.
- **Servicios REST / SOAP**.
- Lectura de archivos planos.
- Cualquier otra fuente u origen de datos.

### 🎯 Entry Points
- Representan los **puntos de entrada de la aplicación**.
- Definen dónde inician los flujos de negocio (ejemplo: controladores REST).

---

## 🔹 Application

Este es el módulo más externo de la arquitectura.

- **Ensamblaje de módulos**: resuelve dependencias y crea los beans de los *Use Cases* de manera automática.
- **Configuración**: define cómo interactúan los componentes internos.
- **Ejecución**: es el único módulo donde encontramos la función `public static void main(String[] args)`.
- **Component Scan**: los *Use Cases* se disponibilizan automáticamente gracias a un `@ComponentScan` ubicado en esta capa.

---

📌 Gracias a esta organización, el proyecto mantiene una separación clara de responsabilidades, facilitando el mantenimiento, la escalabilidad y la implementación de nuevas funcionalidades.
