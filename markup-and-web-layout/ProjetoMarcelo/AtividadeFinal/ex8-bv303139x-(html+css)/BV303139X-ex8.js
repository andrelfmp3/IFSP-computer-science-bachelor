document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("buscaForm");
  form.addEventListener("submit", function (event) {
    event.preventDefault(); // evita recarregar a página
    buscarString();
  });
});

function buscarString() {
   const palavras = [
    "Batman", "Asa Noturna", "Batgirl (Barbara Gordon)", "Mulher Gato (Selina)", "Red Hood",
    "Red Robin (Tim Drake)", "Batwoman", "Spoiler (Stephanie Brown)", "Orphan (Cassandra Cain)", "Azrael", "Alfred Pennyworth"
  ];

  const imagens = [
    "https://i.pinimg.com/736x/85/a9/3c/85a93cf1fa8d2696d14db0e98fcd1118.jpg",
    "https://i.pinimg.com/736x/14/cc/d9/14ccd9eb2fb5325d02fbb6fac980a36b.jpg",
    "https://i.pinimg.com/736x/37/03/64/370364cf75d6e14a120d58bcb024eb9d.jpg",
    "https://i.pinimg.com/736x/d0/92/ed/d092ed6d52be3c4500ebef8df8538279.jpg",
    "https://i.pinimg.com/736x/65/34/74/65347446ee974151cae227390656b538.jpg",
    "https://i.pinimg.com/736x/b1/ad/68/b1ad6865671e9b96d77081326eabb071.jpg",
    "https://i.pinimg.com/736x/b8/52/3e/b8523e860ed14b54b4b73ac6ba5432c4.jpg",
    "https://i.pinimg.com/736x/cd/97/6d/cd976d144d21eaf6d6fd61fa6113531d.jpg",
    "https://i.pinimg.com/736x/74/c6/4a/74c64ac7d045f1615faa82da43ca5f16.jpg",
    "https://i.pinimg.com/736x/34/46/79/3446792cdf86cd9d5209632c79c6f0a9.jpg",
    "https://i.pinimg.com/736x/57/4e/4f/574e4f86e15df94be45ed6f912ea9abc.jpg"
  ];
  const inputElement = document.getElementById("posicao");
  const resultadoDiv = document.getElementById("resultado");

  const indice = parseInt(inputElement.value.trim(), 10);

  if (isNaN(indice) || indice < 0 || indice >= palavras.length) {
    resultadoDiv.innerHTML = `Por favor, digite um número válido entre 0 e ${palavras.length - 1}.`;
    return;
  }

  resultadoDiv.innerHTML = `
    <p>A string na posição ${indice} é: <strong>${palavras[indice]}</strong></p>
    <img src="${imagens[indice]}" alt="${palavras[indice]}" />
  `;
}
