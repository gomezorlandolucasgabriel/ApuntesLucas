//1. Al cargar la página:
//- Cambia el color de fondo de las noticias impares a `lightgray`.
//- Cambia el color del texto de las noticias pares a `blue`.
//- Añade un emoji 🔥 al inicio de cada noticia.



let noticias = document.querySelectorAll(".noticia");

for (let i = 0; i < noticias.length; i++) {
  noticias[i].textContent = "🔥" + noticias[i].textContent;
  if (i % 2) {
    noticias[i].style.backgroundcolor = "lightgray";
  } else {
    noticias[i].style.color = "blue";
  }
}
