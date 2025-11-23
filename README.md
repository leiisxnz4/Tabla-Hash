# Tabla-Hash

¿Cómo funciona el algoritmo de tabla hash usado en este programa?

Este programa utiliza una tabla hash para organizar nombres. Una tabla hash permite ubicar datos rápidamente calculando una posición para cada elemento mediante una función hash. En este caso, la posición se obtiene sumando los valores ASCII de las letras del nombre y usando esa suma para determinar en qué parte de la tabla se va a guardar.

1. Cálculo del hash

Para cada nombre, el programa recorre cada letra y suma su código ASCII, que es simplemente el número que la computadora asigna internamente a cada carácter. Java obtiene este número automáticamente cuando un char se usa en una operación matemática, así que no es necesario conocer o memorizar esos valores; el lenguaje ya los convierte por sí mismo.

Después de obtener la suma total, se aplica el operador módulo (%) con el tamaño de la tabla para obtener el índice final donde se insertará el nombre.

2. Construcción de la tabla hash

Una vez que se leen todos los nombres:

Se crea una tabla hash con un tamaño del doble del número de nombres, para que tenga suficiente espacio.

Cada posición de la tabla contiene una lista para manejar colisiones.

Cada nombre se inserta en la lista que corresponde al índice hash calculado.

3. Recolección y ordenamiento

Cuando todos los nombres ya se encuentran dentro de la tabla hash:

Se recorren todas las posiciones de la tabla.

Se extraen los nombres y se colocan en una sola lista.

Esa lista se ordena alfabéticamente para generar la salida final.

- En conclusión el proceso:

Lee los nombres del archivo.

Convierte cada letra a su valor ASCII (Java lo hace automáticamente).

Suma esos valores y aplica el módulo para obtener el índice.

Inserta en la tabla hash.

Extrae todos los elementos.

Los ordena y guardar en el archivo de salida. 

- Ventaja principal

El uso de una tabla hash permite distribuir los nombres desde el principio, evitando que todos se acumulen en un solo lugar. Esto hace que la inserción sea más rápida y ordenada, incluso cuando hay muchos datos. Además, aunque al final se ordenan alfabéticamente, la tabla hash ayuda a estructurar la información de forma más eficiente durante el proceso.