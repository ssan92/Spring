# ACME
## Service API - Empleados que han estado en la oficina dentro del mismo período de tiemp


## Tecnologia Usada

- Java 1.8
- Spring Framework 2.6.1
- Swagger2
- h2

## Lógica de Nogocio
Se ingresar varios empleados con sus marcaciones.
Luego se debe indentificar que empleados(pares) han coincidido en la oficina (marcaciones)
Generar un archivo con esa información

## Data inicial
Se carga dos los datos propuestos (import.sql), donde:
- el primer conjunto de datos contiene la fecha 2021-12-06 al 2021-12-12 (una semana de trabajo)
- el segundo conjunto de datos contiene la fecha 2021-12-13 al 2021-12-19 (otra semana de trabajo)

## Arquitectura aplicada
Se creo 3 capas:
- repositorio.- donde se encuentra la consulta hacia base de datos(h2)
- servicio.- logica, validaciones
- controller.- servicios

## Desarrollo
Se crearon 3 tablas:
- Empleado.- donde se registran los empleados
- Marcacion.- donde se registran las marcaciones
- Reporte.- se registran los resultados obtenidos

Se expusieron 3 capacidades del servicio:
- empleado.- permite la creacion de empleado con sus marcaciones
- marcacion.- permite la consula de los empleados que conincidieron con los horarios, en base a una fecha inicio y una fecha fin
- reporte.- permite generar el archivo reporte.txt, con el historial de la información consultada previamente

## URL
Este proyecto se utilizo Swagger2, que nos permite una interzas para probar los servicios
http://localhost:8080/swagger-ui.html .- interfaz para testear los servicios
http://localhost:8080/h2-console .- base de datos temporal
http://localhost:8080/v2/api-docs .- informacion del servicio



