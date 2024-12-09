#include <stdio.h>
#include <stdlib.h>

int main() {

    float numero1;
    float numero2;

    float adicao;
    float subtracao;
    float multiplicacao;
    float divisao;

    printf("Primeiro numero: ");
    scanf( "%f",&numero1 );

    printf("Segundo numero: ");
    scanf( "%f",&numero2 );

    adicao = numero1 + numero2;
    subtracao = numero1 - numero2;
    multiplicacao = numero1 * numero2;
    divisao = numero1 / numero2;

    printf("%.2f + %.2f = %.2f\n", numero1, numero2, adicao);
    printf("%.2f - %.2f = %.2f\n", numero1, numero2, subtracao);
    printf("%.2f * %.2f = %.2f\n", numero1, numero2, multiplicacao);
    printf("%.2f / %.2f = %.2f\n", numero1, numero2, divisao);

    return 0;
}