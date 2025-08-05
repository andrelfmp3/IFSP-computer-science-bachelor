function myFunction() {
  const palavra1 = document.getElementById("palavra1").value;
  const palavra2 = document.getElementById("palavra2").value;
  const palavra3 = document.getElementById("palavra3").value;

  const resultado = [palavra1, palavra2, palavra3].join(" ; ");

  document.getElementById("resultado").textContent = "Sua entrada junta: " + resultado;
}
