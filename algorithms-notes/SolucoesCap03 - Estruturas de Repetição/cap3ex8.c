#include <stdio.h>
#include <stdlib.h>

int main() {

    int numeroinserido;

    printf("Forneca um numero menor ou igual a zero: ");
    scanf("%d", &numeroinserido);

    if (numeroinserido > 0){
        printf("Valor incorreto (positivo)");
    } else {
        for (int i = 0; i >= numeroinserido; i-- ){
            printf("%d ", i);
        }
    }

    return 0;
}