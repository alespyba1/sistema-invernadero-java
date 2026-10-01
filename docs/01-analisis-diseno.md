# Análisis y diseño

# Análisis y diseño

## 1. Descripción del problema

### Qué sistema se va a representar

Un invernadero inteligente. 

El invernadero tiene tres sensores: uno mide la temperatura del aire, otro la humedad del ambiente y otro la humedad del suelo. También tiene un sistema de riego.

La idea es que el programa lea lo que marca cada sensor, diga si ese valor está bajo, adecuado o alto, y si el suelo está seco, prenda el riego.

### Qué información necesita manejar

De cada sensor: su identificador, dónde está instalado, si está activo o inactivo y lo que midió.

La unidad medición: °C para la temperatura y % para las dos humedades.

Rangos de cada sensor, para saber si un valor es bajo, adecuado o alto.

Sistema de riego: si está activo o inactivo.

### Qué elementos intervienen

Sensor de temperatura del aire 

Sensor de humedad ambiental

Sensor de humedad del suelo

Sistema de riego 

### Qué operaciones generales debe realizar

Medir cada sensor

Consultar la medición de un sensor

Interpretar la medición, si está baja, adecuada o alta

Activar o desactivar un sensor

Activar o desactivar el riego y consultar su estado

Decidir si se riega o no según la humedad del suelo

Mostrar cómo está todo el invernadero en un momento dado



## 2. Identificación de objetos

### Sensor

**Qué representa.** un sensor del invernadero, sin importar qué mida.

**Por qué debe existir como objeto.** Porque los tres sensores tienen los mismos datos (identificador, ubicación, estado y medición) y hacen cosas parecidas. Si no existe, habría que repetir lo mismo en cada tipo de sensor.

**Qué responsabilidad tendría.** Guardar lo que todos los sensores tienen en común y permitir conocer su medición.

### Sensor de temperatura

**Qué representa.** El sensor que mide la temperatura del aire, en °C.

**Por qué debe existir como objeto.** Tiene su propia unidad y sus propios rangos, a diferencia de los otros sensores. Una temperatura de 30° aprox para este sensor es temperatura alta, pero para otro sensor es diferente.

**Qué responsabilidad tendría.** Medir la temperatura y decir si está baja, adecuada o alta.

### Sensor de humedad ambiental

**Qué representa.** El sensor que mide la humedad del aire, en %.

**Por qué debe existir como objeto.** Usa % igual que el del suelo, pero sus rangos son otros y mide algo diferente.

**Qué responsabilidad tendría.** Medir la humedad del aire y decir si está baja, adecuada o alta.

### Sensor de humedad del suelo

**Qué representa.** El sensor que mide qué tan húmedo o seco está el suelo, en %.

**Por qué debe existir como objeto.** Tiene sus propios rangos y además su lectura es la que se usa para decidir si se riega.

**Qué responsabilidad tendría.** Medir la humedad del suelo y decir si está baja, adecuada o alta.

### Sistema de riego

**Qué representa.** Se encarga de regar las plantas.

**Por qué debe existir como objeto.** Si no esta haciendo algo: riega. Tiene su propio estado, activo o inactivo y va cambiando.

**Qué responsabilidad tendría.** Prenderse, apagarse, decir si está regando o no, y decidir si debe regar usando lo que dice el sensor de humedad del suelo.

### Invernadero

**Qué representa.** El lugar donde están instalados los sensores y el sistema de riego.

**Por qué debe existir como objeto.** Por que es el que se encarga de leer todo y decidir que hacer 

**Qué responsabilidad tendría.** Tener los sensores y el riego, mostrar cómo está cada uno y pedirle al riego que revise si hace falta regar.

---

## 3. Estado y comportamiento

| Objeto propuesto            | Responsabilidad                                              | Información que debe conservar                                           | Comportamientos que debe realizar                                                                                                                                                   |
|-----------------------------|--------------------------------------------------------------|--------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Sensor                      | Representar lo que tienen en común todos los sensores        | Identificador, ubicación, si está activo o inactivo y su última medición | Permite conocer su identificador, su ubicación y su última medición. Debe poder activarse, desactivarse y recibir una nueva medición.                                               |
| Sensor de temperatura       | Medir la temperatura del aire                                | Trabaja en °C con sus propios rangos                                     | Debe mostrar su medición en °C y decir si la temperatura está baja, adecuada o alta.                                                                                                |
| Sensor de humedad ambiental | Medir la humedad del aire                                    | Trabaja en % con sus propios rangos                                      | Debe mostrar su medición en % y decir si la humedad está baja, adecuada o alta.                                                                                                     |
| Sensor de humedad del suelo | Medir la humedad del suelo                                   | Trabaja en % con sus propios rangos                                      | Debe mostrar su medición en % y decir si la humedad está baja, adecuada o alta. Debe permitir saber si el suelo está seco para el riego.                                            |
| Sistema de riego            | Regar las plantas cuando haga falta                          | Si está activo o inactivo y el sensor de humedad del suelo que usa       | Debe poder activarse, desactivarse y decir su estado. Debe revisar lo que dice el sensor del suelo y activarse si la humedad está baja, o quedarse apagado si está adecuada o alta. |
| Invernadero                 | Juntar todos los elementos y revisar el invernadero completo | Los sensores instalados y el sistema de riego                            | Debe permitir agregar sensores, mostrar la medición e interpretación de cada sensor y pedirle al riego que revise si hace falta regar.                                              |



## 4. Características comunes y especialización

### Qué información tienen en común

Los tres sensores tienen un identificador, una ubicación, un estado y una medición.

### Qué comportamientos tienen en común

Todos pueden dar su medición, activarse, desactivarse, mostrar sus datos e interpretar lo que midieron.

### Qué cambia dependiendo del tipo de sensor

Lo que cambia es qué miden, en qué unidad y cómo interpretan el número:

Por eso el mismo número no significa lo mismo en todos. Un 30° es temperatura alta, humedad ambiental baja y humedad del suelo adecuada. Todos interpretan su medición, pero cada uno a su manera.

### ¿Existe un concepto general que represente a todos los sensores?

El Sensor. Ahí va todo lo que comparten: identificador, ubicación, estado y medición. Así eso se escribe una sola vez.

### ¿Qué elementos podrían ser especializaciones?

El sensor de temperatura, el de humedad ambiental y el de humedad del suelo. Los tres son sensores, pero cada uno tiene su unidad y su forma de interpretar.

Aunque los dos de humedad usan %, no conviene juntarlos en uno solo, porque sus rangos son diferentes y miden cosas distintas.

---

## 5. Relaciones entre objetos

### Relaciones ES UN

Un sensor de temperatura ES UN sensor.

Un sensor de humedad ambiental ES UN sensor.

Un sensor de humedad del suelo ES UN sensor.

Estas sí se podrían representar con herencia, porque los tres tienen todo lo de un sensor y nada más cambian cómo interpretan su medición.

### Relaciones TIENE / UTILIZA UN

El invernadero TIENE sensores.

El invernadero TIENE un sistema de riego.

El sistema de riego UTILIZA el sensor de humedad del suelo.

Estas no deben ser herencia. El invernadero no es un sensor ni un sistema de riego, solo los contiene. 

### Qué objetos colaboran y qué información necesitan

Sistema de riego con sensor de humedad del suelo.

Invernadero con los sensores.

Invernadero con el sistema de riego.

### Qué responsabilidades no deben duplicarse

Interpretar la medición le toca solo al sensor. El riego no debe volver a revisar si 22 % es bajo, se lo pregunta al sensor.

Los datos que comparten los sensores se guardan en el sensor general, no se repiten en cada tipo.

Activar o apagar el riego le toca solo al sistema de riego. El sensor mide, pero no prende el riego.

### ¿Por qué SistemaRiego no debería ser una subclase de Sensor?

Porque el sistema de riego no es un sensor, el sensor observa, el sistema de riego actúa.

El riego no tiene medición, ni unidad, ni rangos que interpretar. Si heredara de Sensor, se quedaría con cosas que no usa y se mezclarían dos trabajos diferentes.
