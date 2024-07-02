![BG_ZOOM_ONE_ESP_(1) 1](https://github.com/nandojmj/Alura_Challenge_API_REST_Foro_hub/assets/156966097/599524af-2368-4ed1-aa06-ee12ec5aa758)

# ClinicaVoll_Alura

 ***ONE | Fase 3 - Especialización Back-End  G6 Alura - Oracle Next Education***

[![Alura Latam](https://img.shields.io/badge/Alura-Latam-blue?style=flat)](https://www.aluracursos.com/)
[![Static Badge](https://img.shields.io/badge/ONE-Oracle_Next_Education-orange?style=flat&logo=oracle&logoColor=orange)](https://www.oracle.com/co/education/oracle-next-education/) 
[![Static Badge](https://img.shields.io/badge/test-status-%23009929?logo=github)](#)
[![Static Badge](https://img.shields.io/badge/license-MIT-blue)](#)
[![Endpoint Badge](https://img.shields.io/endpoint?url=https%3A%2F%2Fhits.dwyl.com%2Fnandojmj%2FAlura_ClinicaVollmed.json&style=flat&logo=github&color=brightgreen)](#)

Este curso va a desarrollar una API REST para un consultorio médico ficticio llamado Voll.med. Como el curso está enfocado únicamente en la construcción de una API REST utilizando Java y Spring, no habrá ningún tipo de interfaz por parte del usuario, pero sí un desafío para mí hacer una aplicación del lado del cliente que se integre con esta API.


### 1er. Curso de Spring Boot 3: desarrollar una API Rest en Java

- Cree una API Rest de Java desde cero con Spring Boot
- Desarrolle CRUD usando la base de datos MySQL
- Use Flyway como una herramienta de migración de API
- Realizar validaciones usando Bean Validation
- Realizar paginación de datos API

### 2do. Curso Spring Boot 3: aplique las mejores prácticas y proteja una API Rest

- Aprenda buenas practicas en diseño de API
- Aprenda fundamentos basicos de autenticación y autorización
- Aprenda a retornar codigos de error HTTP
- Aprenda fundamentos de Spring Security

### 3er. Curso Spring Boot 3: documentar, probar y preparar una API para su implementación

- Aprenda a aislar código de reglas de negocio en una aplicación
- Implementar principios SOLID
- Documentar una API siguiendo el estándar OpenAPI
- Aprenda a escribir pruebas automatizadas en una aplicación con Spring Boot
- Cree una aplicación con Spring Boot
- Use variables de entorno y prepare una aplicación para su implementación

 
 
## Configurando el entorno Java  

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Git-Github-blue?style=flat&logo=GitHub)](https://github.com/)]
[![Static Badge](https://img.shields.io/badge/Spring%20Initializr%20-application-%236DB33F?logo=Spring&logoColor=%236DB33F)](#)
[![Static Badge](https://img.shields.io/badge/Mysql-%234479A1?logo=mysql&logoColor=white)](#)
[![Static Badge](https://img.shields.io/badge/MySQL_Workbench-SQL%20Development%20Tool-blue?logo=mysql&logoColor=white)](#)
[![Static Badge](https://img.shields.io/badge/Swagger-valid%2F3.0-green?logo=swagger)](#)
[![Static Badge](https://img.shields.io/badge/Insomnia-REST%20Client-%234000BF?logo=Insomnia&logoColor=%234000BF)](#)
[![Static Badge](https://img.shields.io/badge/app-Trello-%231466c3?style=flat&logo=trello)](https://trello.com/)

Asegúrese de tener instalado o contar con herramientas como:


- Git y GitHub 
- IntelliJ IDEA Community Edition
- Java JDK: versión: 17 en adelante
- Spring Initializr  - [https://start.spring.io/](https://start.spring.io/)
- MySQL relational database management system (RDBMS)
- MySQL Workbench: SQL Development
- Insomnia o Postman

**Dependencias para agregar al crear el proyecto en Spring Initializr:**

- Spring Data JPA
- Lombok
- Spring Web
- Spring Boot DevTools
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security
- Springdoc

 ![med0](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/ea6487da-7044-4bd9-ba0d-f1827b5462e8)

&nbsp;

## Construcción de la base de datos
[![Static Badge](https://img.shields.io/badge/Configuracion_del_entorno-%230067ff?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/MySQL_Workbench-SQL%20Development%20Tool-blue?logo=mysql&logoColor=white)](#)
[![Static Badge](https://img.shields.io/badge/Flyway-Database%20Migrations-%23CC0200?logo=Flyway&logoColor=%23CC0200)](#)


Para integrar una base de datos a nuestro proyecto Spring, nos solicitaron agregar algunas dependencias en nuestro pom.xml :

- Validation
- MySQL Driver
- Spring Data JPA
- Flyway Migration
  
&nbsp;
#### Base de datos MySQL (Nombre de esquema utilizado en este Challenge: *vollmed_api*)

*Diagrama implementado para crear base de datos:*

![EER_Base de datos](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/2865bcb2-0710-49ee-98bf-7216118667f0)


> [!NOTE]
> Antes de pasar a la etapa de migraciones del proyecto, te sugerimos crear la base de datos y configurarla según se mencionó anteriormente. 

### Migración en el proyecto
Las migraciones son comandos en lenguaje SQL para la configuración de la base de datos creada.

> [!IMPORTANTE]
> Recuerda siempre pausar/detener la ejecución del proyecto Spring para crear/cambiar las migraciones.


![bdtablamed](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/d1dca283-6689-46d6-a30a-d6ec448ffa87)

*Formato para crear archivo sql para Flyway Migration:*

```java
V1__create-table-medicos.sql
V2__alter-table-medicos-add-telefono.sql
V3__alter-table-medicos-add-activo.sql
V4__create-table-usuarios.sql
V5__create-table-pacientes.sql
V6__create-table-consultas.sql
V7__alter-table-consultas-add-motivo.sql
.
```
Tabla creadas en la base de datos, con registro de versiones Flyway Migration
```java
forohub_alura.flyway_schema_history
```
y observamos el contenido de la tabla: 


![flyway](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/482b1ca6-d2b8-4117-814a-871048ff6188)

&nbsp;


## Pruebas de la API
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/MySQL_Workbench-SQL%20Development%20Tool-blue?logo=mysql&logoColor=white)](#)
[![Static Badge](https://img.shields.io/badge/Insomnia-REST%20Client-%234000BF?logo=Insomnia&logoColor=%234000BF)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

Las pruebas de las funcionalidades de la API pueden realizarse utilizando alguna herramienta de pruebas de API, como Postman o Insomnia.

En este caso utilizamos: Insomnia: `https://insomnia.rest` para probar la API, como por ejemplo:


***Obtener Usuarios registrados en la base de datos:***


 
![med1](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/066a4d6d-00d0-4cab-82a4-a704830503d8)

![med2](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/a8366618-9a28-48b0-a65e-583f6079b052)

![med3](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/a75b85bd-a698-4544-bd54-bc5e1eb1c524)

![med4](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/f54fe97c-b749-4b3b-b150-2df31762b6fe)

![med5](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/8aa5e086-2424-4d94-9779-3a52a8e4bc1d)

![med6](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/3b629930-3f1a-433a-b6eb-7fc29e7a5df8)

![med7](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/199c1564-80cf-46e3-8bd8-193417600f53)

![med8](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/9f11cf78-ba63-4d70-9177-e43619f83aad)



![med19](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/4f6bc77b-f775-4864-9d7d-145231aae973)

![med20](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/cbcc1977-60e6-497b-878e-20cc46db8cab)

![med21](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/aeffd4aa-11c3-4bc1-9b6a-7480a52afb87)

![med22](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/8652903b-c8a7-44d6-8091-2f307694e8d5)

![med23](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/acd5deb0-bf1e-4f40-8c79-96d761aa1bf7)

![med24](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/6fed5b9d-594e-45f1-8b50-1a030f19fa49)

![med25](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/ee533ea8-0af6-4a2d-bd1f-fa90431e3948)

![med26](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/4e0808d9-4940-47be-bdac-ac260a80fb6b)





&nbsp;


## Autenticación con Spring Security
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Insomnia-REST%20Client-%234000BF?logo=Insomnia&logoColor=%234000BF)](#)

Implementa un mecanismo de autenticación en la API para que los usuarios puedan autenticarse y enviar solicitudes a ella. A partir de ahora, solo los usuarios autenticados pueden interactuar con la API.

> [!NOTE]
> Recuerda agregar la dependencia `Spring Security` en tu archivo pom.xml (si aún no lo has hecho en la etapa de configuración del entorno Java y Spring).

### Configuración de seguridad

Para configurar la autenticación en tu proyecto, es necesario definir tu clase SecurityConfigurations con información para el acceso a través de solicitudes http, utilizando anotaciones como `@Configuration` y `@EnableWebSecurity`, así como la clase spring `HttpSecurity`.


*Fragmento de Codigo de la clase SecurityConfigurations:*
```java
 // Resto del código omitido...
 /**
 * Configuración de seguridad para la aplicación.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurations {

    // Lista de rutas que se permiten sin autenticación
    private static final String[] AUTH_WHITELIST = {
            "/usuarios/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

    // Inyección del filtro de seguridad personalizado
    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Desactiva la protección CSRF para APIs RESTful
                 // Configura la política de sesión como stateless
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
                .authorizeHttpRequests(auth -> auth
                        // Permitir todas las solicitudes POST al endpoint /login
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        // Permitir las rutas en AUTH_WHITELIST sin autenticación
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        // Permitir el registro de usuarios
                        .requestMatchers(HttpMethod.POST, "/usuario/register").permitAll()
                        // Proteger las rutas /admin/** solo para usuarios con el rol ADMIN
                        .requestMatchers("/admin/**").hasAuthority(ADMIN.name())
                        .requestMatchers(HttpMethod.POST, "/cursos/**").hasAuthority(ADMIN.name())
 // Resto del código omitido...
```
&nbsp;



 

##  Documentación con Swagger - (Opcional) ![Static Badge](https://img.shields.io/badge/Swagger-valid%2F3.0-green?logo=swagger)
 [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)

Se nos solicito documentar nuestra  API con Spring Swagger. Swagger es una herramienta extremadamente ventajosa para tu API, ya que ofrece una interfaz amigable y accesible, así como una forma de documentación automática generada simultáneamente con el desarrollo de la API. Es una herramienta basada en el estándar OpenAPI que nos permite documentar y probar nuestros Web APIs,

### Accediendo a la interfaz gráfica - Swagger UI

Una vez realizada la configuración, ya podremos acceder a la interfaz gráfica de Swagger desde la dirección ```http://localhost:8080/swagger-ui/index.html```. El resultado sería el siguiente:

![med33](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/4f206a89-bea4-43cb-b2db-7108affb1e5e)



Ingresando a Autenticacion- Login de la interface realizamos el login con datos email y contraseña del usuario registrado. Realizamos un clic en Execute:

 ![swagger_login2](https://github.com/nandojmj/Alura_Challenge_API_REST_Foro_hub/assets/156966097/4b49472b-faaa-4286-b938-8292bf43ed72)

Como resultado obtenemos un estado Code 200, si el login es valido. En el body se encuentra el token generado: 

![swagger_login3](https://github.com/nandojmj/Alura_Challenge_API_REST_Foro_hub/assets/156966097/7527cbf0-e147-4906-8717-042ecce35d4b)

Se ha incluido un botón [ Authorize ] en la interfaz, que nos permitirá añadir un Token JWT a la cabecera de las peticiones HTTP que realicemos hacia los Controladores de Web API. Copiamos el token generado y lo pegamos dentro de Autorize , en el campo value y clickeamos Authorize:

![swagger_login4](https://github.com/nandojmj/Alura_Challenge_API_REST_Foro_hub/assets/156966097/1bdfcc17-4280-42dd-8f7d-eb9004f4ea28)



![med32](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/08c29bc0-a079-4fc9-b1d0-85ce4258ac5c)


![med28](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/44b0f84b-d2ab-4ae6-985d-2d47965bc6b4)

![med29](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/c8d405be-e8dc-4463-b91e-5f269db57f1f)

![med30](https://github.com/nandojmj/Alura_ClinicaVollmed/assets/156966097/900f5e51-4548-4447-b8a9-07ce9f39fccd)






    
&nbsp;
 
## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

* Clona o descarga desde Github el repositorio en tu disco local.
* Importa el proyecto en tu IDE de Java (este proyecto se realizo en IntelliJ IDEA).
* Configura las dependencias y ajusta la configuración según sea necesario.
* Corre la aplicación para interactuar con la base de datos y alguna herramienta de pruebas de API, como Postman o Insomnia.


## Glossary [![Static Badge](https://img.shields.io/badge/status-under%20construction-%2393a8ac)](#)

- **DTO (Data Transfer Object)**: Objetos utilizados para transferir datos entre el backend y el frontend.
- **JPA (Java Persistence API)**: API estándar de Java para mapear objetos a una base de datos relacional.
- **Hibernate**: Framework de mapeo objeto-relacional para Java.
- **API (Application Programming Interface)**: Conjunto de reglas y definiciones que permite a las aplicaciones interactuar entre sí.
- **DTO (Data Transfer Object)**: Patrón de diseño que se utiliza para transferir datos entre subsistemas de un software. En este contexto, se utilizan para transferir datos entre el backend y el frontend de la aplicación.
- **JPA (Java Persistence API)**: API estándar de Java para el mapeo objeto-relacional. Permite mapear objetos de dominio a tablas de base de datos y viceversa.
- **Hibernate**: Framework de mapeo objeto-relacional para Java. Facilita el trabajo con JPA y proporciona funcionalidades adicionales para interactuar con la base de datos.
- **Spring Boot**: Framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones basadas en Spring con una configuración mínima. Proporciona un conjunto de bibliotecas y herramientas que simplifican el desarrollo de aplicaciones empresariales.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional de código abierto y potente. Se utiliza en este proyecto como el motor de base de datos para almacenar los libros y autores.
- **Maven**: Herramienta de gestión de proyectos de software que se utiliza para construir y gestionar proyectos Java. Facilita la gestión de dependencias, la compilación y la ejecución de pruebas, entre otras tareas.
- **DataSource**: Configuración que define la conexión a la base de datos, incluyendo la URL, el nombre de usuario y la contraseña.
- **Hibernate Dialect**: Configuración que especifica el dialecto SQL que Hibernate debe utilizar para interactuar con la base de datos. En este caso, se utiliza el dialecto de HSQL.
- **Spring Data JPA**: Parte del ecosistema de Spring que simplifica el acceso a datos en aplicaciones basadas en Spring. Proporciona una abstracción sobre JPA y facilita la implementación de repositorios de datos.
- **CascadeType**: Enumeración que define las operaciones de cascada que deben aplicarse a las relaciones entre entidades. Por ejemplo, si se elimina un autor, las operaciones en cascada pueden eliminar automáticamente los libros asociados a ese autor.
- **FetchType**: Enumeración que define cómo se cargan los datos asociados a una relación entre entidades. FetchType.EAGER indica que los datos deben cargarse de forma inmediata, mientras que FetchType.LAZY indica que los datos deben cargarse solo cuando sean necesarios.
- **Principal**: En el contexto de este proyecto, se refiere a la clase principal que coordina las operaciones principales de la aplicación, como la consulta y el almacenamiento de datos.
- **Estructura del Proyecto**: Organización y disposición de los archivos y paquetes que componen el proyecto. Una estructura de proyecto bien definida facilita la comprensión y el mantenimiento del código.
- **Diagrama de Estructura del Proyecto**: Representación visual de la estructura del proyecto, que muestra cómo se relacionan los diferentes componentes y cómo fluye la información a través de ellos. Ayuda a comprender la arquitectura y el diseño del proyecto.


## MIT License

```sql

Copyright (c) [2024] [Hernando Muñoz J]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```

```sql

Copyright (c) [2024] [Hernando Muñoz J]

Se concede permiso, de forma gratuita, a cualquier persona que obtenga una copia
de este software y de los archivos de documentación asociados (el "Software"), para tratar
con el Software sin restricciones, incluyendo sin limitación los derechos
para usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender
copias del Software, y para permitir a las personas a las que se les proporcione el Software
para hacerlo, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las
copias o porciones sustanciales del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O
IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIABILIDAD,
IDONEIDAD PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS
AUTORES O TITULARES DE DERECHOS DE AUTOR SERÁN RESPONSABLES DE CUALQUIER RECLAMO, DAÑOS U OTROS
RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE OTRO MODO, QUE SURJA DE,
FUERA O EN RELACIÓN CON EL SOFTWARE O EL USO U OTROS TRATOS EN EL
SOFTWARE.

```



