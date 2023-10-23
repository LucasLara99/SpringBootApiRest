# SpringBootApiRest

El ejercicio se trata de validar conocimientos de Spring, servicios REST y consultas SQL.

## Tarea 1

Crear un esquema de BBDD según el modelo adjunto (ejercicio_ddl.sql)

## Tarea 2

Crear una consulta que devuelva los siguientes campos:

* id_pais
* nombre_pais
* id_ciudad
* nombre_ciudad
* valor. Se devolverá el valor de la ciudad, en caso de que ésta sea NULL
  se devolverá el valor del país correspondiente.
* descripción_tipo_jjoo: Si de invierno o de verano.
  En caso de que el país no haya sido sede este campo tendrá NULL.
* número_veces_sede: El número de veces que la ciudad ha sido sede.

Es deseable que se relice en una única consulta SQL.

La consulta es la siguiente:

```sql
SELECT P.id_pais                              AS id_pais,
       P.nombre_pais                          AS nombre_pais,
       C.id_ciudad                            AS id_ciudad,
       C.nombre_ciudad                        AS nombre_ciudad,
       COALESCE(C.valor_ciudad, P.valor_pais) AS valor,
       TJ.descripcion_tipo                    AS descripción_tipo_jjoo,
       COUNT(SJ.año)                          AS número_veces_sede
FROM pais AS P
         LEFT JOIN ciudad AS C ON P.id_pais = C.id_pais
         LEFT JOIN sede_jjoo AS SJ ON C.id_ciudad = SJ.sede
         LEFT JOIN tipo_jjoo AS TJ ON SJ.id_tipo_jjoo = TJ.id_tipo_jjoo
GROUP BY P.id_pais, C.id_ciudad, TJ.descripcion_tipo;
```

## Tarea 3

Crear una clase DAO para realizar la consulta y su correspondiente test
con Junit.

## Tarea 4

Crear una petición REST que muestre la consulta de la tarea 2.

## Tarea 5

Se creará un CRUD para la tabla de SEDE_JJOO, que permita añadir, editar y borrar entradas para esta tabla:

- La petición de alta de una nueva sede de JJOO deberá contener toda la información necesaria para añadir
  entradas en tantas tablas alternativas del modelo como sea necesario (CIUDAD, PAIS, ...).
- Se valorará que alguna de estas operaciones contengan campos obligatorios y opcionales en la petición.
- Adicionalmente, se considerará de forma positiva la gestión de la transaccionalidad en la clase DAO de la tarea 3.

## Tarea 6

Escribir un pequeño README que indique:

- Cómo desplegar la aplicación
- Una pequeña guía de cómo están estructuradas las clases y el código

Indicar que tecnologías se utilizaría.

## Requisitos

Se requiere la utilización de:

- MySQL
- Junit
- Maven
- Spring
- Spring Boot como arquetipo de la aplicación