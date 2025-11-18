# 1) ¿Qué es una función? — idea básica

### Paso 1: 

Piensa en la función como una receta.

### Paso 2: 

Le pones un nombre (qué hace).

### Paso 3: 

Opcional: le das ingredientes (parámetros).

### Paso 4: 

La receta hace algo con esos ingredientes.

### Paso 5: 

Devuelve el plato final con return (si hace falta).

## Ejemplo completo:

```bash 

function sumar(a, b) {
  return a + b
}

```
### Desglose línea por línea:

**1- function**: palabra clave — defines una función.

**2- sumar**: nombre; debería describir lo que hace.

**3- (a, b)**: parámetros; variables locales que la función usa.

**4- { ... }**: cuerpo de la función: instrucciones.

**5- return a + b**: devuelve la suma. La ejecución de la función termina aquí.

## Llamar / usar la función:

```bash

let r = sumar(5, 3) // r ahora vale 8

```

### Paso a paso durante la llamada:

1- Se crea un contexto local donde a = 5, b = 3.

2- Se evalúa a + b → 8.

3- return devuelve 8 al llamador.

4- r recibe 8.


# 2) Funciones sin parámetros
   
```bash

   function saludar() {
  return "¡Hola!"
}

```

## Explicación:

**No necesita datos externos.**

**Si llamas saludar(), siempre devuelve el mismo string.**

# 3) Variables dentro de la función vs fuera

- Variables dentro de la función son locales: no existen fuera.

- Variables fuera (globales) sí existen en todo el programa, pero usarlas dentro de funciones es mala práctica.

## Ejemplo:

```bash 

let x = 10

function prueba() {
  let x = 5
  return x
}

prueba() // devuelve 5
console.log(x) // 10



```


## Paso a paso:

1- let x = 10 crea variable global.

2- Dentro de prueba(), let x = 5 crea otra x local.

3- return x devuelve la x local (5).

4- La x global permanece 10.

# 4) Single Exit Rule (SER) — regla, por qué y cómo aplicarla

### Idea: una función debe tener un único return al final.

**¿Por qué? Mantiene el flujo claro, evita salidas dispersas, facilita depuración.**

### Ejemplo malo (múltiples returns):

```bash

function estado(edad) {
  if (edad < 18) return "Menor"
  if (edad < 65) return "Adulto"
  return "Senior"
}

```

**Problema** : hay varios puntos donde la función termina. Si la función crece, el seguimiento es un lío.

### Ejemplo bueno (SER):

```bash

function estado(edad) {
  let resultado
  if (edad < 18) {
    resultado = "Menor"
  } else if (edad < 65) {
    resultado = "Adulto"
  } else {
    resultado = "Senior"
  }
  return resultado
}

```
### Paso a paso con SER:

1- Inicializas variable resultado.

2- Evalúas condiciones y asignas resultado según el caso.

3- Al final, un único return resultado.

**Consejo práctico: SER es útil especialmente cuando necesitas limpiar recursos o registrar información antes de salir.**

# 5) Math.random() — concepto básico

- Math.random() devuelve un número decimal pseudoaleatorio r tal que 0 <= r < 1.

- Nunca devuelve 1. Sí puede devolver exactamente 0 (aunque raro).

## Ejemplo:

```bash

let r = Math.random()

```

### Paso a paso mental:

1- Llamas a la función, el motor genera algún decimal 0.0xxx… hasta 0.9999…

2- Lo devolvió — úsalo.

# 6) Convertir Math.random() a enteros y rangos — explicación paso a paso

## 6.A) Entero entre 0 y max (incluido)

### Fórmula:

```bash 

Math.floor(Math.random() * (max + 1))


```

#### Por qué funciona (desglose):

1- Math.random() produce r en [0, 1).

2- Multiplicando por (max + 1) obtienes r * (max + 1) en [0, max+1).

- Ej: si max = 10, resultado en [0, 11).

3- Math.floor(...) redondea hacia abajo a entero; posibles valores: 0,1,...,max.

4- Por eso incluye max y mantiene 0 posible.

## Ejemplo:

- max = 3. Math.random()*4 genera entre 0 y 4 (no incluye 4). Math.floor da 0,1,2 o 3.

**Pitfall típico: si pones Math.random() * max sin +1, nunca podrás obtener max.**

## 6.B) Entero entre 1 y max (incluido)

### Fórmula:

```bash

Math.floor(Math.random() * max) + 1

```

### Desglose:

1- Math.random() * max da [0, max).

2- Math.floor produce 0..max-1.

3- Sumando 1 obtienes 1..max.

- Ejemplo: max = 10 → valores posibles: 1..10.

## 6.C) Entero entre min y max (ambos incluidos)

### Fórmula:

```bash

Math.floor(Math.random() * (max - min + 1)) + min

```


### Por qué:

1- Tamaño del rango = max - min + 1 (número de enteros que hay en el intervalo inclusive).

2- Math.random() * (max - min + 1) genera decimal en [0, rango).

3- Math.floor da 0..rango-1.

4- + min desplaza el rango a min..max.

### Ejemplo concreto:

- min = 5, max = 8. max - min + 1 = 4.

- Math.random() * 4 → decimal en [0,4). Math.floor → 0,1,2,3. +5 → 5,6,7,8.

### Errores comunes con ejemplos:

- Olvidar el +1 → max nunca aparece.

- Usar Math.round(...) en lugar de Math.floor(...) → distribución sesgada (por ejemplo 0.49 redondea a 0, 0.51 a 1) y bordes raros.

- Confundir min y max — siempre asegúrate max >= min. Si no, intercambia o lanza error.

# 7) Ejercicios mentales resueltos paso a paso (útiles para el examen)

1- Quieres un número entre 0 y 10 inclusive.

- Usa: Math.floor(Math.random() * 11)

- Razonamiento: max = 10 → max+1 = 11 → random*11 → floor → 0..10.

2- Quieres un número entre 1 y 6 (como un dado).

- Usa: Math.floor(Math.random() * 6) + 1

- Razonamiento: random*6 → floor 0..5 → +1 → 1..6.

3- Quieres un número entre -3 y 3.

- min = -3, max = 3 → max-min+1 = 7

- Fórmula: Math.floor(Math.random() * 7) - 3

- Nota: +min con min negativo equivale a restar.

# 8) Ejemplos con funciones reales que combinan todo

## Función: entero aleatorio entre min y max

```bash

function randInt(min, max) {
  // seguridad básica: si min > max, intercambia
  if (min > max) {
    let tmp = min
    min = max
    max = tmp
  }
  return Math.floor(Math.random() * (max - min + 1)) + min
}

```


### Paso a paso:

1- Comprueba y corrige orden de min/max.

2- Calcula el tamaño del rango.

3- Genera decimal aleatorio y lo transforma a entero en el rango.

4- Devuelve el resultado.

### Función: elegir elemento aleatorio de un array

```bash

function elegirAleatorio(arr) {
  let idx = Math.floor(Math.random() * arr.length)
  return arr[idx]
}

```

### Paso a paso:

1- arr.length = número de elementos.

2- Math.random() * arr.length produce decimal en [0, length).

3- Math.floor produce índice entero válido 0..length-1.

4- Devuelve arr[idx].

### Error común: usar +1 aquí (causa índice fuera de rango).

# 9) Buenas prácticas y recomendaciones para el examen (puntos rápidos)

- Si te piden "entre A y B incluido", recuerda +1 en la longitud del rango.

- Para SER: incluso si la función es corta, si puedes dejar un solo return al final hazlo. Algunos profes lo piden explícito.

- Evita Math.round() para rangos enteros uniformes. Math.floor() + escalado es la forma estándar.

- Ten cuidado con 0 y 1 en Math.random() — 0 puede ocurrir, 1 no.

- Cuando uses min negativo, la fórmula sigue valiendo. Comprende la aritmética, no la memorices ciegamente.

# 10) Chuleta ultra-resumida (copiar y pegar)

```bash


// Declarar función
function nombre(param1, param2) { return resultado }

// SER (un solo return)
function ejemplo(x) {
  let r
  if (x>0) r="Pos"
  else if (x<0) r="Neg"
  else r="Cero"
  return r
}

// Math.random basics
Math.random()                  // decimal en [0,1)

// Entero 0..max
Math.floor(Math.random() * (max + 1))

// Entero 1..max
Math.floor(Math.random() * max) + 1

// Entero min..max
Math.floor(Math.random() * (max - min + 1)) + min

```