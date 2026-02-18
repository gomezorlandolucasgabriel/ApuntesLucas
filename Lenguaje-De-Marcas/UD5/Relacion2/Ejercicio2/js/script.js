//1. Al cargar la página, cambia la `src` de la imagen para mostrar `"imagen2.jpg"`.

//Pista: Usa `document.getElementById("imagen").src = "nueva_imagen.jpg"`.
 

const imagen = document.querySelector("#imagen")
imagen.setAttribute("src", "imagen1.jpg")
