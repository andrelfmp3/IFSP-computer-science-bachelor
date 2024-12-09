#include <stdio.h>
#include <stdlib.h>

int main() {

    int numero;

    printf("Forneca um numero menor ou igual a zero: ");
    scanf("%d", &numero);

    if (numero <= 0 ){
        for(int i = numero; i <= 0; i++ ){
            printf("%d ", i);
            }
    } else {
        printf("Valor incorreto (positivo)");
    }

    return 0;
}