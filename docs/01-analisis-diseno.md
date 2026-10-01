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