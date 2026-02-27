# Función para validar que se pasan los argumentos correctos (EJERCICIO 0 )
validar_argumentos() {
    if [ $# -lt $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}


# EJERCICIO 1
calcular_maximo() {
validar_argumentos 2 "$@" || return 1

    maximo=$1

    for numero in "$@"; do
        if [ "$numero" -gt "$maximo" ]; then
            maximo=$numero
        fi
    done
    echo "El máximo es: $maximo"
}


# EJERCICIO 2

archivos_max_peso() {
validar_argumentos 1 "$@" || return 1

    ruta="$1"
    max=$(ls -lS "$ruta" | head -2 | tail -1 | awk '{print $5}')
    find "$ruta" -type f -size "${max}c"
    
}

validar_argumentos() {
    if [ $# -lt $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos o mas"
        return 1
    else
        return 0
    fi
}