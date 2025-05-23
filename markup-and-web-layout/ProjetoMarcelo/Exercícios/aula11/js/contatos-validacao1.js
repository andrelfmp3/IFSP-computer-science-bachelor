/* 
André Lyra Fernandes bv303139x
Data de implementação: 22/05/2025
 */
document.getElementById("teste").onclick = function(){
    alert("ClICOU NO BOTÂO TESTAR");
    document.body.style.background = "lightblue";
}

function minhaFuncao(){
    var botaoTeste = document.getElementById("teste").value
    console.log("Conteúdo do Botão Testar: " + botaoTeste);
}

function mDown(objBotao) {
    objBotao.style.background = "black"
    objBotao.style.color = "white"
    objBotao.value = "SOLTE"
}

function mUp(objBotao) {
    objBotao.style.background = "aqua"
    objBotao.style.color = "black"
    objBotao.value = "AQUA"
}

/* minhaFuncao(); */

function validateForm() {

    var nome = document.forms["contatosForm"]["usuario_nome"].value;
    var email = document.forms["contatosForm"]["usuario_email"].value;
    var msg = document.forms["contatosForm"]["usuario_msg"].value;



    if (nome == null || nome === "") {
        alert("ATENÇÃO! Nome inválido");
        return false;
    }

    if (email == null || email === "") {
        alert("ATENÇÃO! Email inválido");
        return false;
    }

    if (msg == null || msg === "") {
        alert("ATENÇÃO! Mensagem inválida");
        return false;
    }

    return true;
}


