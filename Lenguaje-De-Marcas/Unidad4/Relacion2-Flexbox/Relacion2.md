# Relacion 2: Ejercicios Prácticos: Modelo de Caja (Box Model) y Diseño con Flexbox

## 4. Modelo de Caja (Box Model)

### Ejercicio 1: Calculando el tamaño total de una caja
1. Crea un `div` con la clase `caja`.
2. Aplica las siguientes propiedades:
   - `width`: 250px
   - `height`: 150px
   - `padding`: 15px
   - `border`: 5px solid red
   - `margin`: 20px

### Ejercicio 2: Diferencia entre `padding` y `margin`
1. Crea dos `div` con las clases `caja-1` y `caja-2`.
2. Aplica las siguientes propiedades:
   - Para `caja-1`: 
     - `padding`: 30px
     - `background-color`: lightblue
   - Para `caja-2`: 
     - `margin`: 30px
     - `background-color`: lightgreen

### Ejercicio 3: Personalizando bordes
1. Crea un `div` con la clase `borde-personalizado`.
2. Aplica un borde utilizando propiedades individuales:
   - `border-top`: 10px solid blue
   - `border-right`: 5px dashed red
   - `border-bottom`: 8px dotted green
   - `border-left`: 3px double black
3. Ajusta el `padding` a 20px y observa el efecto.


### Ejercicio 4: Tamaño adaptable con `em` y `rem`
Crea un `div` con la clase `caja-em-rem` que contenga un encabezado (`h1`) y un párrafo (`p`). Establece un tamaño de fuente base de 16px en el contenedor y aplica un `padding` de 2em. Configura el encabezado para que tenga un tamaño de fuente de 2rem y el párrafo para que tenga un tamaño de fuente de 1.5em. Luego, cambia el tamaño de fuente base del contenedor a 20px y observa cómo cambian los tamaños relativos.

---

### Ejercicio 5: Diseño fluido con `vw` y `vh`
Crea un `div` con la clase `caja-fluid`. Configura su ancho en 50% del ancho de la ventana del navegador (`50vw`) y su altura en 30% del alto de la ventana (`30vh`). Dale un color de fondo coral claro y centra el `div` en la ventana usando márgenes automáticos. Añade un texto dentro del `div` y centra este contenido utilizando las propiedades de flexbox: `display: flex`, junto con `justify-content: center` y `align-items: center`. Observa cómo varían las dimensiones al redimensionar la ventana del navegador.
---

## 5. Diseño con Flexbox

### Ejercicio 1: Alineación con `justify-content`
1. Crea un contenedor con tres `div` hijos.
2. Aplica `display: flex` al contenedor.
3. Configura las siguientes alineaciones en distintos momentos:
   - `justify-content: flex-start`
   - `justify-content: center`
   - `justify-content: space-between`
   - `justify-content: space-around`
4. Observa y documenta cómo cambian las posiciones de los elementos.

### Ejercicio 2: Cambiando la dirección del flujo
1. Crea un contenedor con tres `div` hijos de diferentes colores.
2. Aplica `display: flex` y prueba las siguientes configuraciones de `flex-direction`:
   - `row`
   - `row-reverse`
   - `column`
   - `column-reverse`
3. Describe cómo cambia la disposición de los elementos.

### Ejercicio 3: Flexibilidad en crecimiento
1. Crea un contenedor con tres `div` hijos con las clases `item1`, `item2` y `item3`.
2. Asigna los siguientes valores de `flex-grow`:
   - `item1`: 1
   - `item2`: 2
   - `item3`: 1
3. Observa cómo los elementos ocupan el espacio disponible.

### Ejercicio 4: Uso combinado de `flex`
1. Crea un contenedor con cuatro `div` hijos.
2. Asigna diferentes configuraciones de `flex` a cada hijo:
   - `flex: 1 1 auto`
   - `flex: 2 1 150px`
   - `flex: 1 0 100px`
   - `flex: 0 1 200px`
3. Explica el comportamiento de cada configuración en relación con el espacio disponible.
s