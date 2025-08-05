function encontrarIndice(vetor, valor) {
  for (let i = 0; i < vetor.length; i++) {
    if (vetor[i] === valor) {
      return i;
    }
  }
  return -1;
}

function buscarValor() {
  const vetor = [10, 20, 30, 40, 50];
  const valor = parseInt(document.getElementById("valor").value);
  const indice = encontrarIndice(vetor, valor);

  const resultado = document.getElementById("resultado");

  if (indice !== -1) {
    resultado.textContent = `Valor encontrado na posição: ${indice}`;
  } else {
    resultado.textContent = "Valor não encontrado (retorno -1)";
  }
}
