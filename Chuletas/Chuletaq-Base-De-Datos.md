# ✅ CHULETA – UD2: Paso de Diagrama ER a Modelo Relacional

---

## ✅ 1. Transformación de Entidades → Tablas
- Cada entidad del ER se convierte en una **tabla**. :contentReference[oaicite:0]{index=0}
- Las **filas** = instancias.
- Las **columnas** = atributos.
- Entidades **fuertes** → tablas independientes.
- Entidades **débiles** → su PK incluye la PK propagada de la entidad de la que dependen. :contentReference[oaicite:1]{index=1}

---

## ✅ 2. Atributos → Columnas
- Atributos **simples** se transforman directamente en columnas. :contentReference[oaicite:2]{index=2}

---

## ✅ 3. Clave Primaria (PK)
- Identificador único del ER → se convierte en **PK** en la tabla.  
- Propiedades:  
  - **Unicidad**: no se repite.  
  - **No nulidad**: no puede ser NULL. :contentReference[oaicite:3]{index=3}
- Importancia:  
  - Garantiza la integridad.  
  - Permite que otras tablas la referencien mediante FKs. :contentReference[oaicite:4]{index=4}

---

## ✅ 4. Clave Externa (FK) y Propagación de Clave
### ✅ Propagación PK → FK
- En relaciones **1:N**, la PK del lado "1" se **propaga** al lado "N" como **FK**.  
- La FK debe contener valores válidos de la PK.  
- Garantiza **integridad referencial**. :contentReference[oaicite:5]{index=5}

### ✅ Integridad referencial
- No puede haber valores en una FK que no existan en la PK referenciada.  
- Evita registros “huérfanos”. :contentReference[oaicite:6]{index=6}

---

## ✅ 5. Transformación de Relaciones

### ✅ Relaciones M:N (muchos a muchos)
- No se representan directamente.  
- Se crea **tabla intermedia** con:  
  - PK de ambas entidades como **FK**.  
  - PK compuesta = combinación de esas FKs.  
  - Los atributos de la relación se añaden aquí. :contentReference[oaicite:7]{index=7}

---

### ✅ Relaciones 1:N (uno a muchos)
- Se **propaga la PK** del lado 1 como **FK** en el lado N.  
- Opción menos común: tabla intermedia (si pueden aparecer atributos o evolución a M:N). :contentReference[oaicite:8]{index=8}

---

### ✅ Relaciones 1:1 (uno a uno)
Dos métodos:  
1. **Propagación de PK**:  
   - PK de una entidad → PK y FK en la otra.  
2. **Tablas separadas** con FKs entre sí (más separación por diseño). :contentReference[oaicite:9]{index=9}

---

## ✅ 6. Resumen rápido PK y FK

### ✅ PK
- Identifica de forma única.  
- No se repite.  
- No es NULL.  
- Viene del identificador único del ER.

### ✅ FK
- Columna que referencia a la PK de otra tabla.  
- Aparece al propagar la PK en 1:N.  
- Mantiene integridad referencial.

