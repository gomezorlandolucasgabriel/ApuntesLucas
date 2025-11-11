---
 ###**Enunciado del Problema: Diseño de la Base de datos para una Aerolínea**

Se requiere diseñar el modelo relacional para una base de datos que gestione las operaciones de una compañía aérea. A continuación se describen los requisitos.

**Entidades y sus características:**

- **Empleado:** Se almacena `ID_Empleado`, `DNI`, `Nombre`, `Apellido` y `Fecha_Contratacion`.
- **Jerarquía de Empleados:** Los empleados se especializan en **Pilotos** (con `Num_Licencia`, `Horas_Vuelo`) y **Mecánicos** (con `Certificacion_Tecnica`, `Especialidad`).
- **Avión:** Se almacena `Matricula`, `Modelo`, `Anio_Fabricacion` y `Capacidad_Pasajeros`.
- **Ruta:** Se almacena `Cod_Ruta`, `Aeropuerto_Origen`, `Aeropuerto_Destino` y `Distancia_km`.

**Relaciones y Cardinalidades (descripción detallada):**

1.  **Reparación de Aeronaves:** Un mecánico repara aviones. Un mecánico puede haber reparado cero o muchos aviones. Un avión puede no haber sido reparado nunca o haber sido reparado por muchos mecánicos. Cada reparación tiene una fecha y observaciones.
2.  **Asignación de Vuelos:** Un vuelo es una asignación ternaria que involucra a un piloto, un avión y una ruta. De cada asignación se registra la fecha y la hora.
---

### **Diagrama Entidad-Relación (con Cardinalidad (min, max))**

**RELACIONES**

- **Relación 1: REPARA**

  - **Tipo:** Binaria, Muchos a Muchos (M:N).
  - **Representación de Cardinalidad:**
    `[ MECANICO ] (0,N) ---< REPARA >--- (0,N) [ AVION ]`
  - **Lectura de la Cardinalidad:**
    - **(0,N) lado MECANICO:** Un Avión es reparado por un mínimo de **0** y un máximo de **N** (muchos) Mecánicos.
    - **(0,N) lado AVION:** Un Mecánico repara un mínimo de **0** y un máximo de **N** (muchos) Aviones.
  - **Atributos de la Relación:** `Fecha_Reparacion`, `Observaciones`.

- **Relación 2: REALIZA_VUELO**
  - **Tipo:** Ternaria, Muchos a Muchos a Muchos (M:N:P).
  - **Representación de Cardinalidad:** Se representa globalmente como M:N:P, ya que las combinaciones pueden repetirse y cada entidad puede participar en múltiples combinaciones.
  - **Atributos de la Relación:** `Fecha_Vuelo`, `Hora_Salida`.

---

### **Guía de Transformación de Cardinalidades a Tablas**

Esta es la sección teórica que explica CÓMO se convierte cada tipo de relación a tablas.

| Tipo de Relación (Cardinalidad)                                              | Regla de Transformación                                                                                                                                                                                                                                                                    | Ejemplo de Esquema Relacional                                                                                                                                   |
| :--------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Uno a Uno (1:1)**<br>Ej: `EMPLEADO(1,1)--(Dirige)--(0,1)DEPARTAMENTO`      | **Opción A (Recomendada): Propagación de Clave.** La PK de una de las tablas (usualmente la de participación opcional, en este caso `EMPLEADO`) se añade a la otra tabla como FK con una restricción de **unicidad (`UNIQUE`)**.                                                           | `DEPARTAMENTO`(`ID_Dept` (PK), `Nombre`) <br> `EMPLEADO`(`ID_Emp` (PK), ..., `ID_Dept_que_dirige` (FK, UNIQUE))                                                 |
| **Uno a Muchos (1:N)**<br>Ej: `DEPARTAMENTO(1,1)--(Contiene)--(0,N)EMPLEADO` | **Regla de Oro: Propagar la PK del lado "1" al lado "N".** La PK de la tabla del lado "1" (`DEPARTAMENTO`) se añade como una columna FK en la tabla del lado "N" (`EMPLEADO`).                                                                                                             | `DEPARTAMENTO`(`ID_Dept` (PK), `Nombre`) <br> `EMPLEADO`(`ID_Emp` (PK), ..., `ID_Departamento` (FK))                                                            |
| **Muchos a Muchos (M:N)**<br>Ej: `MECANICO(0,N)--(Repara)--(0,N)AVION`       | **Siempre se crea una nueva tabla intermedia (tabla de unión).** Esta nueva tabla contendrá: <br> 1. La PK de la primera tabla como FK. <br> 2. La PK de la segunda tabla como FK.<br> 3. Los atributos de la relación.<br> La PK de la nueva tabla suele ser la combinación de ambas FKs. | `MECANICO`(`ID_Mec` (PK), ...)<br>`AVION`(`Matricula` (PK), ...)<br>`REPARACIONES`(`ID_Mec` (PK,FK), `Matricula` (PK,FK), `Fecha`, `Obs`)                       |
| **Jerarquía/ISA (Subtipos)**<br>Ej: `EMPLEADO` es superclase de `PILOTO`.    | **Crear una tabla para la superclase y una tabla para cada subclase.** La PK de la superclase (`EMPLEADO`) se añade a cada subclase, donde actúa a la vez como **PK** de esa tabla y como **FK** que la referencia a la tabla padre.                                                       | `EMPLEADO`(`ID_Emp` (PK), ...)<br>`PILOTO`(`ID_Emp_Piloto` (PK,FK), `Licencia`, `Horas`)                                                                        |
| **Relación Ternaria (M:N:P)**<br>Ej: Vuelo entre `PILOTO`, `AVION` y `RUTA`  | **Funciona igual que una M:N: se crea una nueva tabla intermedia.** Contendrá las PKs de las **tres** entidades participantes como FKs, además de los atributos propios de la relación. La PK será la combinación de las FKs (y a veces algún atributo más).                               | `PILOTO`(`ID_Pil` (PK), ...)<br>`AVION`(`Mat` (PK), ...)<br>`RUTA`(`Cod` (PK), ...)<br>`VUELO`(`ID_Pil` (PK,FK), `Mat` (PK,FK), `Cod` (PK,FK), `Fecha`, `Hora`) |

---

### **Resultado Final: El Esquema Relacional Completo**

**Tabla `EMPLEADO`**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`ID_Empleado`** | **Sí** | No | |
| `DNI` | No | No | |
| `Nombre` | No | No | |
| `Apellido` | No | No | |
| `Fecha_Contratacion`| No | No | |

**Tabla `PILOTO`**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`ID_Empleado_Piloto`**| **Sí** | **Sí** | `EMPLEADO(ID_Empleado)` |
| `Num_Licencia` | No | No | |
| `Horas_Vuelo` | No | No | |

**Tabla `MECANICO`**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`ID_Empleado_Mecanico`**| **Sí** | **Sí**| `EMPLEADO(ID_Empleado)` |
| `Certificacion_Tecnica`| No | No | |
| `Especialidad` | No | No | |

**Tabla `AVION`**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`Matricula`** | **Sí** | No | |
| `Modelo` | No | No | |
| `Anio_Fabricacion` | No | No | |
| `Capacidad_Pasajeros`| No | No | |

**Tabla `RUTA`**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`Cod_Ruta`** | **Sí** | No | |
| `Aeropuerto_Origen`| No | No | |
| `Aeropuerto_Destino`| No | No | |
| `Distancia_km` | No | No | |

**Tabla `HISTORIAL_REPARACIONES` (Intermedia de M:N binaria)**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`ID_Mecanico`** | **Sí** | **Sí** | `MECANICO(ID_Empleado_Mecanico)`|
| **`Matricula_Avion`** | **Sí** | **Sí** | `AVION(Matricula)` |
| **`Fecha_Reparacion`** | **Sí** | No | |
| `Observaciones` | No | No | |

**Tabla `ASIGNACION_VUELO` (Intermedia de M:N:P ternaria)**
| Columna | PK | FK | Referencia |
| :--- | :-:| :-:|:---|
| **`ID_Piloto`** | **Sí** | **Sí** | `PILOTO(ID_Empleado_Piloto)` |
| **`Matricula_Avion`**| **Sí** | **Sí** | `AVION(Matricula)` |
| **`Cod_Ruta`** | **Sí** | **Sí** | `RUTA(Cod_Ruta)` |
| **`Fecha_Vuelo`** | **Sí** | No | |
| `Hora_Salida` | No | No | |

Resultado Final: El Esquema Relacional Completo
(Nota: Las claves primarias están <u>subrayadas</u>)
EMPLEADO (<u>ID_Empleado</u>, DNI, Nombre, Apellido, Fecha_Contratacion)

PILOTO (<u>ID_Empleado_Piloto</u> (FK a EMPLEADO), Num_Licencia, Horas_Vuelo)

MECANICO (<u>ID_Empleado_Mecanico</u> (FK a EMPLEADO), Certificacion_Tecnica, Especialidad)

AVION (<u>Matricula</u>, Modelo, Anio_Fabricacion, Capacidad_Pasajeros)

RUTA (<u>Cod_Ruta</u>, Aeropuerto_Origen, Aeropuerto_Destino, Distancia_km)

HISTORIAL_REPARACIONES (<u>ID_Mecanico</u> (FK a MECANICO), <u>Matricula_Avion</u> (FK a AVION), <u>Fecha_Reparacion</u>, Observaciones)

ASIGNACION_VUELO (<u>ID_Piloto</u> (FK a PILOTO), <u>Matricula_Avion</u> (FK a AVION), <u>Cod_Ruta</u> (FK a RUTA), <u>Fecha_Vuelo</u>, Hora_Salida)

---

### **Guía Completa de Transformación de Cardinalidades a Tablas**

El objetivo al transformar un Diagrama ER en tablas es representar las **relaciones** y sus **reglas (cardinalidades)** usando los mecanismos del modelo relacional: **Claves Primarias (PK)** y **Claves Externas (FK)**.

A continuación se detallan todos los casos posibles.

#### **1. Relación Uno a Muchos (1:N)**

Esta es la relación más común y la base para entender las demás.

- **Descripción:** Un registro de la Tabla A se relaciona con cero, uno o muchos registros de la Tabla B. Pero un registro de la Tabla B solo se puede relacionar con **un único** registro de la Tabla A.
- **Ejemplo ER:** `DEPARTAMENTO (1,1) ---< Tiene >--- (0,N) EMPLEADO`
  - _Un Departamento tiene muchos Empleados. Un Empleado pertenece a un solo Departamento._
- **Regla de Transformación:**
  1.  Se crea una tabla para cada entidad (`DEPARTAMENTO`, `EMPLEADO`).
  2.  La **Clave Primaria (PK)** de la entidad en el lado **"1"** (DEPARTAMENTO) se añade como una nueva columna en la tabla de la entidad del lado **"N"** (EMPLEADO).
  3.  Esta nueva columna en la tabla `EMPLEADO` se convierte en una **Clave Externa (FK)** que referencia a la PK de `DEPARTAMENTO`.
- **Esquema Relacional Resultante:**
  - **DEPARTAMENTO** (<u>ID_Departamento</u>, Nombre)
  - **EMPLEADO** (<u>ID_Empleado</u>, Nombre, Apellido, ID_Departamento (FK a DEPARTAMENTO))

---

#### **2. Relación Muchos a Muchos (M:N)**

Esta relación no se puede representar directamente en el modelo relacional.

- **Descripción:** Un registro de la Tabla A se puede relacionar con muchos registros de la Tabla B, y viceversa.
- **Ejemplo ER:** `ALUMNO (0,N) ---< Se Matricula >--- (0,N) ASIGNATURA`
  - _Un Alumno se matricula en muchas Asignaturas. Una Asignatura tiene muchos Alumnos._
- **Regla de Transformación:**
  1.  Se crea una tabla para cada entidad (`ALUMNO`, `ASIGNATURA`).
  2.  **Se crea SIEMPRE una nueva tabla intermedia** (también llamada tabla de unión o tabla de relación). Por ejemplo: `MATRICULA`.
  3.  Esta nueva tabla contendrá, como mínimo, dos columnas:
      - La PK de la primera tabla (`ALUMNO`), que actuará como FK.
      - La PK de la segunda tabla (`ASIGNATURA`), que también actuará como FK.
  4.  La **Clave Primaria (PK) de la tabla intermedia** es, por lo general, la **combinación de las dos FKs**.
  5.  Si la relación tiene atributos propios (ej: `Anio_Academico`), estos se añaden como columnas a la tabla intermedia.
- **Esquema Relacional Resultante:**
  - **ALUMNO** (<u>Num_Expediente</u>, Nombre, Apellido)
  - **ASIGNATURA** (<u>Cod_Asignatura</u>, Nombre, Creditos)
  - **MATRICULA** (<u>Num_Expediente</u> (FK a ALUMNO), <u>Cod_Asignatura</u> (FK a ASIGNATURA), Anio_Academico)

---

#### **3. Relación Uno a Uno (1:1)**

Aunque es menos común, tiene dos formas principales de resolverse.

- **Descripción:** Un registro de la Tabla A se relaciona con, como máximo, un registro de la Tabla B, y viceversa.
- **Ejemplo ER:** `PROFESOR (0,1) ---< Dirige >--- (1,1) DEPARTAMENTO`
  - _Un Departamento es dirigido por un único Profesor. Un Profesor puede dirigir, como máximo, un Departamento._
- **Regla de Transformación (Opción 1 - Recomendada):**
  1.  Se elige una de las dos tablas para añadir la clave externa. La elección suele basarse en la participación: se propaga la PK de la entidad con participación opcional (PROFESOR) a la tabla de la entidad con participación obligatoria (DEPARTAMENTO).
  2.  La columna FK añadida debe tener una restricción de **`UNIQUE` (única)** para garantizar que no se pueda repetir, forzando así la cardinalidad "1" en ese lado.
- **Esquema Relacional Resultante:**
  - **PROFESOR** (<u>ID_Profesor</u>, Nombre, Apellido)
  - **DEPARTAMENTO** (<u>ID_Departamento</u>, Nombre, ID_Profesor_Director (FK a PROFESOR, UNIQUE))

---

#### **4. Relaciones Especiales**

##### **a) Relación Recursiva (o Unaria)**

Una entidad se relaciona consigo misma. Se aplican las mismas reglas de antes.

- **Caso 1: Recursiva 1:N**

  - **Ejemplo:** `EMPLEADO (0,1) ---< Supervisa >--- (0,N) EMPLEADO`
    - _Un empleado supervisa a muchos. Un empleado es supervisado por, como máximo, uno._
  - **Regla:** La tabla se referencia a sí misma. Se añade una nueva columna (ej: `ID_Supervisor`) a la propia tabla `EMPLEADO`, y esta columna es una FK que apunta a la PK de la misma tabla. Esta FK **debe permitir valores nulos** para el empleado raíz (ej: el CEO).
  - **Esquema Resultante:**
    - **EMPLEADO** (<u>ID_Empleado</u>, Nombre, Apellido, ID_Supervisor (FK a EMPLEADO))

- **Caso 2: Recursiva M:N**
  - **Ejemplo:** `PRODUCTO (0,N) ---< Se compone de >--- (0,N) PRODUCTO`
    - _Un producto está compuesto por muchas piezas (que también son productos). Una pieza puede formar parte de muchos productos._
  - **Regla:** Igual que una M:N normal, **se crea una tabla intermedia**. La peculiaridad es que esta tabla tendrá **dos columnas FK, ambas apuntando a la misma tabla `PRODUCTO`**. Se usan alias para distinguirlas.
  - **Esquema Resultante:**
    - **PRODUCTO** (<u>ID_Producto</u>, Nombre, Descripcion)
    - **COMPOSICION** (<u>ID_Producto_Contenedor</u> (FK a PRODUCTO), <u>ID_Producto_Componente</u> (FK a PRODUCTO), Cantidad)

##### **b) Entidad Débil**

- **Ejemplo:** Un `EDIFICIO` (fuerte) tiene `PISOS` (débil). Un piso se identifica por su `Numero_Piso` _dentro de un edificio_.
- **Regla:** La **PK de la entidad débil siempre es compuesta**: se forma por la PK de la entidad fuerte (que se añade como FK) más el identificador parcial de la entidad débil.
- **Esquema Resultante:**
  - **EDIFICIO** (<u>Cod_Edificio</u>, Direccion)
  - **PISO** (<u>Cod_Edificio</u> (FK a EDIFICIO), <u>Numero_Piso</u>, Num_Oficinas)

##### **c) Jerarquía (ISA)**

- **Ejemplo:** `VEHICULO` es superclase de `COCHE` y `MOTO`.
- **Regla:** Se crea una tabla para la superclase (`VEHICULO`) y una para cada subclase. La PK de la superclase se añade a las tablas de las subclases, donde actúa como **PK y FK al mismo tiempo**.
- **Esquema Resultante:**
  - **VEHICULO** (<u>ID_Vehiculo</u>, Matricula, Marca)
  - **COCHE** (<u>ID_Vehiculo</u> (FK a VEHICULO), Num_Puertas, Tipo_Combustible)
  - **MOTO** (<u>ID_Vehiculo</u> (FK a VEHICULO), Cilindrada)
