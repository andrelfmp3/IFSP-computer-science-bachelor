document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("identificadorForm");

  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Evita o reload da página

    const senha = document.getElementById("senha").value.trim();
    const senha2 = document.getElementById("senha2").value.trim();

    validarTextos(senha, senha2);
  });
});

function validarTextos(senha, senha2) {
  if (senha === senha2) {
    console.log("Os textos são iguais (estritamente).");
    alert("As senhas são iguais!");
  } else {
    console.log("Os textos são diferentes (estritamente).");
    alert("As senhas são diferentes!");
  }
}
