### 1.1

#Aqui es para conectarme a esa IP, en este caso es alumnoT,te dira si confias en el equipo o no (en el caso de que sea la primera vez) y luego te pediría la contraseña 
ssh alumnoT@192.168.1.179
# Ahora creamos la carpeta con mi nombre y apellidos
mkdir -p Escritorio/LUISALBERTOSANCHEZREGUERO

### 1.2

# esto lo que hace es copiar el repositorio local dentro de la carpeta creada en el servidor del examen
scp -r ./si-pt4-sanchezregueroluisalberto alumnoT@192.168.1.179:/home/alumnoT/Escritorio/LUISALBERTOSANCHEZREGUERO/