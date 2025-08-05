function myFunction(){
    const now = new Date();

    const dia = now.getDate(); 
    const mes = now.getMonth() + 1;
    const ano = now.getFullYear();

    document.getElementById('data').textContent = `Hoje é ${dia} de ${mes} de ${ano}`;
}

// Chama a função assim que o script carregar (com defer, o HTML já estará pronto)
myFunction();
