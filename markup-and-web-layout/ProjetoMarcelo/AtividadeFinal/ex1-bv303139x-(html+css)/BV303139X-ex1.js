function myFunction() {
  let palavra = document.getElementById("palavra").value;
  let invertido = palavra.split("").reverse().join("");
  document.getElementById("ordem").textContent = "Sua entrada: "+palavra;
  document.getElementById("resultado").textContent = "Sua entrada ao contrario: "+invertido;
}

