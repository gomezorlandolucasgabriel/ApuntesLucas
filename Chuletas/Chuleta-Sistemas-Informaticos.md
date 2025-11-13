# Chuleta rápida — Unidad Didáctica 3: Bash

**Formato:** una hoja, sólo lo imprescindible. Úsala en el examen si tu profesor es indulgente. Si no, clona, memorizas y rezas.

---

## 1) Encabezado y ejecución

* Shebang: `#!/bin/bash`
* Hacer ejecutable: `chmod +x script.sh`
* Ejecutar: `./script.sh` o `bash script.sh`

---

## 2) Comentarios

* Línea: `# comentario`
* Comentario largo: varias líneas con `#` o `: '...'` (no habitual)

---

## 3) Variables

* Declarar: `var="valor"` (sin espacios alrededor de `=`)
* Usar: `echo $var` o con llaves `echo ${var}`
* Sensible a mayúsculas: `MI` ≠ `mi`
* Variables especiales:

  * `$0` nombre del script
  * `$1..$n` argumentos
  * `$#` número de args
  * `$?` exit status del último comando
  * `$$` PID del proceso
  * `$USER`, `$HOME`, `$PATH`

---

## 4) Operaciones aritméticas

* Enteros: `res=$((a + b))`
* Operadores: `+ - * / % **`
* Incremento: `((i++))` o `i=$((i+1))`
* Decimales: usa `bc` → `echo "scale=2; 3/2" | bc`

---

## 5) Condicionales

```bash
if [ condición ]; then
  comandos
elif [ otra ]; then
  comandos
else
  comandos
fi
```

* Importante: espacios dentro de `[ ]`.
* Comparadores numéricos: `-eq -ne -lt -le -gt -ge`
* Comparadores de cadenas: `=` `!=`  (usar `[[ ... ]]` para mayor seguridad)
* Test rápido: `[ -f archivo ]` (archivo existe, regular), `-d` (directorio), `-x` (ejecutable)

---

## 6) Bucles

* For (lista):

```bash
for x in a b c; do
  echo $x
done
```

* For (rango): `for i in {1..5}; do ...; done`
* While:

```bash
while [ condición ]; do
  comandos
done
```

* Break/continue funcionan igual que en otros lenguajes.

---

## 7) Arrays

* Declarar: `arr=("uno" "dos" "tres")`
* Acceso: `${arr[0]}`
* Todos: `${arr[@]}` o `${arr[*]}`
* Longitud: `${#arr[@]}`
* Añadir: `arr+=("nuevo")`
* Borrar: `unset arr[1]`

---

## 8) Entrada / Salida / Redirecciones

* Leer: `read var` o `read -p "Pregunta: " var`
* Stdout/err: `comando > out.txt`  `comando 2> err.txt`
* Append: `>>`
* Pipe: `cmd1 | cmd2`
* Heredoc:

```bash
cat <<EOF > archivo
texto...
EOF
```

---

## 9) Comandos útiles (resumen rápido)

* `grep PATTERN file` — buscar
* `sed 's/a/b/' file` — sustitución linea a linea
* `awk '{print $1}' file` — procesar columnas
* `cut -d',' -f1` — cortar por delimitador
* `sort`, `uniq -c`, `wc -l`
* `ps aux`, `kill PID`
* `chmod`, `chown`
* `test -z "$var"` (cadena vacía)

---

## 10) Buenas prácticas y trucos

* Siempre validar args: `if [ $# -lt 1 ]; then echo "uso: $0 arg"; exit 1; fi`
* Usar `set -e` para salir si falla un comando (útil en scripts robustos)
* `set -u` para error si usas variable no definida
* `set -o pipefail` para detectar fallos en tuberías
* Poner comillas alrededor de variables: `"$var"` para evitar word-splitting
* Evitar `for file in $(ls)`; usar `for file in *` o `while read -r`

---

## 11) Ejemplos compactos (copiar/pegar)

* Script saludo:

```bash
#!/bin/bash
nombre="$1"
[ -z "$nombre" ] && nombre="Mundo"
echo "Hola, $nombre"
```

* Contador con while:

```bash
i=1
while [ $i -le 5 ]; do
  echo "$i"
  ((i++))
done
```

* Recorrer archivos .txt y contar líneas:

```bash
for f in *.txt; do
  echo "$f: $(wc -l < "$f") líneas"
done
```

---

## 12) Errores comunes en examen (evítalos)

* Olvidar permisos `chmod +x`
* No dejar espacios en `[ $a -eq $b ]`
* No entrecomillar variables con espacios
* Confundir `=` (asignación) con `==` o `-eq`

---

Si quieres que lo deje más pequeño para imprimir en media hoja o que añada comandos específicos del profesor, no me lo pidas con indirectas: dime qué recortar.

## 13) Configuración rápida para Visual Studio Code

* Extensiones recomendadas:

  * ShellCheck: linting estático para scripts bash.
  * Bash IDE (o bash-language-server): autocompletado, símbolos y navegación.
  * Bash Syntax Highlighting: resaltado si no viene con tu tema.
  * EditorConfig (opcional): coherencia de formato.

* Abrir terminal integrado: `Ctrl+` `(o View → Terminal). Ejecuta`chmod +x script.sh`y luego`./script.sh`.

* Tarea para ejecutar el script (tasks.json):

```json
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Run current bash file",
      "type": "shell",
      "command": "bash",
      "args": ["${file}"],
      "group": "build",
      "presentation": { "echo": true, "reveal": "always" },
      "problemMatcher": []
    }
  ]
}
```

* Snippet útil (settings or snippets file) para crear rápidamente el shebang y plantilla:

```json
"Bash: Script template": {
  "prefix": "bs",
  "body": [
    "#!/bin/bash",
    "# ${1:Descripción}",
    "set -euo pipefail",
    "",
    "# Uso: $0 arg",
    ""
  ],
  "description": "Plantilla básica para scripts bash"
}
```

* Integración con ShellCheck: activa "shellcheck.run": "onType" o "onSave" en la configuración de usuario para ver advertencias en tiempo real.

* Depuración mínima: puedes usar `bash -x script.sh` para traza (equivalente a poner `set -x` en el script). Para sesiones interactivas con breakpoints, instala `bashdb` si quieres profundidad, pero suele bastar `-x`.

* Ajustes recomendados en `settings.json` (extracto):

```json
{
  "editor.tabSize": 2,
  "editor.formatOnSave": false,
  "shellcheck.run": "onSave",
  "files.insertFinalNewline": true
}
```

* Atajos rápidos:

  * Ejecutar tarea: `Ctrl+Shift+B` (si la etiquetas como "build").
  * Abrir terminal en la carpeta del archivo actual: botón derecho → "Open in Integrated Terminal".

*Fin de la chuleta.*
