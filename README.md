# Challenge Literalura

## Descripción
El reto consiste en crear una aplicación que permita a los usuarios buscar libros y ver los detalles de cada uno de ellos. La aplicación debe contar con las siguientes funcionalidades:
1. Buscar libros por titulo.
2. Listar Libros registrados.
3. Listar autores registrados.
4. Listar autores vivos en un determinado año.
5. Listar libros por idioma
6. Salir de la aplicación.


## Dependencias y Tecnologías Utilizadas

- Se uso JPA para la persistencia de los datos de los libros y autores.
    ```xml 
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```
- Se uso Jackson como procesador de JSON  , para la lectura de los datos de los libros y autores.
    ```xml 
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.16.0</version>
    </dependency>
    ```
- Como base de datos se uso postgresql.
    ```xml 
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    ```
## Estructura del Proyecto
El proyecto se divide en las siguientes carpetas:
- **model:** Contiene las clases que representan los datos de los libros y autores.
- **repository:** Contiene las clases que manejan la lectura de los datos de los libros y autores.
- **service:** Contiene las clases que realizan las operaciones de busqueda de libros y autores.
- **view:** Contiene las clases que muestran los datos de los libros y autores al usuario.
- **validator:** Contiene las clases que validan las entrada de datos del usuario.


## Ejecución de la aplicación
**1. Buscar libros por titulo.**
Para buscar libros por titulo se debe ingresar el titulo del libro que se desea buscar. La aplicación mostrará los libros que coincidan con el titulo ingresado.
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/EjecucionOpcion1.png)

**2. Listar Libros registrados.**
Para listar los libros registrados se debe seleccionar la opción 2. La aplicación mostrará todos los libros registrados.
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/EjecucionOpcion2.png)

**3. Listar autores registrados.**
Para listar los autores registrados se debe seleccionar la opción 3. La aplicación mostrará todos los autores registrados.
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/EjecucionOpcion3.png)

**4. Listar autores vivos en un determinado año.**
Para listar los autores vivos en un determinado año se debe seleccionar la opción 4. La aplicación solicitará el año del cual se desea conocer los autores vivos. La aplicación mostrará los autores vivos en el año ingresado.
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/EjecucionOpcion4.png)

**5. Listar libros por idioma.**
Para listar los libros por idioma se debe seleccionar la opción 5. La aplicación solicitará el idioma del cual se desea conocer los libros. La aplicación mostrará los libros en el idioma ingresado.
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/EjecucionOpcion5.png)

## Base de Datos
- Modelo de la base de datos
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/Diagrama.png)

- Tabla de libros
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/TablaLibros.png)

- Tabla de autores
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/TablaAutores.png)

- Tabla de idiomas
![](https://github.com/HumbleG0d/Challenge_Literalura/blob/Literalura/sources/TabalaIdiomas.png)


