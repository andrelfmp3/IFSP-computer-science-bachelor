function myFunction() {
  // Captura os valores 
  let number1 = parseInt(document.getElementById("number1").value);
  let number2 = parseInt(document.getElementById("number2").value);
  let number3 = parseInt(document.getElementById("number3").value);

  //  original
  let vetorOriginal = [number1, number2, number3];

  //  valores em ordem decrescente
  let vetorOrdenado = [...vetorOriginal].sort((a, b) => b - a);

  document.getElementById("ordem").textContent = "Vetor original: [" + vetorOriginal.join(", ") + "]";
  document.getElementById("resultado").textContent = "Vetor em ordem decrescente: [" + vetorOrdenado.join(", ") + "]";
}
