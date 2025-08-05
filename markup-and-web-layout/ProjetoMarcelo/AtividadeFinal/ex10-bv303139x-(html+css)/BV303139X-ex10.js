document.addEventListener("DOMContentLoaded", () => {
  
      const form = document.getElementById("loginForm");
      const mensagemDiv = document.getElementById("mensagem");

      const nomeCompletoCorreto = "Andre Lyra Fernandes";
      const prontuarioCorreto = "BV303139X";

      form.addEventListener("submit", (event) => {
        event.preventDefault();
        mensagemDiv.innerHTML = "";

        const login = form.login.value.trim();
        const senha = form.senha.value.trim();

        const p = document.createElement("p");

        if (!login || !senha) {
          p.textContent = "Por favor, preencha todos os campos.";
          p.style.color = "orange";
          mensagemDiv.appendChild(p);
          return;
        }

        if (login === nomeCompletoCorreto && senha === prontuarioCorreto) {
          p.textContent = "Login realizado com sucesso!";
          p.style.color = "lightgreen";
          mensagemDiv.appendChild(p);
        } else {
          p.textContent = "Login ou senha incorretos. Tente novamente.";
          p.style.color = "red";
          mensagemDiv.appendChild(p);
        }
      });
    });