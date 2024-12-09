#include <stdio.h>
#include <stdlib.h>


int main() {

    float p;
    float h;
    float i;

    printf("Entre com seu peso em quilogramas: ");
    scanf("%f", &p);
    printf("Entre com sua altura em metros: ");
    scanf("%f", &h);

    i = p/(h*h);

    if (i < 17){
        printf("IMC: %.2f\n", i);
        printf("Voce esta muito abaixo do peso ideal!");
    } else if (17 <= i && i< 18.5){
        printf("IMC: %.2f\n", i);
        printf("Voce esta abaixo do peso ideal!");
    } else if (18.5 <= i && i < 25){
        printf("IMC: %.2f\n", i);
        printf("Parabens! voce esta em seu peso normal");
    } else if (25 <= i && i < 30){
        printf("IMC: %.2f\n", i);
        printf("Atencao, voce esta acima de seu peso (sobrepeso)!");
    } else if (30 <= i && i < 35){
        printf("IMC: %.2f\n", i);
        printf("Cuidado! Obesidade grau I!");
    } else if (35 <= i && i < 40){
        printf("IMC: %.2f\n", i);
        printf("Cuidado! Obesidade grau II!");
    } else {
        printf("IMC: %.2f\n", i);
        printf("Muito cuidado!!! Obesidade grau III");
    }

    return 0;
}