const resaltarAnimales = document.getElementById("#resaltarAnimales");

const ANIMALES = document.querySelectorAll(".animal");

for (const animal of ANIMALES) {
  animal.style.backgroundColor = "lightyellow";
}

resaltarAnimales.addEventListener("click", function () {
  for (const animal of ANIMALES) {
    animal.style.color = "green";
    animal.style.fontSize = "20px";
  }
});
