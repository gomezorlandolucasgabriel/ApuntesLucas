

# 🟦 1. ARRAYS (Arreglos)

## 👉 ¿Qué es un array?

Un array es una lista ordenada de elementos.
Sirve para guardar varios valores en una sola variable.

## 📌 Piensa en una fila de taquillas numeradas:

Taquilla 0
Taquilla 1
Taquilla 2
...
Cada taquilla es un índice.
Cada cosa que guardas dentro es un elemento.

### Ejemplo:

```bash

let frutas = ["manzana", "banana", "naranja"]

```

## Indices:

frutas[0] → "manzana"

frutas[1] → "banana"

frutas[2] → "naranja"

### 📌 Los arrays SIEMPRE empiezan en índice 0 ⇒ EXAMEN SEGURO

## 👉 Cómo modificar un array
```bash

frutas[1] = "pera" // cambia banana por pera

```

## 👉 Añadir elementos

```bash

frutas.push("mango")    // añade al final
frutas.unshift("fresa") // añade al inicio

```

## 👉 Eliminar elementos

```bash

frutas.pop()   // elimina el último
frutas.shift() // elimina el primero

```

## 👉 Cosas importantes para el examen:

 ### 1. Saber acceder al último elemento:

```bash

frutas[frutas.length - 1]

```

### 2. length es la cantidad de elementos:

```bash

frutas.length

```

# 🟩 2. BUCLES

Un bucle sirve para repetir código muchas veces sin tener que escribirlo a mano.
Piensa que un bucle es como:
👉 “Haz esto hasta que te diga que pares”.

## 🟦 2.1 Bucle FOR

Es el bucle más típico para recorrer un array.

### Estructura:

```bash

for (inicialización ; condición ; actualización) {

}

```

### Traducción:

**inicialización → desde dónde empieza**

**condición → hasta cuándo sigue**

**actualización → cómo avanza**


## 👉 Ejemplo clásico:

```bash

for (let i = 0; i < 5; i++) {
    console.log(i)
}

```

### Explicación:
**Empieza en 0**
**Llegará hasta 4**
**Va aumentando de 1 en 1**



## 👉 Recorrer un array con for (IMPORTANTE PARA EXAMEN)

```bash

let numeros = [ 10, 20, 30]

for (let i = 0; i < numeros.length; i++) {
    console.log(numeros[i])
}

```

## 🟥 2.2 Bucle WHILE

Sirve para repetir algo mientras se cumpla una condición.

### Estructura:

```bash

while (condición) {
    // repetir
}

```


### Ejemplo: 

```bash 

let i = 0

while (i < 5) {
    console.log(i)
    i++      // si NO pones esto → BUCLE INFINITO
}

```

### **📌 Muy importante: el while necesita un contador que avance, o no termina nunca.**

## 🟪 2.3 Bucle FOR…OF

Este es el más fácil para recorrer arrays.

### Ejemplo:

```bash

let frutas = ["pera", "manzana", "uva"]

for (let fruta of frutas) {
    console.log(fruta)
}

```
👉 Va elemento por elemento sin usar índices.


# 🟦 3. MATRICES (Arrays de arrays)

👉 ¿Qué es una matriz?

Es un array dentro de otro array. Piensa en una tabla, con filas y columnas.

### Ejemplo:

```bash

let matriz = [
  [1, 2, 3],   // fila 0
  [4, 5, 6],   // fila 1
  [7, 8, 9]    // fila 2
]

```

## 👉 Acceder a una posición

### Necesitas dos índices:

```bash

matriz[fila][columna]

```

### Ejemplos:

```bash

matriz[0][1]  // 2
matriz[2][2]  // 9

```

## 👉 Modificar un valor

```bash

matriz[1][0] = 99

```

## 👉 Recorrer una matriz (muy típico de examen) 

```bash 

for (let fila = 0; fila < matriz.length; fila++) {
    for (let columna = 0; columna < matriz[fila].length; columna++) {
        console.log(matriz[fila][columna])
    }
}

```

# 🎓 RESUMEN PARA APROBAR

✔ ARRAY: lista con índices

✔ LENGTH: cantidad

✔ FOR: recorrer lista

✔ WHILE: repetir mientras se cumpla

✔ FOR...OF: recorrer sin índices

✔ MATRIZ: array dentro de array

✔ ACCESO MATRIZ: matriz[fila][columna]
