#include <stdio.h>
#include <stdlib.h>

int main (){

    int numero;
    int fatorial;

    fatorial = 1;

    printf("Numero: ");
    scanf("%d", &numero);

    if (numero >= 0){
        for(int i = numero; 0 < i; i--){
            fatorial = fatorial*i;
        }
        printf("%d! = %d", numero, fatorial);
    }else{
        printf("Nao ha fatorial de numero negativo.");
    }

    return 0;
} 