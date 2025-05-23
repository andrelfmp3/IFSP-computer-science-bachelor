/** Autor André Lyra Fernandes bv303139x implementado 8/5  */

console.log("Teste console");

function myFunction (){
    // document.write("Teste documento");

    var mensagem = "Resultado";
    var separador = ": ";
    var x = 5;
    var y = 6;
    var z = x + y;

    window.alert(mensagem + separador + z); // Exibe "Resultado: 11"
}

function multiplicar(p1, p2){
    return p1*p2
}

myFunction();

console.log("Multiplicar: " + multiplicar(2,4));

