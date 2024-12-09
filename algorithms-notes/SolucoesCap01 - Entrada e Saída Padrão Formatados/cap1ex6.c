#include <stdio.h>
#include <stdlib.h>

int main() {

    int numero1;
    int numero2;

    int adicao;
    int subtracao;
    int multiplicacao;
    int divisao;

    printf( "Primeiro numero:");
    scanf( "%d",&numero1 );

    printf( "Segundo numero:" );
    scanf( "%d",&numero2 );

    adicao = numero1 + numero2;
    subtracao = numero1 - numero2;
    multiplicacao = numero1 * numero2;
    divisao = numero1 / numero2;


    printf( "%d + %d = %d\n", numero1, numero2, adicao);
    printf( "%d - %d = %d\n", numero1, numero2, subtracao);
    printf( "%d * %d = %d\n", numero1, numero2, multiplicacao);
    printf( "%d / %d = %d", numero1, numero2, divisao);

    return 0;
}

