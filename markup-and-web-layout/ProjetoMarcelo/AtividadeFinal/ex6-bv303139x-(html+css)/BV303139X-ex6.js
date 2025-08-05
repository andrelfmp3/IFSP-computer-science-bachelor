function myFunction() {
  let palavra = document.getElementById("palavra").value;
  let remover = palavra.replace(/[aeiou]/gi, "")
  document.getElementById("ordem").textContent = "Sua entrada: "+palavra;
  document.getElementById("resultado").textContent = "Sua entrada sem vogais: "+remover;
}